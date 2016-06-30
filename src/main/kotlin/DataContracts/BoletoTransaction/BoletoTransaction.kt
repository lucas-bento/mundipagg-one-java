package DataContracts.BoletoTransaction

import DataContracts.Address.BillingAddress
import java.util.Date

/**
 * Transação de Boleto
 */
class BoletoTransaction {
    var AmountInCents: Long? = null
    var BankNumber: String? = null
    var BillingAddress: BillingAddress? = null
    var DocumentNumber: String? = null
    var Instructions: String? = null
    var Options: BoletoTransactionOptions? = null
    var TransactionDateInMerchant: Date? = null
    var TransactionReference: String? = null
}
