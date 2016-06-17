package ResourceClients

import DataContracts.InstantBuy.GetInstantBuyDataResponse
import EnumTypes.*
import Utility.HttpResponseGenericResponse
import java.util.UUID
import org.apache.http.message.BasicHeader

/**
 * Recurso de Cartão de Crédito
 */
class CreditCardResource : BaseResource {

    constructor(merchantKey: UUID, platformEnvironment: PlatformEnvironmentEnum, httpContentType: HttpContentTypeEnum) : super(merchantKey, platformEnvironment, httpContentType, "/CreditCard")
    constructor(merchantKey: UUID, platformEnvironment: PlatformEnvironmentEnum, httpContentType: HttpContentTypeEnum, hostUri: String) : super(merchantKey, platformEnvironment, httpContentType, "/CreditCard", hostUri)

    @Throws(Exception::class)
    fun GetInstantBuyData(instantBuyKey: UUID): HttpResponseGenericResponse<GetInstantBuyDataResponse> {
        return this.GetInstantBuyDataImplementation(instantBuyKey, "")
    }

    @Throws(Exception::class)
    fun GetInstantBuyDataWithBuyerKey(buyerKey: UUID): HttpResponseGenericResponse<GetInstantBuyDataResponse> {
        return this.GetInstantBuyDataImplementation(buyerKey, "/BuyerKey")
    }

    @Throws(Exception::class)
    private fun GetInstantBuyDataImplementation(key: UUID, identifierName: String): HttpResponseGenericResponse<GetInstantBuyDataResponse> {
        val actionName = "/" + key.toString() + identifierName
        val httpVerb = HttpVerbEnum.Get
        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))
        val serviceUri = this.hostUri + this.resourceName + actionName

        return this.httpUtility.SubmitRequest(GetInstantBuyDataResponse::class.java, serviceUri, httpVerb, this.httpContentType, header)
    }
}
