package Utility

import org.apache.http.StatusLine

/**
 * Resposta de requisição via protocolo HTTP
 */
open class HttpResponse(val RawResponse: String, val HttpStatusCode: StatusLine)

