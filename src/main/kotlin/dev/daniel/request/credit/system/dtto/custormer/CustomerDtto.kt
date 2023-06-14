package dev.daniel.request.credit.system.dtto.custormer

import dev.daniel.request.credit.system.model.Address
import dev.daniel.request.credit.system.model.Credit
import dev.daniel.request.credit.system.model.Customer
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDtto(

    @field:NotEmpty(message = "Invalid firstName")
    val firstName: String ,


    @field:NotEmpty(message = "Invalid lastName")
    val lastName: String ,



    @field:CPF(message = "this invalid CPF")
    val cpf: String ,

    @field:Email(message = "Invalid email")
    val email: String ,

    @field:NotNull(message = "Invalid income")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid password")
    val password: String,

    @field:NotEmpty(message = "Invalid zipCode")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid street")
    val street: String

)
{
    // criando função para converter de dtto para customer
    fun toEntry():Customer{
        val customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            email = this.email,
            income = this.income,
            password = this.password,
            address = Address(zipCode = this.zipCode, street = this.street)
        )
        return customer
    }
}