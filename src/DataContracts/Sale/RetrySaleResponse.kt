package DataContracts.Sale

import DataContracts.BaseResponse
import DataContracts.CreditCardTransaction.CreditCardTransactionResult

/**
 * Resposta da Retentativa de Venda
 */
class RetrySaleResponse : BaseResponse() {
    val creditCardTransactionResultCollection: MutableList<CreditCardTransactionResult> = mutableListOf()
}
