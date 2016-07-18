package DataContracts.CreditCardTransaction

import DataContracts.Recurrency.Recurrency
import EnumTypes.CreditCardOperationEnum
import java.util.Date

/**
 * Transação de cartão de crédito
 */
data class CreditCardTransaction(var AmountInCents: Long,
                                 var CreditCard: CreditCard,
                                 var CreditCardOperation: CreditCardOperationEnum,
                                 var InstallmentCount: Int,
                                 var TransactionReference: String? = null,
                                 var Options: CreditCardTransactionOptions? = null,
                                 var Recurrency: Recurrency? = null,
                                 var TransactionDateInMerchant: Date? = null) {
}
