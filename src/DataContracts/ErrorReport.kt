package DataContracts

import EnumTypes.ErrorCategoryEnum
import java.util.ArrayList

/**
 * Relação de erros
 */
class ErrorReport() {
    /**
     * Coleção de Erros
     */
    val Category: ErrorCategoryEnum?=null
    var ErrorItemCollection: MutableList<ErrorItem>?=null
}
