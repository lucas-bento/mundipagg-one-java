package Utility

import Utility.XmlConverter.*
import DataContracts.*
import DataContracts.Address.*
import DataContracts.AntiFraud.*
import DataContracts.BoletoTransaction.*
import DataContracts.CreditCardTransaction.*
import DataContracts.InstantBuy.*
import DataContracts.Merchant.*
import DataContracts.OnlineDebitTransaction.OnlineDebitTransactionNotification
import DataContracts.Order.*
import DataContracts.Person.*
import DataContracts.PostNotification.StatusNotification
import DataContracts.Recurrency.*
import DataContracts.Sale.*
import DataContracts.ShoppingCart.*
import DataContracts.ServiceConstants
import EnumTypes.HttpContentTypeEnum
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.thoughtworks.xstream.XStream

/**
 * Utilitário para serializar e deserializar
 * @param
 */
class SerializeUtility<TObject> {

    /**
     * Serializa objeto para string no formato especificado
     * @param obj
     * @param ContentType
     * @return
     */
    fun Serialize(obj: TObject?, ContentType: HttpContentTypeEnum): String {
        // Cria variavel local
        var serialized = ""

        // Se obj nulo, retorna string empty
        if (obj == null) {
            return serialized
        }

        // Verifica e serializa em xml ou json
        if (HttpContentTypeEnum.Json == ContentType) {
            // Converte objeto para string Json
            val gson = GsonBuilder().setDateFormat(ServiceConstants.DATE_TIME_FORMAT).create()
            serialized = gson.toJson(obj)
        } else if (HttpContentTypeEnum.Xml == ContentType) {
            // Converte objeto para string Xml
            val xstream = InitiXmlConverter(null)
            serialized = xstream.toXML(obj)
        }

        // retorna string serializada
        return serialized
    }

    /**
     * Deserializa string no formato especificado para objeto
     * @param TypeOfResponse
     * @param Serialized
     * @param ContentType
     * @return
     */
    fun Deserializer(TypeOfResponse: Class<TObject>, Serialized: String, ContentType: HttpContentTypeEnum): TObject {
        when(ContentType){
            HttpContentTypeEnum.Json->{
                // Converte string Json para objeto
                val gson = GsonBuilder().setDateFormat(ServiceConstants.DATE_TIME_FORMAT).create()
                return gson.fromJson(Serialized, TypeOfResponse)
            }
            HttpContentTypeEnum.Xml->{
                // Converte string Xml para objeto
                val xstream = InitiXmlConverter(TypeOfResponse)
                return  TypeOfResponse.cast(xstream.fromXML(Serialized))
            }
        }
    }

    /**
     * Inicializa, Configura e retorna objeto responsavel por serializar/deserializar XML
     * @param TypeOfResponse
     * @return
     */
    private fun InitiXmlConverter(TypeOfResponse: Class<TObject>?): XStream {
        // Inicializa objeto que fará a serialização/deserialização
        val xstream = XStream()

        // Registra conversores 
        xstream.registerConverter(DateConverter())
        xstream.registerConverter(IntegerConverter())
        xstream.registerConverter(LongConverter())
        xstream.registerConverter(FloatConverter())
        xstream.registerConverter(DoubleConverter())

        // Registra mapeamento de nome de classes classes 
        xstream.alias("AntiFraudAnalysisData", AntiFraudAnalysis::class.java)
        xstream.alias("QuerySaleAntiFraudAnalysisHistory", AntiFraudAnalysisHistory::class.java)
        xstream.alias("AntiFraudAnalysisResult", AntiFraudAnalysisResult::class.java)
        xstream.alias("BillingAddress", BillingAddress::class.java)
        xstream.alias("BuyerAddress", BuyerAddress::class.java)
        xstream.alias("DeliveryAddress", DeliveryAddress::class.java)
        xstream.alias("BoletoTransaction", BoletoTransaction::class.java)
        xstream.alias("BoletoTransactionData", BoletoTransactionData::class.java)
        xstream.alias("BoletoTransactionOptions", BoletoTransactionOptions::class.java)
        xstream.alias("BoletoTransactionResult", BoletoTransactionResult::class.java)
        xstream.alias("CreditCard", CreditCard::class.java)
        xstream.alias("CreditCardTransaction", CreditCardTransaction::class.java)
        xstream.alias("CreditCardTransactionData", CreditCardTransactionData::class.java)
        xstream.alias("CreditCardTransactionOptions", CreditCardTransactionOptions::class.java)
        xstream.alias("CreditCardTransactionResult", CreditCardTransactionResult::class.java)
        xstream.alias("ManageCreditCardTransaction", ManageCreditCardTransaction::class.java)
        xstream.alias("RetrySaleCreditCardTransaction", RetrySaleCreditCardTransaction::class.java)
        xstream.alias("GetInstantBuyDataResponse", GetInstantBuyDataResponse::class.java)
        xstream.alias("Merchant", Merchant::class.java)
        xstream.alias("Order", Order::class.java)
        xstream.alias("OrderData", OrderData::class.java)
        xstream.alias("OrderResult", OrderResult::class.java)
        xstream.alias("Buyer", Buyer::class.java)
        xstream.alias("Recurrency", Recurrency::class.java)
        xstream.alias("Sale", SaleData::class.java)
        xstream.alias("SaleOptions", SaleOptions::class.java)
        xstream.alias("CreateSaleRequest", CreateSaleRequest::class.java)
        xstream.alias("CreateSaleResponse", CreateSaleResponse::class.java)
        xstream.alias("ManageSaleRequest", ManageSaleRequest::class.java)
        xstream.alias("ManageSaleResponse", ManageSaleResponse::class.java)
        xstream.alias("QuerySaleResponse", QuerySaleResponse::class.java)
        xstream.alias("RequestData", RequestData::class.java)
        xstream.alias("RetrySaleOptions", RetrySaleOptions::class.java)
        xstream.alias("RetrySaleResquest", RetrySaleRequest::class.java)
        xstream.alias("RetrySaleResponse", RetrySaleResponse::class.java)
        xstream.alias("ErrorItem", ErrorItem::class.java)
        xstream.alias("ErrorReport", ErrorReport::class.java)
        xstream.alias("ShoppingCartItem", ShoppingCartItem::class.java)
        xstream.alias("ShoppingCart", ShoppingCart::class.java)
        xstream.alias("StatusNotification", StatusNotification::class.java)

        // Registra classes conflitantes de acordo com o tipo solicitado para a deserialização
        if (TypeOfResponse == GetInstantBuyDataResponse::class.java) {
            xstream.alias("CreditCard", CreditCardData::class.java)
        }
        if (TypeOfResponse == StatusNotification::class.java) {
            xstream.alias("CreditCardTransaction", CreditCardTransactionNotification::class.java)
            xstream.alias("BoletoTransaction", BoletoTransactionNotification::class.java)
            xstream.alias("OnlineDebitTransaction", OnlineDebitTransactionNotification::class.java)
        }

        return xstream
    }
}

