package DataContracts.Sale

import DataContracts.BaseRequest
import DataContracts.CreditCardTransaction.RetrySaleCreditCardTransaction
import java.util.ArrayList
import java.util.UUID

/**
 * Retentativa de Venda
 */
class RetrySaleRequest : BaseRequest() {
    var options: RetrySaleOptions? = null
    var orderKey: UUID? = null
    var retrySaleCreditCardTransactionCollection: MutableList<RetrySaleCreditCardTransaction>? = mutableListOf()
}
