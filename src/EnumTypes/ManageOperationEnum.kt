package EnumTypes

/**
 * Enumerador que especifica a operação que será realizada no gerenciamento da transação.
 */
enum class ManageOperationEnum private constructor() {

    /**
     * Captura
     */
    Capture,

    /**
     * Cancelamento
     */
    Cancel
}
