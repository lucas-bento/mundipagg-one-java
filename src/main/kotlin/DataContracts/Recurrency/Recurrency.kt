package DataContracts.Recurrency

import EnumTypes.FrequencyEnum
import java.util.Date

/**
 * Solicitação de recorrência
 */
class Recurrency {
    var DateToStartBilling: Date? = null
    var Frequency: FrequencyEnum? = null
    var Interval: Int? = null
    var OneDollarAuth: Boolean? = null
    var Recurrences: Int? = null
}
