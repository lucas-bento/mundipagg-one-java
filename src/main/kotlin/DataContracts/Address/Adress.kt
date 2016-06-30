package DataContracts.Address

import EnumTypes.CountryEnum

/**
 * Endereço de Cobrança
 */
open class Address {
    var City: String? = null
    var Complement: String? = null
    var Country: CountryEnum? = null
    var District: String? = null
    var Number: String? = null
    var State: String? = null
    var Street: String? = null
    var ZipCode: String? = null
}
