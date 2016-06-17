package DataContracts.Order

import java.util.Date
import java.util.UUID

/**
 * Dados do pedido
 */
class OrderData {

    /**
     * Data de criação do pedido no gateway
     */
    /**
     * Recupera Data de criação do pedido no gateway
     * @return
     */
    /**
     * Altera Data de criação do pedido no gateway
     * @param CreateDate
     */
    var createDate: Date? = null

    /**
     * Chave do pedido. Utilizado para identificar um pedido no gateway
     */
    /**
     * Recupera Chave do pedido. Utilizado para identificar um pedido no gateway
     * @return
     */
    /**
     * Altera Chave do pedido. Utilizado para identificar um pedido no gateway
     * @param OrderKey
     */
    var orderKey: UUID? = null

    /**
     * Número do pedido do sistema da loja
     */
    /**
     * Recupera Número do pedido do sistema da loja
     * @return
     */
    /**
     * Altera Número do pedido do sistema da loja
     * @param OrderReference
     */
    var orderReference: String? = null
}
/**
 * Construtor da Classe
 */
