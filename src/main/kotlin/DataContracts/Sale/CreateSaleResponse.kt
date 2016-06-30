package DataContracts.Sale

import DataContracts.BaseResponse
import DataContracts.BoletoTransaction.BoletoTransactionResult
import DataContracts.CreditCardTransaction.CreditCardTransactionResult
import DataContracts.Order.OrderResult
import java.util.UUID

/**
 * Resposta da criação de uma nova venda
 */
class CreateSaleResponse : BaseResponse() {

    /**
     * Lista de transações de boleto
     */
    var BoletoTransactionResultCollection: MutableList<BoletoTransactionResult>? = null

    /**
     * Chave do comprador. Utilizada para identificar um comprador no gateway
     */
    var BuyerKey: UUID? = null

    /**
     * Lista de transações de cartão de crédito
     */
    var CreditCardTransactionResultCollection: MutableList<CreditCardTransactionResult>? = null

    /**
     * Dados de retorno do pedido
     */
    var OrderResult: OrderResult? = null
}
