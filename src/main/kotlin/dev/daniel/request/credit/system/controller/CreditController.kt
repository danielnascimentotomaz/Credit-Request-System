package dev.daniel.request.credit.system.controller

import dev.daniel.request.credit.system.dtto.credit.CreditDtto
import dev.daniel.request.credit.system.dtto.credit.CreditView
import dev.daniel.request.credit.system.dtto.credit.CreditViewList
import dev.daniel.request.credit.system.model.Credit
import dev.daniel.request.credit.system.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Collections
import java.util.UUID
import java.util.stream.Collectors
import java.util.stream.Stream

@RestController
@RequestMapping("/api/Credit")
class CreditController(
    private val creditService :CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDtto: CreditDtto):ResponseEntity<String>{

        val creditSave = creditService.save(creditDtto.toEntry())

        return ResponseEntity.status(HttpStatus.CREATED).body("Credit ${creditSave.status} saved")

    }

    @GetMapping("/{customerId}")
    fun findAllById(@PathVariable customerId:Long): ResponseEntity<List<CreditViewList>?> {

        val creditViewList: List<CreditViewList> = this.creditService.findAllbyCustomer(customerId).stream().map { credit: Credit ->
            CreditViewList().listaCredito(credit)}.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)

    }
    @GetMapping("/{idcustomer}/{creditCode}")
    fun findByCreditCode(@PathVariable idcustomer:Long,@PathVariable creditCode:UUID):ResponseEntity<CreditView> {

        val creditBD : Credit = creditService.findByCreditCode(idcustomer,creditCode)


        return ResponseEntity.status(HttpStatus.OK).body(CreditView(creditBD))


    }

}