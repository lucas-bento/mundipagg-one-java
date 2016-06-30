package DataContracts.BoletoTransaction

import EnumTypes.BoletoTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados da notificação de Transação de Boleto
 */
class BoletoTransactionNotification {

    /**
     * Valor original do boleto em centavos
     */
    /**
     * Recupera Valor original do boleto em centavos
     * @return
     */
    /**
     * Altera Valor original do boleto em centavos
     * @param AmountInCents
     */
    var amountInCents: Long? = null

    /**
     * Valor total pago em centavos
     */
    /**
     * Recupera Valor total pago em centavos
     * @return
     */
    /**
     * Altera Valor total pago em centavos
     * @param AmountPaidInCents
     */
    var amountPaidInCents: Long? = null

    /**
     * Data de expiração do boleto
     */
    /**
     * Recupera data de vencimento
     * @return
     */
    /**
     * Altera data de vencimento
     * @param BoletoExpirationDate
     */
    var boletoExpirationDate: Date? = null

    /**
     * Identificador do boleto
     */
    /**
     * Recupera Identificador do boleto
     * @return
     */
    /**
     * Altera Identificador do boleto
     * @param NossoNumero
     */
    var nossoNumero: String? = null

    /**
     * Data de modificação do status
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
     * Chave da transação. Utilizada para identificar a transação de boleto no gateway
     */
    /**
     * Recupera chave da transação. Utilizada para identificar a transação de boleto no gateway
     * @return
     */
    /**
     * Altera chave da transação. Utilizada para identificar a transação de boleto no gateway
     * @param TransactionKey
     */
    var transactionKey: UUID? = null

    /**
     * Identificador da transação no sistema da loja
     */
    /**
     * Recupera Identificador da transação no sistema da loja
     * @return
     */
    /**
     * Altera Identificador da transação no sistema da loja
     * @param TransactionReference
     */
    var transactionReference: String? = null

    /**
     * Status anterior do boleto
     */
    /**
     * Recupera status anterior da transação
     * @return
     */
    /**
     * Altera status anterior da transação
     * @param PreviousBoletoTransactionStatus
     */
    var previousBoletoTransactionStatus: BoletoTransactionStatusEnum? = null

    /**
     * Status atual do boleto
     */
    /**
     * Recupera status atual da transação
     * @return
     */
    /**
     * Altera status atual da transação
     * @param BoletoTransactionStatus
     */
    var boletoTransactionStatus: BoletoTransactionStatusEnum? = null
}
/**
 * Construtor da Classe
 */
