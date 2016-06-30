package Parsers

import DataContracts.BoletoTransaction.BoletoTransactionReport
import DataContracts.CreditCardTransaction.CreditCardTransactionReport
import DataContracts.OnlineDebitTransaction.OnlineDebitTransactionReport
import DataContracts.TransactionReport.*
import EnumTypes.BoletoTransactionStatusEnum
import EnumTypes.CreditCardBrandEnum
import EnumTypes.CreditCardTransactionStatusEnum
import EnumTypes.OnlineDebitTransactionStatusEnum
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.UUID

/**
 * Converte relatório de transações (texto plano) em objeto
 */
class TransactionReportParser {

    /**
     * Efetua a conversão de relatório a partir dos dados em texto plano
     * @param data
     * *
     * @return
     * *
     * @throws java.text.ParseException
     */
    @Throws(ParseException::class)
    fun parser(data: String): TransactionReportFile {
        // Inicializa objeto de retorno
        val report = TransactionReportFile()

        // Obtem as linhas
        val lines = data.split("\r\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        // Varre linhas
        for (line in lines) {
            // Separa as colunas
            val itemToParse = line.split(",".toRegex()).toTypedArray()

            if (null != itemToParse[0]) {
                when (itemToParse[0]) {
                // Verifica se linha é tipo Header e converte
                    "01" -> report.header = this.parserHeader(itemToParse)
                // Verifica se linha é tipo CreditCardTransaction e converte
                    "20" -> report.creditCardTransactionCollection.add(this.parserCreditCardTransaction(itemToParse))
                // Verifica se linha é tipo OnlineDebitTransaction e converte
                    "40" -> report.onlineDebitTransactionCollection.add(this.parserOnlineDebitTransaction(itemToParse))
                // Verifica se linha é tipo BoletoTransaction e converte
                    "30" -> report.boletoTransactionCollection.add(this.parserBoletoTransaction(itemToParse))
                // Verifica se linha é tipo Trailer e converte
                    "99" -> report.trailer = this.parserTrailer(itemToParse)
                }
            }
        }

        return report
    }

    /**
     * Converte linha de cabeçalho em objeto
     * @param row
     * *
     * @return
     */
    @Throws(ParseException::class)
    private fun parserHeader(row: Array<String>): HeaderReport {
        if (row.size != 4) {
            throw ParseException("The expected parameter count for Header parser is 4", row.size)
        }

        val header = HeaderReport()
        header.transactionProcessedDate = SimpleDateFormat("yyyyMMdd").parse(row[1])
        header.reportFileCreateDate = SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(row[2])
        header.version = row[3]
        return header
    }

    /**
     * Converte linha em dados de transação de cartão de crédito
     * @param row
     * *
     * @return
     */
    @Throws(ParseException::class)
    private fun parserCreditCardTransaction(row: Array<String>): CreditCardTransactionReport {
        if (row.size != 27) {
            throw ParseException("The expected parameter count for CreditCardTransaction parser is 27", row.size)
        }

        val transaction = CreditCardTransactionReport()
        transaction.order.orderKey = UUID.fromString(row[1])
        transaction.order.orderReference = row[2]
        transaction.order.merchantKey = UUID.fromString(row[3])
        transaction.order.merchantName = row[4]
        transaction.transactionKey = UUID.fromString(row[5])
        transaction.transactionKeyToAcquirer = row[6]
        transaction.transactionReference = row[7]
        transaction.creditCardBrand = CreditCardBrandEnum.valueOf(row[8])
        transaction.creditCardNumber = row[9]
        transaction.installmentCount = if (row[10].trim { it <= ' ' }.length > 0) Integer.valueOf(row[10]) else 0
        transaction.acquirerName = row[11]
        transaction.status = CreditCardTransactionStatusEnum.valueOf(row[12])
        transaction.amountInCents = if (row[13].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[13]) else 0L
        transaction.iataAmountInCents = if (row[14].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[14]) else 0L
        transaction.authorizationCode = row[15]
        transaction.transactionIdentifier = row[16]
        transaction.uniqueSequentialNumber = row[17]
        transaction.authorizedAmountInCents = if (row[18].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[18]) else 0L
        transaction.capturedAmountInCents = if (row[19].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[19]) else 0L
        transaction.voidedAmountInCents = if (row[20].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[20]) else 0L
        transaction.refundedAmountInCents = if (row[21].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[21]) else 0L
        transaction.acquirerAuthorizationReturnCode = row[22]
        transaction.authorizedDate = if (row[23].trim { it <= ' ' }.length > 0) SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(row[23]) else null
        transaction.capturedDate = if (row[24].trim { it <= ' ' }.length > 0) SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(row[24]) else null
        transaction.voidedDate = if (row[25].trim { it <= ' ' }.length > 0) SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(row[25]) else null
        transaction.lastProbeDate = if (row[26].trim { it <= ' ' }.length > 0) SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(row[26]) else null

        return transaction
    }

    /**
     * Converte linha em dados de transação de boleto
     * @param row
     * *
     * @return
     */
    @Throws(ParseException::class)
    private fun parserBoletoTransaction(row: Array<String>): BoletoTransactionReport {
        if (row.size != 18) {
            throw ParseException("The expected parameter count for BoletoTransaction parser is 18", row.size)
        }

        val transaction = BoletoTransactionReport()
        transaction.order.orderKey = UUID.fromString(row[1])
        transaction.order.orderReference = row[2]
        transaction.order.merchantKey = UUID.fromString(row[3])
        transaction.order.merchantName = row[4]
        transaction.transactionKey = UUID.fromString(row[5])
        transaction.transactionReference = row[6]
        transaction.status = BoletoTransactionStatusEnum.valueOf(row[7])
        transaction.nossoNumero = row[8]
        transaction.bankNumber = row[9]
        transaction.agency = row[10]
        transaction.account = row[11]
        transaction.barcode = row[12]
        transaction.expirationDate = SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(row[13])
        transaction.amountInCents = java.lang.Long.valueOf(row[14])
        transaction.amountPaidInCents = if (row[15].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[15]) else 0L
        transaction.paymentDate = if (row[16].trim { it <= ' ' }.length > 0) SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(row[16]) else null
        transaction.creditDate = if (row[17].trim { it <= ' ' }.length > 0) SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(row[17]) else null
        return transaction
    }

    /**
     * Converte linha em dados de transação de débito online
     * @param row
     * *
     * @return
     */
    @Throws(ParseException::class)
    private fun parserOnlineDebitTransaction(row: Array<String>): OnlineDebitTransactionReport {
        if (row.size != 16) {
            throw ParseException("The expected parameter count for OnlineDebitTransaction parser is 16", row.size)
        }

        val transaction = OnlineDebitTransactionReport()
        transaction.order.orderKey = UUID.fromString(row[1])
        transaction.order.orderReference = row[2]
        transaction.order.merchantKey = UUID.fromString(row[3])
        transaction.order.merchantName = row[4]
        transaction.transactionKey = UUID.fromString(row[5])
        transaction.transactionReference = row[6]
        transaction.bank = row[7]
        transaction.status = OnlineDebitTransactionStatusEnum.valueOf(row[8])
        transaction.amountInCents = java.lang.Long.valueOf(row[9])
        transaction.amountPaidInCents = if (row[10].trim { it <= ' ' }.length > 0) java.lang.Long.valueOf(row[10]) else 0L
        transaction.paymentDate = if (row[11].trim { it <= ' ' }.length > 0) SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(row[11]) else null
        transaction.bankReturnCode = row[12]
        transaction.bankPaymentDate = row[13]
        transaction.signature = row[14]
        transaction.transactionKeyToBank = row[15]

        return transaction
    }

    /**
     * Converte linha de rodapé em objeto
     * @param row
     * *
     * @return
     */
    @Throws(ParseException::class)
    private fun parserTrailer(row: Array<String>): TrailerReport {
        if (row.size != 5) {
            throw ParseException("The expected parameter count for Trailer parser is 5", row.size)
        }

        val trailer = TrailerReport()
        trailer.orderDataCount = java.lang.Long.valueOf(row[1])
        trailer.creditCardTransactionDataCount = java.lang.Long.valueOf(row[2])
        trailer.boletoTransactionDataCount = java.lang.Long.valueOf(row[3])
        trailer.onlineDebitTransactionDataCount = java.lang.Long.valueOf(row[4])
        return trailer
    }
}
/**
 * Construtor da classe
 */
