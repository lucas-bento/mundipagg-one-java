package EnumTypes

/**
 * Enumerador para Tipo de Documento
 */
enum class DocumentTypeEnum private constructor() {

    /**
     * Documento para Pessoa Física (CPF)
     */
    CPF,
    /**
     * Documento para Pessoa Jurídica (CNPJ)
     */
    CNPJ
}