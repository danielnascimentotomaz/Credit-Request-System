package dev.daniel.request.credit.system.repository

import dev.daniel.request.credit.system.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer,Long> {
}