package DataContracts

import java.util.UUID

/**
 * Base de respostas HTTP
 */
abstract class BaseResponse
/**
 * Construtor da Classe
 */
protected constructor() {

    var ErrorReport: ErrorReport? = null

    /**
     * Tempo de processamento do gateway. Não inclui tempo da adquirente.
     */
    var InternalTime: Long? = null
    var MerchantKey: UUID? = null
    var RequestKey: UUID? = null

    fun hasError(): Boolean {
        if (ErrorReport != null) {
            if (ErrorReport!!.ErrorItemCollection != null) {
                return !ErrorReport!!.ErrorItemCollection!!.isEmpty()
            }
        }

        return false
    }
}
