package ResourceClients

import EnumTypes.ApiUrlEnum
import EnumTypes.HttpContentTypeEnum
import EnumTypes.PlatformEnvironmentEnum
import Utility.HttpUtility
import java.util.UUID

/**
 * Classe básica para recursos
 */
abstract class BaseResource @JvmOverloads protected constructor(
        val merchantKey: UUID,
        val platformEnvironment: PlatformEnvironmentEnum,
        protected val httpContentType: HttpContentTypeEnum,
        val resourceName: String, hostUri: String? = null) {

    protected val hostUri: String
    protected val httpUtility: HttpUtility

    init {
        this.httpUtility = HttpUtility()
        this.hostUri = if (hostUri == null || hostUri.trim { it <= ' ' }.length == 0) this.GetServiceUri(platformEnvironment) else hostUri
    }

    /**
     * Recupera URL de acordo com o ambiente
     * @param platformEnvironment
     * @return
     */
    private fun GetServiceUri(platformEnvironment: PlatformEnvironmentEnum): String {
        when (platformEnvironment) {
            PlatformEnvironmentEnum.Production -> return ApiUrlEnum.GATEWAY_PRODUCTION
            PlatformEnvironmentEnum.Sandbox -> return ApiUrlEnum.GATEWAY_SANDBOX
        }
    }
}
