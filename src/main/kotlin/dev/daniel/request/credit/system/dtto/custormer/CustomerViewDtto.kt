package dev.daniel.request.credit.system.dtto.custormer

import dev.daniel.request.credit.system.model.Customer
import java.math.BigDecimal

class CustomerViewDtto(

    val firstName: String ,
    val lastName: String ,
    val email: String ,
    val income: BigDecimal,
    val cpf : String,
    val zipCode: String,
    val street: String


) {

    constructor() :this("","","", BigDecimal.ZERO,"","","")



    fun costumerView(customer:Customer): CustomerViewDtto {
        val customerViewDtto = CustomerViewDtto(
            customer.firstName,
            customer.firstName,
            customer.email,
            customer.income,
            customer.cpf,
            customer.address.zipCode,
            customer.address.street
        )
        return customerViewDtto

    }


}