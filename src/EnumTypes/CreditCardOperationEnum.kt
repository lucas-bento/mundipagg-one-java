package EnumTypes

/**
 * Enumerador para Operações de Ccartão de Crédito
 */
enum class CreditCardOperationEnum private constructor() {

    /**
     * Somente autorizar
     */
    AuthOnly,

    /**
     * Autorizar e capturar
     */
    AuthAndCapture,

    /**
     * Autorizar e capturar com atraso
     */
    AuthAndCaptureWithDelay
}
