package DataContracts.TransactionReport

import java.util.Date

/**
 * Cabeçalho do relatório
 */
class HeaderReport {

    /**
     * Data de processamento do relatório de transação
     */
    /**
     * Recupera data de processamento do relatório de transação
     * @return
     */
    /**
     * Altera data de processamento do relatório de transação
     * @param TransactionProcessedDate
     */
    var transactionProcessedDate: Date? = null

    /**
     * Data da criação do relatório
     */
    /**
     * Recupera data da criação do relatório
     * @return
     */
    /**
     * Altera data da criação do relatório
     * @param ReportFileCreateDate
     */
    var reportFileCreateDate: Date? = null

    /**
     * Versão do relatório
     */
    /**
     * Recupera versão do relatório
     * @return
     */
    /**
     * Altera versão do relatório
     * @param Version
     */
    var version: String? = null
}
/**
 * Construtor da Classe
 */
