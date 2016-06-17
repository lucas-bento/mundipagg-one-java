package DataContracts

import EnumTypes.SeverityCodeEnum

/**
 * Item de Erro
 */
class ErrorItem (
        var Description: String = "",
        var ErrorCode: Int? = null,
        var ErrorField: String? = null,
        var SeverityCode: SeverityCodeEnum? = null){
}
