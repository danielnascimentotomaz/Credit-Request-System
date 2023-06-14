package dev.daniel.request.credit.system.service.impl

import dev.daniel.request.credit.system.exception.BusinessException
import dev.daniel.request.credit.system.model.Customer
import dev.daniel.request.credit.system.repository.CustomerRepository
import dev.daniel.request.credit.system.service.ICreditService
import dev.daniel.request.credit.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    //injeção de dependência
    private val customerRepository: CustomerRepository

):ICustomerService {

    override fun save(custormer: Customer): Customer {

        this.customerRepository.save(custormer)
        return custormer

    }


    override fun findById(id: Long): Customer {
        /*
        Nesta implementação, customerRepository.findById(id) retorna um arquivo Optional<Customer>.
        A orElseThrow função é usada para recuperar o Customer objeto do opcional se ele existir ou lançar um
        RuntimeException o opcional estiver vazio.
    */
        val  customerBD = customerRepository.findById(id).orElseThrow(){
            throw BusinessException("Id $id not found")
        }

        return customerBD

    }


    override fun delete(id: Long){

        // verificando se id  existem // podia usar findById mais preferir usar existsById.. findById mim retorna Optional e existsById mim retorna boolean
        if (!customerRepository.existsById(id)) {
            throw BusinessException("Customer not found for id: $id")
        }

        else {
            customerRepository.deleteById(id)
        }




    }
}