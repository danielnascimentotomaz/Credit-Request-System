package dev.daniel.request.credit.system.service.impl

import dev.daniel.request.credit.system.exception.BusinessException
import dev.daniel.request.credit.system.model.Credit
import dev.daniel.request.credit.system.repository.CreditRepository
import dev.daniel.request.credit.system.repository.CustomerRepository
import dev.daniel.request.credit.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class CreditService(
    private  val creditRepository:CreditRepository,
    private  val customerService: CustomerService


): ICreditService {
    override fun save(credit: Credit): Credit {
      credit.apply {
          // Instanciando  o objeto customer com a função apply (findById vai mim retorna customer se existir caso contrario vai lanca uma exceção)
          customer = customerService.findById(credit.customer?.id!!)
      }

        return this.creditRepository.save(credit)

    }

    override fun findAllbyCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }




    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {

        // Min retorna um  credit se o creditcode não existe caso contrario lanca uma exceção
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)?:
        throw BusinessException("CreiditCode $creditCode not found"))


        // Verificando se credito pertence a pessoa
        return if (credit.customer?.id == customerId) credit else throw BusinessException("Contact admim")
    }


}