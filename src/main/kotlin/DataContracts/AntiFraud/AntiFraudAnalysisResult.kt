package DataContracts.AntiFraud

import EnumTypes.AntiFraudAnalysisStatusEnum

/**
 * Resultado de Análise do Antifraude
 */
class AntiFraudAnalysisResult {

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
     * Nome do serviço de antifraude
     */
    /**
     * Recupera nome do serviço de antifraude
     * @return
     */
    /**
     * Altera nome do serviço de antifraude
     * @param AntiFraudServiceName
     */
    var antiFraudServiceName: String? = null

    /**
     * Mensagem de retorno do antifraude
     */
    /**
     * Recupera mensagem de retorno do antifraude
     * @return
     */
    /**
     * Altera mensagem de retorno do antifraude
     * @param Message
     */
    var message: String? = null

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
}
/**
 * Construtor da Classe
 */
