package DataContracts.Sale

import DataContracts.BaseRequest
import DataContracts.CreditCardTransaction.ManageCreditCardTransaction
import java.util.ArrayList
import java.util.UUID

/**
 * Gerenciar Venda
 */
class ManageSaleRequest : BaseRequest() {
    val CreditCardTransactionCollection: MutableList<ManageCreditCardTransaction> = mutableListOf()
    var OrderKey: UUID? = null
}
