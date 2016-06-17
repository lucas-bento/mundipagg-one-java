package DataContracts.CreditCardTransaction

import EnumTypes.CreditCardBrandEnum
import EnumTypes.CreditCardTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados de notificação de transação de cartão de crédito
 */
class CreditCardTransactionNotification {

    /**
     * Nome da adquirente que processou a transação
     */
    /**
     * Recupera nome da adquirente
     * @return
     */
    /**
     * Altera nome da Adquirente
     * @param Acquirer
     */
    var acquirer: String? = null

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
     * Bandeira do cartão de crédito
     */
    /**
     * Recupera bandeira do cartão de crédito
     * @return
     */
    /**
     * Altera bandeira do cartão de crédito
     * @param CreditCardBrand
     */
    var creditCardBrand: CreditCardBrandEnum? = null

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
     * data da modificação do status
     */
    /**
     * Recupera data de modificação do status
     * @return
     */
    /**
     * Altera data de modificação do status
     * @param StatusChangedDate
     */
    var statusChangedDate: Date? = null

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

    /**
     * Status anterior da transação de cartão de crédito
     */
    /**
     * Recupera status anterior da transação de cartão de crédito
     * @return
     */
    var previousCreditCardTransactionStatuss: CreditCardTransactionStatusEnum? = null
        private set

    /**
     * Status atual da transação de cartão de crédito
     */
    /**
     * Recupera status atual da transação de cartão de crédito
     * @return
     */
    /**
     * Altera status atual da transação de cartão de crédito
     * @param CreditCardTransactionStatus
     */
    var creditCardTransactionStatus: CreditCardTransactionStatusEnum? = null

    /**
     * Altera status anterior da transação de cartão de crédito
     * @param PreviousCreditCardTransactionStatus
     */
    fun setPreviousCreditCardTransactionStatus(PreviousCreditCardTransactionStatus: CreditCardTransactionStatusEnum) {
        this.previousCreditCardTransactionStatuss = PreviousCreditCardTransactionStatus
    }
}
/**
 * Construtor da Classe
 */
