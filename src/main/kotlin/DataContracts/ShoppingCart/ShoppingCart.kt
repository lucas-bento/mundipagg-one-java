package DataContracts.ShoppingCart

import DataContracts.Address.DeliveryAddress
import java.util.ArrayList
import java.util.Date

/**
 * Carrinho de Compras
 */
class ShoppingCart {
    var DeliveryAddress: DeliveryAddress? = null
    var DeliveryDeadline: Date? = null
    var EstimatedDeliveryDate: Date? = null
    var FreightCostInCents: Int? = null
    var ShippingCompany: String? = null
    val ShoppingCartItemCollection: MutableList<ShoppingCartItem> = mutableListOf()
}
