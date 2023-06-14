package dev.daniel.request.credit.system.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDate

// Essa classe vai fica mapeando as exceção
@RestControllerAdvice
class RestExceptionHandler {


    //Método para tratar a exception MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex:MethodArgumentNotValidException):ResponseEntity<ExceptionDetails>{
        val erros: MutableMap<String,String?> = HashMap()


        // bindingResult, que contém informações sobre todos os erros de validação encontrados durante o processamento do método.

        // bindingResult.allErrors retorna uma lista de objetos ObjectError contendo todos os erros encontrados

        //stream() converte a lista em um fluxo (stream) para facilitar o processamento.

        //forEach para iterar sobre cada elemento do fluxo de erros.

        //O lambda definido entre as chaves {} especifica o que será feito para cada erro. Nesse caso, o erro é representado
        // pela variável erro do tipo ObjectError.
        ex.bindingResult.allErrors.stream().forEach{
            erro: ObjectError ->
           // nome do campo que deu erro
            val fielName: String = (erro as FieldError).field

            //mensagem associada a esse campo
            val mensagemError: String? = erro.defaultMessage

            // Adicionado os valores no dicionarios
            erros[fielName] = mensagemError

        }

        return ResponseEntity(ExceptionDetails(title = "BAD_REQUEST",
            timestamp = LocalDate.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            exception = ex.objectName,
            details = erros
        ),HttpStatus.BAD_REQUEST)

    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex:DataAccessException):ResponseEntity<ExceptionDetails>{
        return ResponseEntity(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDate.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)

            ), HttpStatus.CONFLICT
        )

    }

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex:BusinessException):ResponseEntity<ExceptionDetails> {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ExceptionDetails(
                    title = "Bad Request! Consult the documentation",
                    timestamp = LocalDate.now(),
                    status = HttpStatus.BAD_REQUEST.value(),
                    exception = ex.javaClass.toString(),
                    details = mutableMapOf(ex.cause.toString() to ex.message)

                ))


    }







}

