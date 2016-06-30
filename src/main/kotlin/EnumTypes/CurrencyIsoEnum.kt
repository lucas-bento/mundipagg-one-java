/*
 * To change this license header), choose License Headers in Project Properties.
 * To change this template file), choose Tools | Templates
 * and open the template in the editor.
 */
package EnumTypes

/**
 * Enumerador para tipo de moeda
 */
enum class CurrencyIsoEnum private constructor(
        /**
         * Recupera valor do enumerador
         * @return
         */
        val value: Long) {

    /**
     * Real
     */
    BRL(986),

    /**
     * Euro
     */
    EUR(978),

    /**
     * Dólar
     */
    USD(840),

    /**
     * Argentine peso
     */
    ARS(32),

    /**
     * Boliviano
     */
    BOB(68),


    /**
     * Chilean peso
     */
    CLP(152),

    /**
     * Colombian peso
     */
    COP(170),

    /**
     * Uruguayan peso
     */
    UYU(858),

    /**
     * Peso Mexicano
     */
    MXN(484),

    /**
     * Paraguayan guaraní
     */
    PYG(600)
}
