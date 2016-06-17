package DataContracts

import java.util.UUID

/**
 * Base de requesições HTTP
 */
abstract class BaseRequest
/**
 * Construtor da Classe
 */
protected constructor() {

    /**
     * Chave da requisição. Utilizada para identificar uma requisição específica no gateway.
     */
    /**
     * Recupera chave da requisição
     * @return
     */
    /**
     * Altera chave da requisição
     * @param RequestKey
     */
    var requestKey: UUID? = null
}
