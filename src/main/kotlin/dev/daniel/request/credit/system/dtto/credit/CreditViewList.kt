package dev.daniel.request.credit.system.dtto.credit

import dev.daniel.request.credit.system.model.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
   val  creditCode:UUID,
   val  creditValue: BigDecimal,
   val numberOfInstalllments:Int

) {
    constructor(): this(UUID.randomUUID(), BigDecimal.ZERO,0)

    fun listaCredito(credit: Credit):CreditViewList{
       val creditList = CreditViewList(
           credit.creditCode,
           credit.creditValue,
           credit.numberOfInstallments

       )
        return creditList
    }
/*
    // tambem podia usar o metodo contrutor para retorna CreditViewList assim nao precisava do
    do metodo connstrutor vazio porque quando eu chamasse a classe eu ia passa logo credito

    constructor(credit: Credit):this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstalllments = credit.numberOfInstallments
    )
*/
}
