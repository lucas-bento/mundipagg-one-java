package DataContracts.CreditCardTransaction

import DataContracts.Address.BillingAddress
import EnumTypes.CreditCardBrandEnum
import com.thoughtworks.xstream.annotations.XStreamAlias
import java.util.UUID

/**
 * Cartão de Crédito
 */
@XStreamAlias("CreditCard")
data class CreditCard (val CreditCardBrand:CreditCardBrandEnum,
                       val CreditCardNumber:String,
                       val ExpMonth:Int,
                       val ExpYear:Int,
                       val HolderName:String,
                       val SecurityCode:String,
                       val InstantBuyKey: UUID? = null,
                       val BillingAddress: BillingAddress? = null){
}
