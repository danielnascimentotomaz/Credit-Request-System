package dev.daniel.request.credit.system.controller

import dev.daniel.request.credit.system.dtto.custormer.CustomerDtto
import dev.daniel.request.credit.system.dtto.custormer.CustomerUpdateDtto
import dev.daniel.request.credit.system.dtto.custormer.CustomerViewDtto
import dev.daniel.request.credit.system.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customer")
class CostumerController(
    private val customeService:CustomerService
) {
    @PostMapping
    fun save(@RequestBody @Valid customerDtto: CustomerDtto):ResponseEntity<String>{
       val saveCustomer = customeService.save(customerDtto.toEntry())

        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${saveCustomer.lastName} saved")



    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerViewDtto> {

        val customerView = CustomerViewDtto()

        val customerBD = customeService.findById(id)

        return ResponseEntity.status(HttpStatus.OK).body(customerView.costumerView(customerBD))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:Long){
        customeService.delete(id)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id:Long,@RequestBody @Valid customerUpdateDtto: CustomerUpdateDtto):ResponseEntity<CustomerViewDtto> {

        //Buscando cliente
        val customerBD = customeService.findById(id)

        // Atualizando 0 Cliente
        val update = customerUpdateDtto.update(customerBD)

        // Salvando o clinte
        customeService.save(update)

        // Retornando cliente
        return ResponseEntity.status(HttpStatus.OK) .body(CustomerViewDtto().costumerView(update))


    }







}