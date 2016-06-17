package ResourceClients

import DataContracts.TransactionReport.TransactionReportFile
import EnumTypes.ApiUrlEnum
import EnumTypes.HttpContentTypeEnum
import EnumTypes.HttpVerbEnum
import EnumTypes.PlatformEnvironmentEnum
import Parsers.TransactionReportParser
import Utility.HttpResponse
import Utility.HttpUtility
import java.io.IOException
import java.nio.file.*
import java.security.InvalidParameterException
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID
import org.apache.http.message.BasicHeader

/**
 * Recurso para relatório de transações
 */
class TransactionReportResource {

    constructor(merchantKey: UUID, environment: PlatformEnvironmentEnum, hostUri: String) {
        this.merchantKey = merchantKey
        this.Environment = environment
        this.HostUri = hostUri
        this.httpUtility = HttpUtility()
    }

    constructor(merchantKey: UUID, environment: PlatformEnvironmentEnum) {
        this.merchantKey = merchantKey
        this.Environment = environment
        this.HostUri = ""
        this.httpUtility = HttpUtility()
    }

    constructor(merchantKey: UUID, hostUri: String) {
        this.merchantKey = merchantKey
        this.HostUri = hostUri
        this.httpUtility = HttpUtility()
    }

    /**
     * Chave da Loja. Utilizada para identificar a loja no gateway.
     */
    var merchantKey: UUID? = null

    /**
     * Ambiente de Integração
     */
    private var Environment: PlatformEnvironmentEnum? = null

    /**
     * Ambiente de Integração
     */
    private var HostUri: String? = null

    private val httpUtility: HttpUtility

    /**
     * Recupera URL de acordo com o ambiente
     * @return
     */
    private val serviceUri: String?
        get() {
            if (this.HostUri == null || this.HostUri!!.trim { it <= ' ' } == "") {
                when (this.Environment) {
                    PlatformEnvironmentEnum.Production -> return ApiUrlEnum.TRANSACTION_REPORT_FILE_PRODUCTION
                    PlatformEnvironmentEnum.Sandbox -> return ApiUrlEnum.TRANSACTION_REPORT_FILE_SANDBOX
                    else -> return null
                }
            } else
                return this.HostUri
        }

    /**
     * Retorna em texto pleno o conteúdo do relatório de transações referente ao dia da data informada
     * @param date
     * @return
     * @throws java.lang.Exception
     */
    @Throws(Exception::class)
    fun getTransactionReportFile(date: Date?): String {
        // Verifica se data é nula e retorn empty
        if (date == null) {
            throw InvalidParameterException("Date should be not null.")
        }

        // Recupera data no formato necessário para a API
        val simpleDateFormat = SimpleDateFormat("yyyyMMdd")

        // Monta nome da ação
        val actionName = "/GetStream?fileDate=" + simpleDateFormat.format(date)

        // Define verbo get
        val httpVerb = HttpVerbEnum.Get

        // Adiciona merchantKey no header
        val header = arrayOf(BasicHeader("MerchantKey", this.merchantKey.toString()))

        // Define url completa para obter o relatório
        val serviceUri = this.serviceUri!! + actionName

        // Solicita relatório e retorna
        val response = this.httpUtility.SendHttpWebRequest("", httpVerb, HttpContentTypeEnum.Json, serviceUri, header)
        return response.RawResponse
    }

    /**
     * Retorna em texto pleno o conteúdo do relatório de transações referente ao dia da data informada
     * @param transactionReportFile
     * @return
     * @throws java.text.ParseException
     */
    @Throws(ParseException::class)
    fun parserTransactionReportFile(transactionReportFile: String): TransactionReportFile {
        // Instancia obj responsavel pelo parser detalhado
        val transactionReportParser = TransactionReportParser()

        // Efetua o parse
        val report = transactionReportParser.parser(transactionReportFile)

        return report
    }

    /**
     * Salva um relatório de transação em arquivo txt no path informado e nome recebido para arquivo
     * @param transactionReportFile Dados do relatório
     * @param path Caminho que será salvo o arquivo.   Ex.   C:/Reports/
     * @param fileName Nome do arquivo sem a extensão. Ex.   MyReport
     * @throws java.io.IOException
     */
    @Throws(IOException::class)
    fun saveTransactionReportFile(transactionReportFile: String, path: String?, fileName: String?) {
        var path = path
        var fileName = fileName
        // Verifica path
        if (path == null || path.trim { it <= ' ' }.length == 0) {
            throw InvalidParameterException("Path should be not null.")
        }

        // Verifica se possui limitação de diretório ou não
        if (path[path.length - 1] != '/') {
            path += "/"
        }

        // Define extensão padrão
        val extension = ".txt"

        // Verifica nome do arquivo
        if (fileName == null || fileName.trim { it <= ' ' }.length == 0) {
            val df = SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
            val currentDate = Date()
            fileName = "TransactionReportFile_" + df.format(currentDate)
        }

        // Adiciona extensão
        fileName = fileName + extension

        // Tenta salvar
        val resultSave = Files.write(Paths.get(path + fileName), transactionReportFile.toByteArray(), StandardOpenOption.CREATE)
    }
}
