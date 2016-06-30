package DataContracts.TransactionReport

import DataContracts.BoletoTransaction.BoletoTransactionReport
import DataContracts.CreditCardTransaction.CreditCardTransactionReport
import DataContracts.OnlineDebitTransaction.OnlineDebitTransactionReport
import java.util.ArrayList


/**
 * Relatório de Transações
 */
class TransactionReportFile {

    var header: HeaderReport? = null
    val boletoTransactionCollection: MutableList<BoletoTransactionReport> = mutableListOf()
    val creditCardTransactionCollection: MutableList<CreditCardTransactionReport> = mutableListOf()
    val onlineDebitTransactionCollection: MutableList<OnlineDebitTransactionReport> = mutableListOf()

    /**
     * Rodapé do relatório
     */
    var trailer: TrailerReport? = null
}
