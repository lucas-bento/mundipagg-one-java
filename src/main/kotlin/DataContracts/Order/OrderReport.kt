/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataContracts.Order

import java.util.UUID

/**
 * Dados de pedido no relatório
 */
class OrderReport {

    /**
     * Nome da loja
     */
    /**
     * Recupera nome da loja
     * @return
     */
    /**
     * Altera nome da loja
     * @param MerchantName
     */
    var merchantName: String? = null

    /**
     * Chave da Loja
     */
    /**
     * Recupera chave da loja
     * @return
     */
    /**
     * Altera nome da loja
     * @param MerchantKey
     */
    var merchantKey: UUID? = null

    /**
     * Identificador do pedido na loja
     */
    /**
     * Recupera identificador da loja na plataforma
     * @return
     */
    /**
     * Altera identificador da loja na plataforma
     * @param OrderReference
     */
    var orderReference: String? = null

    /**
     * Identificador do pedido no gateway
     */
    /**
     * Recupera identificador do pedido no gateway
     * @return
     */
    /**
     * Altera identificador do pedido no gateway
     * @param OrderKey
     */
    var orderKey: UUID? = null
}
/**
 * Construtor da classe
 */
