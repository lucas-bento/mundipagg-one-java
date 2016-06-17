package DataContracts.Sale

import EnumTypes.EcommerceCategoryEnum

/**
 * Dados da requisição
 */
class RequestData {

    /**
     * Categoria da venda e-commerce. B2B ou B2C
     */
    /**
     * Recupera Categoria da venda e-commerce. B2B ou B2C
     * @return
     */
    /**
     * Altera Categoria da venda e-commerce. B2B ou B2C
     * @param EcommerceCategory
     */
    var ecommerceCategory: EcommerceCategoryEnum? = null

    /**
     * Endereço IP do cliente da loja
     */
    /**
     * Recupera Endereço IP do cliente da loja
     * @return
     */
    /**
     * Altera Endereço IP do cliente da loja
     * @param IpAddress
     */
    var ipAddress: String? = null

    /**
     * Identificador da origen do venda na loja
     */
    /**
     * Recupera Identificador da origen do venda na loja
     * @return
     */
    /**
     * Altera Identificador da origen do venda na loja
     * @param Origin
     */
    var origin: String? = null

    /**
     * Identificador da sessão do usuário no sistema da loja (utilizado pelo serviço de anti fraude)
     */
    /**
     * Recupera Identificador da sessão do usuário no sistema da loja (utilizado pelo serviço de anti fraude)
     * @return
     */
    /**
     * Altera Identificador da sessão do usuário no sistema da loja (utilizado pelo serviço de anti fraude)
     * @param SessionId
     */
    var sessionId: String? = null
}
/**
 * Construtor da Classe
 */
