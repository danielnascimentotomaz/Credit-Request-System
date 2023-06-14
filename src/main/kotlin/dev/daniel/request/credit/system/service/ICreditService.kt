package dev.daniel.request.credit.system.service

import dev.daniel.request.credit.system.model.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit):Credit

    fun findAllbyCustomer(customerId:Long):List<Credit>

    fun findByCreditCode(customerId: Long,creditCode: UUID):Credit

}