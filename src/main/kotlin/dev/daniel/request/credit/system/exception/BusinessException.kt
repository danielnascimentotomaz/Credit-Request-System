package dev.daniel.request.credit.system.exception

// Exception personalizada
data class BusinessException(override val message:String?):RuntimeException(message) {
}