package dev.daniel.request.credit.system.dtto.credit

import dev.daniel.request.credit.system.enummeration.Status
import dev.daniel.request.credit.system.model.Credit
import dev.daniel.request.credit.system.model.Customer
import jakarta.persistence.*
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDtto(

    @field:Future
    val dayFirstInstallment: LocalDate,

    @field:NotNull(message = "Invalid numbweOfInstallments")
    val numberOfInstallments: Int ,

    @field:NotNull(message = "Invalid creditValue")
    val creditValue: BigDecimal ,

    @field:NotNull(message = "Invalid customerId")
    var customerID: Long


) {
    fun toEntry():Credit{
        val credit = Credit(
            dayFirstInstallment = this.dayFirstInstallment,
            numberOfInstallments = this.numberOfInstallments,
            creditValue =  this.creditValue,
            customer = Customer(id= this.customerID)

        )
        return credit


    }

}