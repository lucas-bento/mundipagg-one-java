package DataContracts.CreditCardTransaction

import java.util.UUID

/**
 * Pedido de cancelamento/captura da transação de cartão de crédito
 */
class ManageCreditCardTransaction {
    var AmountInCents: Long? = null
    var TransactionKey: UUID? = null
    var TransactionReference: String? = null
}
