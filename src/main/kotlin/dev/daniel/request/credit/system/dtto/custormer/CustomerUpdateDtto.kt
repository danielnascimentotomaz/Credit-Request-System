package dev.daniel.request.credit.system.dtto.custormer

import dev.daniel.request.credit.system.model.Customer
import java.math.BigDecimal

data class CustomerUpdateDtto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String

){
    fun update(customer: Customer):Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.zipCode
        customer.address.street = this.street

        return customer

    }






}






