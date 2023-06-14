package dev.daniel.request.credit.system.exception

import org.springframework.http.HttpStatusCode
import java.time.LocalDate

/// Classe de restorno da exception
data class ExceptionDetails(
    val title:String,
    val timestamp:LocalDate,
    val status: Int,
    val exception: String,
    val details: MutableMap<String,String?>





)