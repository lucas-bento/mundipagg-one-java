package Utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import DataContracts.ErrorItem;
import DataContracts.ErrorReport;
import DataContracts.SaleOptions;
import DataContracts.ServiceConstants;
import DataContracts.Address.BillingAddress;
import DataContracts.Address.BuyerAddress;
import DataContracts.Address.DeliveryAddress;
import DataContracts.AntiFraud.AntiFraudAnalysis;
import DataContracts.AntiFraud.AntiFraudAnalysisHistory;
import DataContracts.AntiFraud.AntiFraudAnalysisResult;
import DataContracts.BoletoTransaction.BoletoTransaction;
import DataContracts.BoletoTransaction.BoletoTransactionData;
import DataContracts.BoletoTransaction.BoletoTransactionNotification;
import DataContracts.BoletoTransaction.BoletoTransactionOptions;
import DataContracts.BoletoTransaction.BoletoTransactionResult;
import DataContracts.CreditCardTransaction.CreditCard;
import DataContracts.CreditCardTransaction.CreditCardTransaction;
import DataContracts.CreditCardTransaction.CreditCardTransactionData;
import DataContracts.CreditCardTransaction.CreditCardTransactionNotification;
import DataContracts.CreditCardTransaction.CreditCardTransactionOptions;
import DataContracts.CreditCardTransaction.CreditCardTransactionResult;
import DataContracts.CreditCardTransaction.ManageCreditCardTransaction;
import DataContracts.CreditCardTransaction.RetrySaleCreditCardTransaction;
import DataContracts.InstantBuy.CreditCardData;
import DataContracts.InstantBuy.GetInstantBuyDataResponse;
import DataContracts.Merchant.Merchant;
import DataContracts.OnlineDebitTransaction.OnlineDebitTransactionNotification;
import DataContracts.Order.Order;
import DataContracts.Order.OrderData;
import DataContracts.Order.OrderResult;
import DataContracts.Person.Buyer;
import DataContracts.PostNotification.StatusNotification;
import DataContracts.Recurrency.Recurrency;
import DataContracts.Sale.CreateSaleRequest;
import DataContracts.Sale.CreateSaleResponse;
import DataContracts.Sale.ManageSaleRequest;
import DataContracts.Sale.ManageSaleResponse;
import DataContracts.Sale.QuerySaleResponse;
import DataContracts.Sale.RequestData;
import DataContracts.Sale.RetrySaleOptions;
import DataContracts.Sale.RetrySaleRequest;
import DataContracts.Sale.RetrySaleResponse;
import DataContracts.Sale.SaleData;
import DataContracts.ShoppingCart.ShoppingCart;
import DataContracts.ShoppingCart.ShoppingCartItem;
import EnumTypes.HttpContentTypeEnum;
import Utility.XmlConverter.DateConverter;
import Utility.XmlConverter.DoubleConverter;
import Utility.XmlConverter.FloatConverter;
import Utility.XmlConverter.IntegerConverter;
import Utility.XmlConverter.LongConverter;

/**
 * Utilitário para serializar e deserializar
 * @param <TObject>
 */
public class SerializeUtility<TObject> {

    /**
     * Construtor da Classe
     */
    public SerializeUtility(){}

    /**
     * Serializa objeto para string no formato especificado
     * @param obj
     * @param ContentType
     * @return
     */
    public String Serialize(TObject obj, HttpContentTypeEnum ContentType)
    {
        // Cria variavel local
        String serialized = "";

        // Se obj nulo, retorna string empty
        if(obj == null)
        {
            return serialized;
        }

        // Verifica e serializa em xml ou json
        if(HttpContentTypeEnum.Json == ContentType)
        {
            // Converte objeto para string Json
            Gson gson = new GsonBuilder().setDateFormat(ServiceConstants.DATE_TIME_FORMAT).create();
            serialized = gson.toJson(obj);
        }
        else if(HttpContentTypeEnum.Xml == ContentType)
        {
            // Converte objeto para string Xml
            XStream xstream = InitiXmlConverter(null);
            serialized = xstream.toXML(obj);
        }

        // retorna string serializada
        return serialized;
    }

    /**
     * Deserializa string no formato especificado para objeto
     * @param TypeOfResponse
     * @param Serialized
     * @param ContentType
     * @return
     */
    public TObject Deserializer(Class<TObject> TypeOfResponse, String Serialized, HttpContentTypeEnum ContentType)
    {
        // Cria variavel local
        TObject obj = null;

        // Se string a deserializar vazia/nula, retorna null
        if(Serialized == null || Serialized.isEmpty())
        {
            return obj;
        }

        // Verifica e deserializa em xml ou json
        if(HttpContentTypeEnum.Json == ContentType)
        {
            // Converte string Json para objeto
            Gson gson = new GsonBuilder().setDateFormat(ServiceConstants.DATE_TIME_FORMAT).create();
            obj = gson.fromJson(Serialized, TypeOfResponse);
        }
        else if(HttpContentTypeEnum.Xml == ContentType)
        {
            // Converte string Xml para objeto
            XStream xstream = InitiXmlConverter(TypeOfResponse);
            obj = TypeOfResponse.cast(xstream.fromXML(Serialized));
        }

        // retorna obj deserializado
        return obj;
    }

