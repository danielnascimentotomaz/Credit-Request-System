package dev.daniel.request.credit.system.model

import dev.daniel.request.credit.system.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    @Column(nullable = false, unique = true)
    var creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,


    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Enumerated
    val status: Status = Status.IN_PROGRESS,


    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    /// Aqui sera minha Foreign Key
    @ManyToOne
    var customer: Customer? = null

)
