package DataContracts.PostNotification

import DataContracts.BoletoTransaction.BoletoTransactionNotification
import DataContracts.CreditCardTransaction.CreditCardTransactionNotification
import DataContracts.OnlineDebitTransaction.OnlineDebitTransactionNotification
import EnumTypes.OrderStatusEnum
import java.util.UUID

/**
 * Status de notificação
 */
class StatusNotification {

    /**
     * Total em centavos
     */
    /**
     * Recupera valor original em centavos
     * @return
     */
    /**
     * Altera valor original em centavos
     * @param AmountInCents
     */
    var amountInCents: Long? = null

    /**
     * Total pago em centavos
     */
    /**
     * Recupera valor pago em centavos
     * @return
     */
    /**
     * Altera valor pago em centavos
     * @param AmountPaidInCents
     */
    var amountPaidInCents: Long? = null

    /**
     * Notificação de Transação de Boleto
     */
    /**
     * Recupera Notificação de Transação de Boleto
     * @return
     */
    /**
     * Altera Notificação de Transação de Boleto
     * @param BoletoTransaction
     */
    var boletoTransaction: BoletoTransactionNotification? = null

    /**
     * Notificação de Transação de Cartão de Crédito
     */
    /**
     * Recupera Notificação de Transação de Cartão de Crédito
     * @return
     */
    /**
     * Altera Notificação de Transação de Cartão de Crédito
     * @param CreditCardTransaction
     */
    var creditCardTransaction: CreditCardTransactionNotification? = null

    /**
     * Notificação de Transação de Débito Online
     */
    /**
     * Recupera Notificação de Transação de Débito Online
     * @return
     */
    /**
     * Altera Notificação de Transação de Débito Online
     * @param OnlineDebitTransaction
     */
    var onlineDebitTransaction: OnlineDebitTransactionNotification? = null

    /**
     * Chave da loja
     */
    /**
     * Recupera Chave da Loja
     * @return
     */
    /**
     * Altera Chave da Loja
     * @param MerchantKey
     */
    var merchantKey: UUID? = null

    /**
     * Chave do pedido
     */
    /**
     * Recupera Chave do pedido. Utilizado para identificar um pedido no gateway
     * @return
     */
    /**
     * Altera Chave do pedido. Utilizado para identificar um pedido no gateway
     * @param OrderKey
     */
    var orderKey: UUID? = null

    /**
     * Referencia do pedido na loja
     */
    /**
     * Recupera Número do pedido do sistema da loja
     * @return
     */
    /**
     * Altera Número do pedido do sistema da loja
     * @param OrderReference
     */
    var orderReference: String? = null

    /**
     * Status do Pedido
     */
    /**
     * Recupera status do pedido
     * @return
     */
    /**
     * Altera status do pedido
     * @param OrderStatus
     */
    var orderStatus: OrderStatusEnum? = null
}
/**
 * Construtor da Classe
 */
