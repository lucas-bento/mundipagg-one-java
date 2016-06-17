package DataContracts.AntiFraud

import EnumTypes.AntiFraudAnalysisStatusEnum
import java.util.Date

/**
 * Histórico de antifraude
 */
class AntiFraudAnalysisHistory {

    /**
     * Status da análise do serviço de antifraude
     */
    /**
     * Recupera status da análise do serviço de antifraude.
     * @return
     */
    /**
     * Altera status da análise do serviço de antifraude
     * @param AntiFraudAnalysisStatus
     */
    var antiFraudAnalysisStatus: AntiFraudAnalysisStatusEnum? = null

    /**
     * Código de retorno do antifraude
     */
    /**
     * Recupera código de retorno do antifraude
     * @return
     */
    /**
     * Altera código de retorno do antifraude
     * @param ReturnCode
     */
    var returnCode: String? = null

    /**
     * Mensagem de retorno do antifraude
     */
    /**
     * Recupera mensagem de retorno do antifraude
     * @return
     */
    /**
     * Altera mensagem de retorno do antifraude
     * @param ReturnMessage
     */
    var message: String? = null

    /**
     * Status de retorno do antifraude
     */
    /**
     * Recupera status de retorno do antifraude
     * @return
     */
    /**
     * Altera status de retorno do antifraude
     * @param ReturnStatus
     */
    var returnStatus: String? = null

    /**
     * Pontuação do pedido
     */
    /**
     * Recupera pontuação do pedido
     * @return
     */
    /**
     * Altera pontuação do pedido
     * @param Score
     */
    var score: Double? = null

    /**
     * Data de alteração de estatus
     */
    /**
     * Recupera data de alteração de status
     * @return
     */
    /**
     * Altera data de alteração de status
     * @param StatusChangedDate
     */
    var statusChangedDate: Date? = null
}
/**
 * Construtor da Classe
 */
