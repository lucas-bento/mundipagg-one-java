package Utility

import DataContracts.ServiceConstants
import EnumTypes.HttpContentTypeEnum
import EnumTypes.HttpVerbEnum
import java.io.IOException
import org.apache.http.HttpEntity
import org.apache.http.client.HttpClient
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicHeader
import org.apache.http.util.EntityUtils

/**
 * Utilitário de suporte para protocolo HTTP
 */
class HttpUtility {

    /**
     * Envia uma requisição para o gateway
     * @param  Tipo da resposta
     * @param TypeOfResponse
     * @param ServiceUri Url do serviço
     * @param HttpVerb Método de chamada do serviço
     * @param HttpContentType Formato do conteúdo da resposta
     * @param HeaderData Cabeçalho da requisição
     * @return
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun <TResponse> SubmitRequest(TypeOfResponse: Class<TResponse>, ServiceUri: String, HttpVerb: HttpVerbEnum, HttpContentType: HttpContentTypeEnum, HeaderData: Array<BasicHeader>): HttpResponseGenericResponse<TResponse> {
        // Submete dados e retorna resposta
        val response = this.SendHttpWebRequest(TypeOfResponse, HttpVerb, HttpContentType, ServiceUri, HeaderData)
        return response
    }

    /**
     * Envia uma requisição para o gateway
     * @param  Tipo da resposta
     * @param  Tipo da requisição
     * @param TypeOfResponse
     * @param Request Objeto de requisição
     * @param ServiceUri Url do serviço
     * @param HttpVerb Método de chamada do serviço
     * @param HttpContentType Formato do conteúdo da resposta
     * @param HeaderData Cabeçalho da requisição
     * @return
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun <TResponse, TRequest> SubmitRequest(TypeOfResponse: Class<TResponse>, Request: TRequest, ServiceUri: String, HttpVerb: HttpVerbEnum, HttpContentType: HttpContentTypeEnum, HeaderData: Array<BasicHeader>): HttpResponseGenerics<TResponse, TRequest> {
        // Submete dados e retorna resposta
        val response = this.SendHttpWebRequest(TypeOfResponse, Request, HttpVerb, HttpContentType, ServiceUri, HeaderData)
        return response
    }

    /**
     * Cria uma requisição HTTP e retorna um objeto do tipo especificado em TResponse.
     * @param  Tipo da resposta
     * @param ServiceEndpoint Url do serviço
     * @param HttpVerb Método de chamada do serviço
     * @param HttpContentType Formato do conteúdo da resposta
     * @param HeaderData Cabeçalho da requisição
     * @return
     */
    @Throws(Exception::class)
    private fun <TResponse> SendHttpWebRequest(TypeOfResponse: Class<TResponse>, HttpVerb: HttpVerbEnum, HttpContentType: HttpContentTypeEnum, ServiceEndpoint: String, HeaderData: Array<BasicHeader>): HttpResponseGenericResponse<TResponse> {
        // Efetua requisição
        val httpResponse = this.SendHttpWebRequest("", HttpVerb, HttpContentType, ServiceEndpoint, HeaderData)

        // Deserializa resposta
        val serializer = SerializeUtility<TResponse>()
        val responseObj = serializer.Deserializer(TypeOfResponse, httpResponse.RawResponse, HttpContentType)

        // Monta e retorna obj
        return HttpResponseGenericResponse<TResponse>(httpResponse.RawResponse, httpResponse.HttpStatusCode, responseObj)
    }

    /**
     * Cria uma requisição HTTP com um objeto do especificado em TRequest e retorna um objeto do tipo especificado em TResponse.
     * @param  Tipo da resposta
     * @param  Tipo da requisição
     * @param Request Objeto de requisição
     * @param ServiceEndpoint Url do serviço
     * @param HttpVerb Método de chamada do serviço
     * @param HttpContentType Formato do conteúdo da resposta
     * @param HeaderData Cabeçalho da requisição
     * @return
     */
    @Throws(Exception::class)
    private fun <TResponse, TRequest> SendHttpWebRequest(TypeOfResponse: Class<TResponse>, Request: TRequest, HttpVerb: HttpVerbEnum, HttpContentType: HttpContentTypeEnum, ServiceEndpoint: String, HeaderData: Array<BasicHeader>): HttpResponseGenerics<TResponse, TRequest> {
        // Serializa requisição
        val serializerRequest = SerializeUtility<TRequest>()
        val RawRequest = serializerRequest.Serialize(Request, HttpContentType)

        // Efetua requisição
        val httpResponse = this.SendHttpWebRequest(RawRequest, HttpVerb, HttpContentType, ServiceEndpoint, HeaderData)

        // Deserializa resposta
        val serializerResponse = SerializeUtility<TResponse>()
        val responseObj = serializerResponse.Deserializer(TypeOfResponse, httpResponse.RawResponse, HttpContentType)

        // Monta e retorna obj
        return HttpResponseGenerics(RawRequest, httpResponse.RawResponse.orEmpty(), httpResponse.HttpStatusCode, responseObj, Request)
    }

    /**
     * Envia requisição HTTP e obtém resposta.
     * @param DataToSend Conteúdo a ser submetido
     * @param ServiceEndpoint Url do serviço
     * @param HttpVerb Método de chamada do serviço
     * @param HttpContentType Formato do conteúdo da resposta
     * @param HeaderData Cabeçalho da requisição
     * @return
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun SendHttpWebRequest(DataToSend: String?, HttpVerb: HttpVerbEnum, HttpContentType: HttpContentTypeEnum, ServiceEndpoint: String, HeaderData: Array<BasicHeader>): HttpResponse {
        // Define codificação
        val encoding = ServiceConstants.CHARSET

        // Cria Client e Request
        val httpClient = HttpClientBuilder.create().setRedirectStrategy(RedirectRoles()).build()
        val httpRequest = HttpRequest(ServiceEndpoint, HttpVerb)

        // Verifica formato dos dados
        val DataFormat = if (HttpContentType == HttpContentTypeEnum.Xml)
            "text/xml"
        else
            "application/json"

        // Adiciona itens ao Header do Request
        httpRequest.setHeader("Accept", DataFormat) //Define o tipo do conteúdo aceitado
        httpRequest.setHeader("Content-Type", DataFormat + "; charset=" + encoding) //Define o tipo do conteúdo retornado

        // Adiciona headers recebidos
        for (header in HeaderData) {
            httpRequest.addHeader(header)
        }

        // Adiciona dados na requisição
        if (DataToSend != null && !DataToSend.isEmpty()) {
            val se = StringEntity(DataToSend, encoding)
            httpRequest.entity = se
        }

        // Executa e recupera resposta
        val httpResponse = httpClient.execute(httpRequest)

        // Monta uma string com a resposta
        val responseData: String
        try {
            val entityResponse = httpResponse.entity
            responseData = EntityUtils.toString(entityResponse, encoding)
        } catch (e: IOException) {
            responseData = e.toString()
        }

        // Define a variavel de retorno com a resposta da requisição
        val response = HttpResponse(responseData, httpResponse.statusLine)
        return response
    }
}
/**
 * Construtor da Classe
 */

