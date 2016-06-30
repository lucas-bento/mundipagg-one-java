package DataContracts.BoletoTransaction

import EnumTypes.BoletoTransactionStatusEnum
import java.util.Date
import java.util.UUID

/**
 * Dados da transação de boleto
 */
class BoletoTransactionData {

    /**
     * Valor original do boleto em centavos
     */
    /**
     * Recupera Valor original do boleto em centavos
     * @return
     */
    /**
     * Altera Valor original do boleto em centavos
     * @param AmountInCents
     */
    var amountInCents: Long? = null

    /**
     * Valor total pago em centavos
     */
    /**
     * Recupera Valor total pago em centavos
     * @return
     */
    /**
     * Altera Valor total pago em centavos
     * @param AmountPaidInCents
     */
    var amountPaidInCents: Long? = null

    /**
     * Número do banco
     */
    /**
     * Recupera numero do banco
     * @return
     */
    /**
     * Altera numero do banco
     * @param BankNumber
     */
    var bankNumber: String? = null

    /**
     * Código de barras do boleto
     */
    /**
     * Recupera código de barras do boleto
     * @return
     */
    /**
     * Altera código de barras do boleto
     * @param Barcode
     */
    var barcode: String? = null

    /**
     * Status do boleto
     */
    /**
     * Recupera Status do boleto
     * @return
     */
    /**
     * Altera Status do boleto
     * @param BoletoTransactionStatus
     */
    var boletoTransactionStatus: BoletoTransactionStatusEnum? = null

    /**
     * Url para visualização do boleto
     */
    /**
     * Recupera URL de visualização do boleto
     * @return
     */
    /**
     * Altera URL de visualização do boleto
     * @param BoletoUrl
     */
    var boletoUrl: String? = null

    /**
     * Data de criação do boleto no gateway
     */
    /**
     * Recupera data de criação
     * @return
     */
    /**
     * Altera data de criação
     * @param CreateDate
     */
    var createDate: Date? = null

    /**
     * Número do documento
     */
    /**
     * Recupera numero do documento
     * @return
     */
    /**
     * Altera numero do documento
     * @param DocumentNumber
     */
    var documentNumber: String? = null

    /**
     * Data de expiração do boleto
     */
    /**
     * Recupera data de vencimento
     * @return
     */
    /**
     * Altera data de vencimento
     * @param ExpirationDate
     */
    var expirationDate: Date? = null

    /**
     * Identificador do boleto
     */
    /**
     * Recupera Identificador do boleto
     * @return
     */
    /**
     * Altera Identificador do boleto
     * @param NossoNumero
     */
    var nossoNumero: String? = null

    /**
     * Chave da transação. Utilizada para identificar a transação de boleto no gateway
     */
    /**
     * Recupera chave da transação. Utilizada para identificar a transação de boleto no gateway
     * @return
     */
    /**
     * Altera chave da transação. Utilizada para identificar a transação de boleto no gateway
     * @param TransactionKey
     */
    var transactionKey: UUID? = null

    /**
     * Identificador da transação no sistema da loja
     */
    /**
     * Recupera Identificador da transação no sistema da loja
     * @return
     */
    /**
     * Altera Identificador da transação no sistema da loja
     * @param TransactionReference
     */
    var transactionReference: String? = null
}
/**
 * Construtor da Classe
 */
