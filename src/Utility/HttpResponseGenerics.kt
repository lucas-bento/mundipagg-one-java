package Utility

import org.apache.http.StatusLine

/**
 * Resposta de requisição via protocolo HTTP
 * @param
 * *
 * @param
 */
class HttpResponseGenerics<TResponse, TRequest>(val RawRequest: String, RawResponse: String, HttpStatusCode: StatusLine, val Response: TResponse, val Request: TRequest) : HttpResponse(RawResponse, HttpStatusCode)
