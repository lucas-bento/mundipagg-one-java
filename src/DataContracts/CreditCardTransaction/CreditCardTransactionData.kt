package DataContracts.CreditCardTransaction

import DataContracts.InstantBuy.CreditCardData
import EnumTypes.CreditCardTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados da transação de cartão de crédito
 */
class CreditCardTransactionData {

    /**
     * Código de autorização retornado pela adquirente
     */
    /**
     * Recupera codigo de autorização na adquirente
     * @return
     */
    /**
     * Altera codigo de autorização na adquirente
     * @param AcquirerAuthorizationCode
     */
    var acquirerAuthorizationCode: String? = null

    /**
     * Nome da adquirente que processou a transação
     */
    /**
     * Recupera nome da adquirente
     * @return
     */
    /**
     * Altera nome da Adquirente
     * @param AcquirerName
     */
    var acquirerName: String? = null

    /**
     * Código de retorno da adquirente
     */
    /**
     * Recupera código de retorno da adquirente
     * @return
     */
    /**
     * Altera código de retorno da adquirente
     * @param AcquirerReturnCode
     */
    var acquirerReturnCode: String? = null

    /**
     * Código da filiação da loja na adquirente
     */
    /**
     * Recupera codigo da afiliação
     * @return
     */
    /**
     * Altera código da afiliação
     * @param AffiliationCode
     */
    var affiliationCode: String? = null

    /**
     * Valor original da transação em centavos
     */
    /**
     * Recupera valor da transação em centavos
     * @return
     */
    /**
     * Altera valor da transação em centavos
     * @param AmountInCents
     */
    var amountInCents: Long? = null

    /**
     * Valor autorizado em centavos
     */
    /**
     * Recupera valor autorizado da transação em centavos
     * @return
     */
    /**
     * Altera valor autorizado da transação em centavos
     * @param AuthorizedAmountInCents
     */
    var authorizedAmountInCents: Long? = null

    /**
     * Data limite para a captura da transação na adquirente
     */
    /**
     * Recupera Data limite para a captura da transação na adquirente
     * @return
     */
    /**
     * Altera Data limite para a captura da transação na adquirente
     * @param CaptureExpirationDate
     */
    var captureExpirationDate: Date? = null

    /**
     * Valor capturado em centavos
     */
    /**
     * Recupera valor capturado da transação em centavos
     * @return
     */
    /**
     * Altera valor capturado da transação em centavos
     * @param CapturedAmountInCents
     */
    var capturedAmountInCents: Long? = null

    /**
     * Data da Captura
     */
    /**
     * Recupera Data da captura
     * @return
     */
    /**
     * Altera Data da captura
     * @param CapturedDate
     */
    var capturedDate: Date? = null

    /**
     * Data de criação da transação no gateway
     */
    /**
     * Recupera data de criação
     * @return
     */
    /**
     * Altera data de criação
     * @param CreateDate
     */
    var createDate: Date? = null

    /**
     * Dados do cartão de crédito
     */
    /**
     * Recupera dados do cartão de crédito
     * @return
     */
    /**
     * Altera dados do cartão de crédito
     * @param CreditCard
     */
    var creditCard: CreditCardData? = null

    /**
     * Status da transação de cartão de crédito
     */
    /**
     * Recupera status da transação de cartão de crédito
     * @return
     */
    /**
     * Altera status da transação de cartão de crédito
     * @param CreditCardTransactionStatus
     */
    var creditCardTransactionStatus: CreditCardTransactionStatusEnum? = null

    /**
     * Data da recorrência (poderá ser futura)
     */
    /**
     * Recupera data da recorrencia
     * @return
     */
    /**
     * Altera data da recorrencia
     * @param DueDate
     */
    var dueDate: Date? = null

    /**
     * Total de parcelas da transação
     */
    /**
     * Recupera numero de parcelas
     * @return
     */
    /**
     * Altera numero de parcelas
     * @param InstallmentCount
     */
    var installmentCount: Int? = null

    /**
     * Indica se é uma recorrência
     */
    /**
     * Recupera se é recorrente
     * @return
     */
    /**
     * Altera se é recorrente
     * @param IsReccurency
     */
    var isReccurency: Boolean? = null

    /**
     * Código do método de pagamento
     */
    /**
     * Recupera nome do método de pagamento
     * @return
     */
    /**
     * Altera nome do método de pagamento
     * @param PaymentMethodName
     */
    var paymentMethodName: String? = null

    /**
     * Valor estornado em centavos
     */
    /**
     * Recupera valor estornado da transação em centavos
     * @return
     */
    /**
     * Altera valor estornado da transação em centavos
     * @param RefundedAmountInCents
     */
    var refundedAmountInCents: Long? = null

    /**
     * Identificador da transação gerado pela loja.
     */
    /**
     * Recupera TID (identificador da transação)
     * @return
     */
    /**
     * Altera TID (identificador da transação)
     * @param TransactionIdentifier
     */
    var transactionIdentifier: String? = null

    /**
     * Chave da transação. Utilizada para identificar a transação de cartão de crédito no gateway
     */
    /**
     * Recupera chave da Transação
     * @return
     */
    /**
     * Altera chave da Transação
     * @param TransactionKey
     */
    var transactionKey: UUID? = null

    /**
     * Chave da transação na adquirente, enviada pelo gateway
     */
    /**
     * Recupera Chave da transação para adquirente
     * @return
     */
    /**
     * Altera Chave da transação paraa adquirente
     * @param TransactionKeyToAcquirer
     */
    var transactionKeyToAcquirer: String? = null

    /**
     * Identificador da transação no sistema da loja
     */
    /**
     * Recupera referencia da transação
     * @return
     */
    /**
     * Altera referencia da transação
     * @param TransactionReference
     */
    var transactionReference: String? = null

    /**
     * Identificador único retornado pela adquirente
     */
    /**
     * Recupera NSU - Numero unico sequencial
     * @return
     */
    /**
     * Altera NSU - Numero unico sequencial
     * @param UniqueSequentialNumber
     */
    var uniqueSequentialNumber: String? = null

    /**
     * Valor cancelado em centavos
     */
    /**
     * Recupera valor cancelado da transação em centavos
     * @return
     */
    /**
     * Altera valor cancelado da transação em centavos
     * @param VoidedAmountInCents
     */
    var voidedAmountInCents: Long? = null
}
/**
 * Construtor da Classe
 */
