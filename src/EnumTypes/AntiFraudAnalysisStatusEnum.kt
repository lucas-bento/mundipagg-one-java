package EnumTypes

/**
 * Enumerador para Status da análise do Antifraude
 */
enum class AntiFraudAnalysisStatusEnum private constructor() {

    /**
     * Pendente de análise de antifraude
     */
    PendingFraudAnalysisRequirement,

    /**
     * Pedido enviado para análise de antifraude
     */
    FraudAnalysisRequirementSent,

    /**
     * Aprovado
     */
    Approved,

    /**
     * Reprovado
     */
    Reproved,

    /**
     * Pendente de análise manual
     */
    PendingManualAnalysis,

    /**
     * Sem transação para análise
     */
    NoTransactionToAnalyse,

    /**
     * Erro na análise de antifraude
     */
    FraudAnalysisWithError
}
