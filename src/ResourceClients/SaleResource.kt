package ResourceClients

import DataContracts.BoletoTransaction.BoletoTransaction
import DataContracts.CreditCardTransaction.CreditCardTransaction
import DataContracts.Sale.*
import DataContracts.*
import DataContracts.CreditCardTransaction.ManageCreditCardTransaction
import DataContracts.CreditCardTransaction.RetrySaleCreditCardTransaction
import EnumTypes.*
import Utility.*
import java.util.ArrayList
import java.util.UUID
import org.apache.http.message.BasicHeader

/**
 * Recurso de Vendas
 */
class SaleResource : BaseResource {

    /**
     * Construtor da Classe
     * @param merchantKey
     * *
     * @param platformEnvironment
     * *
     * @param httpContentType
     */
    constructor(merchantKey: UUID, platformEnvironment: PlatformEnvironmentEnum, httpContentType: HttpContentTypeEnum) : super(merchantKey, platformEnvironment, httpContentType, "/Sale/") {
    }

    /**
     * Construtor da Classe
     * @param merchantKey
     * *
     * @param platformEnvironment
     * *
     * @param httpContentType
     * *
     * @param hostUri
     */
    constructor(merchantKey: UUID, platformEnvironment: PlatformEnvironmentEnum, httpContentType: HttpContentTypeEnum, hostUri: String) : super(merchantKey, platformEnvironment, httpContentType, "/Sale/", hostUri) {
    }

    // BEGIN CREATE

