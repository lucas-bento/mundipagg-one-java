package DataContracts.TransactionReport

/**
 * Cabeçalho do relatório
 */
class TrailerReport {

    /**
     * Total de pedidos
     */
    /**
     * Recupera total de pedidos
     * @return
     */
    /**
     * Altera total de pedidos
     * @param OrderDataCount
     */
    var orderDataCount: Long? = null

    /**
     * Total de transações de boleto
     */
    /**
     * Recupera total de transações de boleto
     * @return
     */
    /**
     * Altera total de transações de boleto
     * @param BoletoTransactionDataCount
     */
    var boletoTransactionDataCount: Long? = null

    /**
     * Total de transações de debito online
     */
    /**
     * Recupera total de transações de débito online
     * @return
     */
    /**
     * Altera total de transações de débito online
     * @param OnlineDebitTransactionDataCount
     */
    var onlineDebitTransactionDataCount: Long? = null

    /**
     * Total de transações de cartão de crédito
     */
    /**
     * Recupera total de transações de cartão de crédito
     * @return
     */
    /**
     * Altera total de transações de cartão de crédito
     * @param CreditCardTransactionDataCount
     */
    var creditCardTransactionDataCount: Long? = null
}
/**
 * Construtor da Classe
 */
