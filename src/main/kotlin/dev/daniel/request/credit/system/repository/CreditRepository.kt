package dev.daniel.request.credit.system.repository

import dev.daniel.request.credit.system.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository:JpaRepository<Credit,Long> {
    //using jpa named queries
    fun findByCreditCode(creditCode: UUID):Credit?

    // native queries
    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = 1", nativeQuery = true)
    fun findAllByCustomer(customerId:Long) :List<Credit>






}