    /**
     * Inicializa, Configura e retorna objeto responsavel por serializar/deserializar XML
     * @param TypeOfResponse
     * @return
     */
    private XStream InitiXmlConverter(Class<TObject> TypeOfResponse)
    {
        // Inicializa objeto que fará a serialização/deserialização
        XStream xstream = new XStream() {
            // Ignora campos desconhecidos na deserialização
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        return definedIn != Object.class ? super.shouldSerializeMember(definedIn, fieldName) : false;
                    }
                };
            }
        };

        // Registra conversores
        xstream.registerConverter(new DateConverter());
        xstream.registerConverter(new IntegerConverter());
        xstream.registerConverter(new LongConverter());
        xstream.registerConverter(new FloatConverter());
        xstream.registerConverter(new DoubleConverter());

        // Registra mapeamento de nome de classes classes
        xstream.alias("AntiFraudAnalysisData", AntiFraudAnalysis.class);
        xstream.alias("QuerySaleAntiFraudAnalysisHistory", AntiFraudAnalysisHistory.class);
        xstream.alias("AntiFraudAnalysisResult", AntiFraudAnalysisResult.class);
        xstream.alias("BillingAddress", BillingAddress.class);
        xstream.alias("BuyerAddress", BuyerAddress.class);
        xstream.alias("DeliveryAddress", DeliveryAddress.class);
        xstream.alias("BoletoTransaction", BoletoTransaction.class);
        xstream.alias("BoletoTransactionData", BoletoTransactionData.class);
        xstream.alias("BoletoTransactionOptions", BoletoTransactionOptions.class);
        xstream.alias("BoletoTransactionResult", BoletoTransactionResult.class);
        xstream.alias("CreditCard", CreditCard.class);
        xstream.alias("CreditCardTransaction", CreditCardTransaction.class);
        xstream.alias("CreditCardTransactionData", CreditCardTransactionData.class);
        xstream.alias("CreditCardTransactionOptions", CreditCardTransactionOptions.class);
        xstream.alias("CreditCardTransactionResult", CreditCardTransactionResult.class);
        xstream.alias("ManageCreditCardTransaction", ManageCreditCardTransaction.class);
        xstream.alias("RetrySaleCreditCardTransaction", RetrySaleCreditCardTransaction.class);
        xstream.alias("GetInstantBuyDataResponse", GetInstantBuyDataResponse.class);
        xstream.alias("Merchant", Merchant.class);
        xstream.alias("Order", Order.class);
        xstream.alias("OrderData", OrderData.class);
        xstream.alias("OrderResult", OrderResult.class);
        xstream.alias("Buyer", Buyer.class);
        xstream.alias("Recurrency", Recurrency.class);
        xstream.alias("Sale", SaleData.class);
        xstream.alias("SaleOptions", SaleOptions.class);
        xstream.alias("CreateSaleRequest", CreateSaleRequest.class);
        xstream.alias("CreateSaleResponse", CreateSaleResponse.class);
        xstream.alias("ManageSaleRequest", ManageSaleRequest.class);
        xstream.alias("ManageSaleResponse", ManageSaleResponse.class);
        xstream.alias("QuerySaleResponse", QuerySaleResponse.class);
        xstream.alias("RequestData", RequestData.class);
        xstream.alias("RetrySaleOptions", RetrySaleOptions.class);
        xstream.alias("RetrySaleResquest", RetrySaleRequest.class);
        xstream.alias("RetrySaleResponse", RetrySaleResponse.class);
        xstream.alias("ErrorItem", ErrorItem.class);
        xstream.alias("ErrorReport", ErrorReport.class);
        xstream.alias("ShoppingCartItem", ShoppingCartItem.class);
        xstream.alias("ShoppingCart", ShoppingCart.class);
        xstream.alias("StatusNotification", StatusNotification.class);

        // Registra classes conflitantes de acordo com o tipo solicitado para a deserialização
        if(TypeOfResponse == GetInstantBuyDataResponse.class)
        {
            xstream.alias("CreditCard", CreditCardData.class);
        }
        if(TypeOfResponse == StatusNotification.class)
        {
            xstream.alias("CreditCardTransaction", CreditCardTransactionNotification.class);
            xstream.alias("BoletoTransaction", BoletoTransactionNotification.class);
            xstream.alias("OnlineDebitTransaction", OnlineDebitTransactionNotification.class);
        }

        return xstream;
    }
}
