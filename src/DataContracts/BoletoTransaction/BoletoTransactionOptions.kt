package DataContracts.BoletoTransaction

import EnumTypes.CurrencyIsoEnum

/**
 * Opções de Transação de Boleto
 */
class BoletoTransactionOptions {

    /**
     * Tipo da Moeda
     */
    /**
     * Recupera tipo da moeda
     * @return
     */
    /**
     * Altera tipo da moeda
     * @param CurrencyIso
     */
    var currencyIso: CurrencyIsoEnum? = null

    /**
     * Total de dias para expirar o boleto
     */
    /**
     * Recupera Total de dias para expirar o boleto
     * @return
     */
    /**
     * Altera Total de dias para expirar o boleto
     * @param DaysToAddInBoletoExpirationDate
     */
    var daysToAddInBoletoExpirationDate: Int? = null
}
/**
 * Construtor da Classe
 */
