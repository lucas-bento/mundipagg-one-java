package DataContracts

import EnumTypes.CurrencyIsoEnum

/**
 * Opções de venda
 */
class SaleOptions {
    var AntiFraudServiceCode: Int? = null
    var CurrencyIso: CurrencyIsoEnum? = null
    var IsAntiFraudEnabled: Boolean? = null
    var Retries: Int? = null
}
