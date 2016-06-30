package DataContracts.Sale

import DataContracts.BaseRequest
import DataContracts.BoletoTransaction.BoletoTransaction
import DataContracts.CreditCardTransaction.CreditCardTransaction
import DataContracts.Merchant.Merchant
import DataContracts.Order.Order
import DataContracts.Person.Buyer
import DataContracts.SaleOptions
import DataContracts.ShoppingCart.ShoppingCart
import java.util.*

/**
 * Criação de uma nova Venda
 */
class CreateSaleRequest(merchant: Merchant? = null,
                        order: Order? = null,
                        requestData: RequestData? = null,
                        buyer: Buyer? = null) : BaseRequest() {

    val Options: SaleOptions = SaleOptions()
    val BoletoTransactionCollection: MutableList<BoletoTransaction> = mutableListOf()
    val CreditCardTransactionCollection: MutableList<CreditCardTransaction> = mutableListOf()
    val ShoppingCartCollection: MutableList<ShoppingCart> = mutableListOf()

    fun add(transaction: CreditCardTransaction) = CreditCardTransactionCollection.add(transaction)
}
