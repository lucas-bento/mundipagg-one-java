package DataContracts.BoletoTransaction

import DataContracts.Order.OrderReport
import EnumTypes.BoletoTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Resultado de transação de boleto
 */
class BoletoTransactionReport {

    /**
     * Pedido
     */
    val order: OrderReport = OrderReport()

    /**
     * Valor original do boleto em centavos
     */
    var amountInCents: Long? = null

    /**
     * Valor total pago em centavos
     */
    var amountPaidInCents: Long? = null

    /**
     * Código de barras do boleto
     */
    var barcode: String? = null

    /**
     * Status do boleto
     */
    var status: BoletoTransactionStatusEnum? = null

    /**
     * Identificador do boleto
     */
    var nossoNumero: String? = null

    /**
     * Chave da transação. Utilizada para identificar a transação de boleto no gateway
     */
    var transactionKey: UUID? = null

    /**
     * Identificador da transação no sistema da loja
     */
    var transactionReference: String? = null

    /**
     * Número do banco
     */
    var bankNumber: String? = null

    /**
     * Número da agência
     */
    var agency: String? = null

    /**
     * Número da conta
     */
    var account: String? = null

    /**
     * Data de crédito
     */
    var creditDate: Date? = null

    /**
     * Data de Pagamento
     */
    var paymentDate: Date? = null

    /**
     * Data de expiração do boleto
     */
    var expirationDate: Date? = null

}