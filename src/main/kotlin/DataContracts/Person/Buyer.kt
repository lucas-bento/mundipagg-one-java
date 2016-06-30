package DataContracts.Person

import DataContracts.Address.BuyerAddress
import EnumTypes.BuyerCategoryEnum
import EnumTypes.DocumentTypeEnum
import EnumTypes.EmailTypeEnum
import EnumTypes.GenderEnum
import EnumTypes.PersonTypeEnum
import java.util.ArrayList
import java.util.Date
import java.util.UUID

/**
 * Comprador
 */
class Buyer {
    var birthdate: Date? = null
    var documentNumber: String? = null
    var documentType: DocumentTypeEnum? = null
    var email: String? = null
    var emailType: EmailTypeEnum? = null
    var facebookId: String? = null
    var gender: GenderEnum? = null
    var homePhone: String? = null
    var mobilePhone: String? = null
    var name: String? = null
    var personType: PersonTypeEnum? = null
    var twitterId: String? = null
    var workPhone: String? = null
    var addressCollection: MutableList<BuyerAddress> = mutableListOf()
    var buyerCategory: BuyerCategoryEnum? = null
    var buyerKey: UUID? = null
    var buyerReference: String? = null
    var createDateInMerchant: Date? = null
    var lastBuyerUpdateInMerchant: Date? = null
}
