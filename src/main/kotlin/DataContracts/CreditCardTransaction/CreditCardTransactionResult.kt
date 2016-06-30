package DataContracts.CreditCardTransaction

import DataContracts.InstantBuy.CreditCardData
import EnumTypes.CreditCardOperationEnum
import EnumTypes.CreditCardTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Resultado da transação de cartão de crédito
 */
class CreditCardTransactionResult {
    var AcquirerMessage: String? = null
    var AcquirerName: String? = null
    var AcquirerReturnCode: String? = null
    var AffiliationCode: String? = null
    var AmountInCents: Long? = null
    var AuthorizationCode: String? = null
    var AuthorizedAmountInCents: Long? = null
    var CapturedAmountInCents: Long? = null
    var CapturedDate: Date? = null
    var CreditCard: CreditCardData? = null
    var CreditCardOperation: CreditCardOperationEnum? = null
    var CreditCardTransactionStatus: CreditCardTransactionStatusEnum? = null
    var DueDate: Date? = null
    var ExternalTime: Long? = null
    var PaymentMethodName: String? = null
    var RefundedAmountInCents: Long? = null
    var Success: Boolean? = null
    var TransactionIdentifier: String? = null
    var TransactionKey: UUID? = null
    var TransactionKeyToAcquirer: String? = null
    var TransactionReference: String? = null
    var UniqueSequentialNumber: String? = null
    var VoidedAmountInCents: Long? = null
}
