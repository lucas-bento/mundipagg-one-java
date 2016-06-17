package EnumTypes

/**
 * Enumerador de status de pedido
 */
enum class OrderStatusEnum {

    /**
     * Indefinido
     */
    Undefined,

    /**
     * Aberto
     */
    Opened,

    /**
     * Fechado
     */
    Closed,

    /**
     * Pago
     */
    Paid,

    /**
     * Pago a mais
     */
    Overpaid,

    /**
     * Cancelado
     */
    Canceled,

    /**
     * Pago parcialmente
     */
    PartialPaid,

    /**
     * Com erro
     */
    WithError
}
