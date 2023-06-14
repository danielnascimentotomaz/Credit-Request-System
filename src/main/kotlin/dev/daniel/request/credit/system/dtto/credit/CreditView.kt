package dev.daniel.request.credit.system.dtto.credit

import dev.daniel.request.credit.system.model.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode:UUID,
    val creditValue:BigDecimal,
    val numberOfInstallment:Int,
    val status: dev.daniel.request.credit.system.enummeration.Status,
    val emailCustormer: String?,
    val inconeCustormer: BigDecimal?
) {
    constructor(credit:Credit): this(
        credit.creditCode,credit.creditValue,credit.numberOfInstallments,
        credit.status, credit.customer?.email, credit.customer?.income


    )



}
