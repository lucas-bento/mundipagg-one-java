package Utility

import EnumTypes.HttpVerbEnum
import org.apache.http.client.methods.HttpPost

/**
 * Objeto para requisições HTTP
 */
class HttpRequest
/**
 * Construtor da Classe
 * @param Uri
 * *
 * @param HttpVerb
 */
(Uri: String,
 /**
  * Método de chamada HTTP
  */
 private val HttpVerb: HttpVerbEnum) : HttpPost(Uri) {

    /**
     * Recupera Método
     * @return
     */
    override fun getMethod(): String {
        return HttpVerb.toString().toUpperCase()
    }
}
