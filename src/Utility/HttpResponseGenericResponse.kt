package Utility

import org.apache.http.StatusLine

/**
 * Resposta de requisição via protocolo HTTP
 * @param
 */
class HttpResponseGenericResponse<TResponse>(RawResponse: String, HttpStatusCode: StatusLine, val Response: TResponse) : HttpResponse(RawResponse, HttpStatusCode)

