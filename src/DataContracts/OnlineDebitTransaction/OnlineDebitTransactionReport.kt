package DataContracts.OnlineDebitTransaction

import DataContracts.Order.OrderReport
import EnumTypes.OnlineDebitTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados do relatorio de transação de débito online
 */
class OnlineDebitTransactionReport {
    /**
     * Pedido
     */
    var order: OrderReport = OrderReport()

    /**
     * Valor original em centavos
     */
    var amountInCents: Long? = null

    /**
     * Valor total pago em centavos
     */
    var amountPaidInCents: Long? = null

    /**
     * Data de pagamento
     */
    var paymentDate: Date? = null

    /**
     * Chave da transação. Utilizada para identificar a transação de débito online no gateway
     */
    var transactionKey: UUID? = null

    /**
     * Identificador da transação no sistema da loja
     */
    var transactionReference: String? = null

    /**
     * Código de retorno do banco
     */
    var bankReturnCode: String? = null

    /**
     * Data de pagamento no banco
     */
    var bankPaymentDate: String? = null

    /**
     * Assinatura
     */
    var signature: String? = null

    /**
     * Nome do banco
     */
    var bank: String? = null

    /**
     * Chave da transação para o banco
     */
    var transactionKeyToBank: String? = null

    /**
     * Status atual da transação de débito online
     */
    var status: OnlineDebitTransactionStatusEnum? = null

}
