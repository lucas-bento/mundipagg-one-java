package DataContracts.OnlineDebitTransaction

import EnumTypes.OnlineDebitTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados da notificação de débito online
 */
class OnlineDebitTransactionNotification {

    /**
     * Valor original em centavos
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
     * Chave da transação. Utilizada para identificar a transação de débito online no gateway
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
     * Status anterior da transação de débito online
     */
    /**
     * Recupera status anterior da transação
     * @return
     */
    /**
     * Altera status anterior da transação
     * @param PreviousOnlineDebitTransactionStatus
     */
    var previousOnlineDebitTransactionStatus: OnlineDebitTransactionStatusEnum? = null

    /**
     * Status atual da transação de débito online
     */
    /**
     * Recupera status atual da transação
     * @return
     */
    /**
     * Altera status atual da transação
     * @param OnlineDebitTransactionStatus
     */
    var onlineDebitTransactionStatus: OnlineDebitTransactionStatusEnum? = null
}
/**
 * Construtor da Classe
 */
