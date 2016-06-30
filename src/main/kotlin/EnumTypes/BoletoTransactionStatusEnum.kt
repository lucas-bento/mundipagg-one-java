package EnumTypes

/**
 * Enumerador para Status de transação de Boleto
 */
enum class BoletoTransactionStatusEnum private constructor() {

    /**
     * Gerado
     */
    Generated,

    /**
     * Visualizado
     */
    Viewed,

    /**
     * Pago com valor abaixo
     */
    Underpaid,

    /**
     * Pago com valor maior
     */
    Overpaid,

    /**
     * Pago
     */
    Paid,

    /**
     * Cancelado
     */
    Voided,

    /**
     * Com erro
     */
    WithError
}