    /**
     * Cria uma venda, contendo transações de boleto e/ou cartão de crédito
     * @param createSaleRequest
     * *
     * @return
     * *
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun Create(createSaleRequest: CreateSaleRequest): HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> {

        val httpVerb = HttpVerbEnum.Post

        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))

        val serviceUri = this.hostUri + this.resourceName

        return this.httpUtility.SubmitRequest(CreateSaleResponse::class.java, createSaleRequest,
                serviceUri, httpVerb, this.httpContentType, header)
    }

    /**
     * Cria uma venda com uma coleção de transações de cartão de crédito
     * @param creditCardTransactionCollection
     * *
     * @return
     * *
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun CreateCreditCard(creditCardTransactionCollection: ArrayList<CreditCardTransaction>): HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> {

        val createSaleRequest = CreateSaleRequest()
        createSaleRequest.Options.IsAntiFraudEnabled = false

        return this.Create(createSaleRequest)
    }

    /**
     * Cria uma transação de cartão de crédito
     * @param creditCardTransaction
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun CreateCreditCard(creditCardTransaction: CreditCardTransaction): HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> {

        val creditCardTransactionCollection = ArrayList<CreditCardTransaction>()
        creditCardTransactionCollection.add(creditCardTransaction)

        return this.CreateCreditCard(creditCardTransactionCollection)
    }

    /**
     * Cria uma venda com uma coleção de boletos
     * @param boletoTransactionCollection
     * *
     * @return
     * *
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun CreateBoleto(boletoTransactionCollection: ArrayList<BoletoTransaction>): HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> {

        val createSaleRequest = CreateSaleRequest()
        createSaleRequest.Options.IsAntiFraudEnabled = false

        return this.Create(createSaleRequest)
    }

    /**
     * Cria uma transação de boleto
     * @param boletoTransaction
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun CreateBoleto(boletoTransaction: BoletoTransaction): HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> {

        val boletoTransactionCollection = ArrayList<BoletoTransaction>()
        boletoTransactionCollection.add(boletoTransaction)

        return this.CreateBoleto(boletoTransactionCollection)
    }

    // END CREATE

    // BEGIN MANAGE

    /**
     * Gerencia uam venda
     * @param manageOperation
     * *
     * @param manageSaleRequest
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Manage(manageOperation: ManageOperationEnum, manageSaleRequest: ManageSaleRequest): HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> {
        val actionName = manageOperation.toString()
        val httpVerb = HttpVerbEnum.Post
        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))
        val serviceUri = this.hostUri + this.resourceName + actionName

        return this.httpUtility.SubmitRequest(
                ManageSaleResponse::class.java, manageSaleRequest, serviceUri, httpVerb, this.httpContentType, header)
    }

    /**
     * Gerencia uma venda
     * @param manageOperation
     * *
     * @param orderKey
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Manage(manageOperation: ManageOperationEnum, orderKey: UUID): HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> {

        val manageSaleRequest = ManageSaleRequest()
        manageSaleRequest.OrderKey = orderKey

        return this.Manage(manageOperation, manageSaleRequest)
    }

    /**
     * Gerencia uma coleção de transações de cartão de crédito.
     * @param manageOperation
     * *
     * @param orderKey
     * *
     * @param manageCreditCardTransactionCollection
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Manage(manageOperation: ManageOperationEnum, orderKey: UUID, manageCreditCardTransactionCollection: ArrayList<ManageCreditCardTransaction>): HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> {

        val manageSaleRequest = ManageSaleRequest()
        manageSaleRequest.OrderKey = orderKey
        manageSaleRequest.CreditCardTransactionCollection.addAll(manageCreditCardTransactionCollection)

        return this.Manage(manageOperation, manageSaleRequest)
    }

    /**
     * Gerencia uma transação de cartão de crédito específica
     * @param manageOperation
     * *
     * @param orderKey
     * *
     * @param manageCreditCardTransaction
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Manage(manageOperation: ManageOperationEnum, orderKey: UUID, manageCreditCardTransaction: ManageCreditCardTransaction): HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> {

        val manageCreditCardTransactionCollection = ArrayList<ManageCreditCardTransaction>()
        manageCreditCardTransactionCollection.add(manageCreditCardTransaction)

        return this.Manage(manageOperation, orderKey, manageCreditCardTransactionCollection)
    }

    // END MANAGE

    // BEGIN RETRY

    /**
     * Retenta venda com cartão de crédito
     * @param retrySaleRequest
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Retry(retrySaleRequest: RetrySaleRequest): HttpResponseGenerics<RetrySaleResponse, RetrySaleRequest> {
        val httpVerb = HttpVerbEnum.Post
        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))
        val serviceUri = this.hostUri + this.resourceName + "Retry"

        return this.httpUtility.SubmitRequest(
                RetrySaleResponse::class.java, retrySaleRequest, serviceUri, httpVerb, this.httpContentType, header)
    }

    /**
     * Retenta venda com cartão de crédito
     * @param orderKey
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Retry(orderKey: UUID): HttpResponseGenerics<RetrySaleResponse, RetrySaleRequest> {

        val retrySaleRequest = RetrySaleRequest()
        retrySaleRequest.orderKey = orderKey

        return this.Retry(retrySaleRequest)
    }

    /**
     * Retenta venda com cartão de crédito
     * @param orderKey
     * *
     * @param retrySaleCreditCardTransactionCollection
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Retry(orderKey: UUID, retrySaleCreditCardTransactionCollection: ArrayList<RetrySaleCreditCardTransaction>): HttpResponseGenerics<RetrySaleResponse, RetrySaleRequest> {

        val retrySaleRequest = RetrySaleRequest()
        retrySaleRequest.orderKey = orderKey
        retrySaleRequest.retrySaleCreditCardTransactionCollection = retrySaleCreditCardTransactionCollection

        return this.Retry(retrySaleRequest)
    }

    /**
     * Retenta venda com cartão de crédito
     * @param orderKey
     * *
     * @param retrySaleCreditCardTransaction
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun Retry(orderKey: UUID, retrySaleCreditCardTransaction: RetrySaleCreditCardTransaction): HttpResponseGenerics<RetrySaleResponse, RetrySaleRequest> {

        val retrySaleCreditCardTransactionCollection = ArrayList<RetrySaleCreditCardTransaction>()
        retrySaleCreditCardTransactionCollection.add(retrySaleCreditCardTransaction)

        return this.Retry(orderKey, retrySaleCreditCardTransactionCollection)
    }

    // END RETRY

    // BEGIN QUERY

    /**
     * Consulta uma venda
     * @param orderKey
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun QueryOrder(orderKey: UUID): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("OrderKey", orderKey.toString())
    }

    /**
     * Consulta uma venda
     * @param orderReference
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun QueryOrder(orderReference: String): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("OrderReference", orderReference)
    }

    /**
     * Consulta uma transação de cartão de crédito
     * @param creditCardTransactionKey
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun QueryCreditCardTransaction(creditCardTransactionKey: UUID): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("CreditCardTransactionKey", creditCardTransactionKey.toString())
    }

    /**
     * Consulta uma transação de cartão de crédito
     * @param creditCardTransactionReference
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun QueryCreditCardTransaction(creditCardTransactionReference: String): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("CreditCardTransactionReference", creditCardTransactionReference)
    }

    /**
     * Consulta uma transação de boleto
     * @param boletoTransactionKey
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    fun QueryBoletoTransaction(boletoTransactionKey: UUID): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("BoletoTransactionKey", boletoTransactionKey.toString())
    }

    /**
     * Consulta uma transação de boleto
     * @param boletoTransactionReference
     * *
     * @return
     * *
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun QueryBoletoTransaction(boletoTransactionReference: String): HttpResponseGenericResponse<QuerySaleResponse> {
        return this.QueryImplementation("BoletoTransactionReference", boletoTransactionReference)
    }

    /**
     * Implementação da chamada do método Query
     * @param identifierName
     * *
     * @param value
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    private fun QueryImplementation(identifierName: String, value: String): HttpResponseGenericResponse<QuerySaleResponse> {
        val actionName = "Query/$identifierName=$value"
        val httpVerb = HttpVerbEnum.Get
        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))
        val serviceUri = this.hostUri + this.resourceName + actionName

        return this.httpUtility.SubmitRequest(QuerySaleResponse::class.java, serviceUri, httpVerb, this.httpContentType, header)
    }

    // END QUERYS
}
