package Client

import EnumTypes.HttpContentTypeEnum
import EnumTypes.PlatformEnvironmentEnum
import ResourceClients.*
import java.util.UUID

/**
 * Cliente para acesso aos serviços do gateway.
 */
class GatewayServiceClient

/**
 * Cria cliente para acessar serviços do gateway da MundiPagg One
 * O Host base que será usado usado para acessar os recuros é o HostUri informado.
 */
@JvmOverloads constructor(merchantKey: UUID, environment: PlatformEnvironmentEnum = PlatformEnvironmentEnum.Sandbox, hostUri: String = "") {

    /**
     * Recursos para vendas
     */
    val sale: SaleResource

    /**
     * Recursos para cartão de crédito
     */
    val creditCard: CreditCardResource

    /**
     * Recursos para post de notificação
     */
    val postNotification: PostNotificationResource

    /**
     * Recursos para relatório de transações
     */
    val transactionReport: TransactionReportResource

    init {
        this.sale = SaleResource(merchantKey, environment, HttpContentTypeEnum.Json, hostUri)
        this.creditCard = CreditCardResource(merchantKey, environment, HttpContentTypeEnum.Json, hostUri)
        this.postNotification = PostNotificationResource()
        this.transactionReport = TransactionReportResource(merchantKey, environment, hostUri)
    }

    /**
     * Cria cliente para acessar serviços do gateway da MundiPagg One
     * O Host base que será usado usado para acessar os recuros é o HostUri informado.
     */
    constructor(merchantKey: UUID, hostUri: String) : this(merchantKey, PlatformEnvironmentEnum.Sandbox, hostUri) {
    }
}
