package DataContracts.CreditCardTransaction

import DataContracts.Order.OrderReport
import EnumTypes.CreditCardBrandEnum
import EnumTypes.CreditCardTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados de relatório de transação de cartão de crédito
 */
class CreditCardTransactionReport {
    /**
     * Pedido
     */
    var order: OrderReport = OrderReport()

    /**
     * Código de autorização retornado pela adquirente
     */
    var acquirerAuthorizationReturnCode: String? = null

    /**
     * Nome da adquirente que processou a transação
     */
    var acquirerName: String? = null

    /**
     * Valor original da transação em centavos
     */
    var amountInCents: Long? = null

    /**
     * Bandeira do cartão de crédito
     */
    var creditCardBrand: CreditCardBrandEnum? = null

    /**
     * Número do cartão de crédito
     */
    var creditCardNumber: String? = null

    /**
     * Total de parcelas da transação
     */
    var installmentCount: Int? = null

    /**
     * Valor autorizado em centavos
     */
    var authorizedAmountInCents: Long? = null

    /**
     * Valor capturado em centavos
     */
    var capturedAmountInCents: Long? = null

    /**
     * Valor cancelado em centavos
     */
    var voidedAmountInCents: Long? = null

    /**
     * Valor estornado em centavos
     */
    var refundedAmountInCents: Long? = null

    /**
     * Iata - Valor em centavos
     */
    var iataAmountInCents: Long? = null

    /**
     * Status da transação de cartão de crédito
     */
    var status: CreditCardTransactionStatusEnum? = null

    /**
     * Identificador da transação gerado pela loja.
     */
    var transactionIdentifier: String? = null

    /**
     * Chave da transação. Utilizada para identificar a transação de cartão de crédito no gateway
     */
    var transactionKey: UUID? = null

    /**
     * Identificador da transação no sistema da loja
     */
    var transactionReference: String? = null

    /**
     * Código de autorização
     */
    var authorizationCode: String? = null

    /**
     * Identificador único retornado pela adquirente
     */
    var uniqueSequentialNumber: String? = null

    /**
     * Chave da transação na adquirente, enviada pelo gateway
     */
    var transactionKeyToAcquirer: String? = null

    /**
     * Data da autorização
     */
    var authorizedDate: Date? = null

    /**
     * Data da ultima sonda
     */
    var lastProbeDate: Date? = null

    /**
     * Data da captura
     */
    var capturedDate: Date? = null

    /**
     * Data de cancelamento
     */
    var voidedDate: Date? = null
}

