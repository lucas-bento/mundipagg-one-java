package DataContracts.Order

import java.util.Date
import java.util.UUID

/**
 * Dados do Pedido
 */
class OrderResult {

    /**
     * Data de criação do pedido no gateway
     */
    var CreateDate: Date? = null

    /**
     * Identificador do pedido na loja
     */
    var OrderReference: String? = null

    /**
     * Identificador do pedido no gateway
     */
    var OrderKey: UUID? = null
}