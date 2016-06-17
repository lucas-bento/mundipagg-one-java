package DataContracts.InstantBuy

import DataContracts.BaseResponse
import java.util.ArrayList

/**
 * Dados de cartões de crédito de um comprador
 */
class GetInstantBuyDataResponse : BaseResponse() {

    /**
     * Lista de Cartões de Crédito
     */
    var creditCardDataCollection: List<CreditCardData>? = null

    /**
     * Total de cartões de crédito retornados
     */
    var creditCardDataCount: Int? = null

    init {
        this.creditCardDataCollection = ArrayList()
    }
}
