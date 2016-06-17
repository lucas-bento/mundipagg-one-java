package Client

import EnumTypes.HttpContentTypeEnum
import EnumTypes.PlatformEnvironmentEnum
import ResourceClients.*
import java.util.UUID

/**
 * Cliente para acesso aos serviços do gateway.
 */
class GatewayServiceClient
// CONSTRUTORES DA CLASSE

/**
 * Cria cliente para acessar serviços do gateway da MundiPagg One
 * O Host base que será usado usado para acessar os recuros é o HostUri informado.
 * @param merchantKey
 * *
 * @param environment
 * *
 * @param hostUri
 */
@JvmOverloads constructor(merchantKey: UUID, environment: PlatformEnvironmentEnum = PlatformEnvironmentEnum.Sandbox, hostUri: String = "") {

    /**
     * Recursos para vendas
     */
    /**
     * Recupera recurso de venda
     * @return
     */
    val sale: SaleResource

    /**
     * Recursos para cartão de crédito
     */
    /**
     * Recupera recurso de cartão de crédito
     * @return
     */
    val creditCard: CreditCardResource

    /**
     * Recursos para post de notificação
     */
    /**
     * Recupera recurso de post de notificação
     * @return
     */
    val postNotification: PostNotificationResource

    /**
     * Recursos para relatório de transações
     */
    /**
     * Recupera recurso de relatório de transação
     * @return
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
     * @param merchantKey
     * *
     * @param hostUri
     */
    constructor(merchantKey: UUID, hostUri: String) : this(merchantKey, PlatformEnvironmentEnum.Sandbox, hostUri) {
    }
}
/**
 * Cria cliente para acessar serviços do gateway da MundiPagg One usando ambiente de Sandbox
 * @param merchantKey
 */
/**
 * Cria cliente para acessar serviços do gateway da MundiPagg One
 * @param merchantKey
 * *
 * @param environment
 */
