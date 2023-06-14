package dev.daniel.request.credit.system.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {

    @Bean
    fun publicApi():GroupedOpenApi?{
                                             // nome do projeto
        return GroupedOpenApi.builder().group("Request-credit-system").
         //URi do customer e credit
        pathsToMatch("/api/customer/**","/api/Credit/**").build()



    }



}