package DataContracts.CreditCardTransaction

import EnumTypes.CurrencyIsoEnum

/**
 * Opções de transação de cartão de rédito
 */
data class CreditCardTransactionOptions(var CaptureDelayInMinutes: Int? = null,
                                        var CurrencyIso: CurrencyIsoEnum? = null,
                                        var ExtendedLimitCode: String? = null,
                                        var ExtendedLimitEnabled: Boolean? = null,
                                        var IataAmountInCents: Long? = null,
                                        var InterestRate: Float? = null,
                                        var MerchantCategoryCode: Long? = null,
                                        var PaymentMethodCode: Int? = null,
                                        var SoftDescriptorText: String? = null)