package DataContracts.AntiFraud

import EnumTypes.AntiFraudAnalysisStatusEnum
import java.util.ArrayList

/**
 * Análise de Antifraude
 */
class AntiFraudAnalysis {


    /**
     * Status da análise do serviço de antifraude
     */
    var antiFraudAnalysisStatus: AntiFraudAnalysisStatusEnum? = null

    /**
     * Código do serviço de antifraude
     */
    var antiFraudServiceCode: String? = null

    /**
     * Nome do serviço de antifraude
     */
    var antiFraudServiceName: String? = null

    /**
     * Coleção de histórico de análise antifraude
     */
    var historyCollection: List<AntiFraudAnalysisHistory>? = null

    /**
     * Indica se o serviço de antifraude está habilitado
     */
    var isAntiFraudEnabled: Boolean? = null

    /**
     * Código de retorno do antifraude
     */
    var returnCode: String? = null

    /**
     * Mensagem de retorno do antifraude
     */
    var returnMessage: String? = null

    /**
     * Status de retorno do antifraude
     */
    var returnStatus: String? = null

    /**
     * Pontuação do pedido
     */
    var score: Double? = null

    init {
        this.historyCollection = ArrayList()
    }
}
