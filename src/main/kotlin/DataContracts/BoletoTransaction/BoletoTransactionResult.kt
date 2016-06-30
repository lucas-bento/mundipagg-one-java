package DataContracts.BoletoTransaction

import EnumTypes.BoletoTransactionStatusEnum
import java.util.UUID

/**
 * Resultado de transação de boleto
 */
class BoletoTransactionResult {

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

    /**
     * Indica se houve sucesso na geração do boleto
     */
    /**
     * Recupera se houve sucesso na geração do boleto
     * @return
     */
    /**
     * Altera se houve sucesso na geração do boleto
     * @param Success
     */
    var success: Boolean? = null
}
/**
 * Construtor da Classe
 */
