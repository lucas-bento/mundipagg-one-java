package DataContracts.Sale

import DataContracts.AntiFraud.AntiFraudAnalysis
import DataContracts.BoletoTransaction.BoletoTransactionData
import DataContracts.CreditCardTransaction.CreditCardTransactionData
import DataContracts.Order.OrderData
import java.util.UUID

/**
 * Dados da venda
 */
class SaleData {

    /**
     * Dados do serviço de antifraude
     */
    /**
     * Recupera Dados do serviço de antifraude
     * @return
     */
    /**
     * Altera Dados do serviço de antifraude
     * @param AntiFraudAnalysisData
     */
    var antiFraudAnalysisData: AntiFraudAnalysis? = null

    /**
     * Chave do comprador. Utilizada para identificar um comprador no gateway
     */
    /**
     * Recupera Chave do comprador. Utilizada para identificar um comprador no gateway
     * @return
     */
    /**
     * Altera Chave do comprador. Utilizada para identificar um comprador no gateway
     * @param BuyerKey
     */
    var buyerKey: UUID? = null

    /**
     * Lista de transações de boleto
     */
    /**
     * Recupera Lista de transações de boleto
     * @return
     */
    /**
     * Altera Lista de transações de boleto
     * @param BoletoTransactionDataCollection
     */
    var boletoTransactionDataCollection: List<BoletoTransactionData>? = null

    /**
     * Lista de transações de cartão de crédito
     */
    /**
     * Recupera Lista de transações de cartão de crédito
     * @return
     */
    /**
     * Altera Lista de transações de cartão de crédito
     * @param CreditCardTransactionDataCollection
     */
    var creditCardTransactionDataCollection: List<CreditCardTransactionData>? = null

    /**
     * Dados do pedido
     */
    /**
     * Recupera dados do pedido
     * @return
     */
    /**
     * Altera dados do pedido
     * @param OrderData
     */
    var orderData: OrderData? = null
}
/**
 * Construtor da Classe
 */
