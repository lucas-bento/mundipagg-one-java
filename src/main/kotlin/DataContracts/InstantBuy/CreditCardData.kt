package DataContracts.InstantBuy

import EnumTypes.CreditCardBrandEnum
import com.thoughtworks.xstream.annotations.XStreamAlias
import java.util.UUID

/**
 * Dados do cartão de crédito
 */
@XStreamAlias("CreditCard")
data class CreditCardData(val CreditCardBrand: CreditCardBrandEnum,
                          val IsExpiredCreditCard: Boolean=false,
                          val MaskedCreditCardNumber: String,
                          val InstantBuyKey: UUID? = null) {
}
