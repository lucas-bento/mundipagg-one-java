package DataContracts.CreditCardTransaction

import java.util.UUID

/**
 * Transação de cartão de crédito a ser retentada
 */
class RetrySaleCreditCardTransaction {

    /**
     * Código de segurança do cartão - CVV
     */
    /**
     * Recupera Código de segurança do cartão - CVV
     * @return
     */
    /**
     * Altera Código de segurança do cartão - CVV
     * @param SecurityCode
     */
    var securityCode: String? = null

    /**
     * Chave da transação. Utilizada para identificar uma transação de cartão de crédito no gateway
     */
    /**
     * Recupera chave da transação. Utilizada para identificar uma transação de cartão de crédito no gateway
     * @return
     */
    /**
     * Altera chave da transação. Utilizada para identificar uma transação de cartão de crédito no gateway
     * @param TransactionKey
     */
    var transactionKey: UUID? = null
}
/**
 * Construtor da Classe
 */
