package DataContracts.Sale

import DataContracts.BaseResponse
import java.util.ArrayList

/**
 * Resposta da consulta de pedidos
 */
class QuerySaleResponse : BaseResponse() {
    val saleDataCollection: MutableList<SaleData> = mutableListOf()
    var saleDataCount: Int? = null
}
