package EnumTypes

/**
 * Enumerador para categoria de erro
 */
enum class ErrorCategoryEnum private constructor() {

    /**
     * Erro de requisição
     */
    RequestError,

    /**
     * Erro na adquirente
     */
    ThirdPartyError,

    /**
     * Erro do sistema
     */
    SystemError
}
