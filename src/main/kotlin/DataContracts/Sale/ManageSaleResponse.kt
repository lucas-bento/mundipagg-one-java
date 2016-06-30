package DataContracts.Sale

import DataContracts.BaseResponse
import DataContracts.CreditCardTransaction.CreditCardTransactionResult

/**
 * Responsta de gerenciar venda
 */
class ManageSaleResponse : BaseResponse() {
    var CreditCardTransactionResultCollection: List<CreditCardTransactionResult>? = null
}
