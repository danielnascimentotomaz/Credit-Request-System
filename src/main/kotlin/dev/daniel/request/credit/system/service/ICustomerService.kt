package dev.daniel.request.credit.system.service

import dev.daniel.request.credit.system.model.Customer

interface ICustomerService {
    fun  save(custormer: Customer):Customer

    fun findById(id:Long):Customer

    fun delete(id:Long)


}