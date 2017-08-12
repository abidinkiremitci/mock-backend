package mock.backend.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("mock.backend.api.*")
@ComponentScan(basePackages = arrayOf("mock.backend.api.*"))
@EntityScan("mock.backend.api.model.*")
@EnableAutoConfiguration
class ResourceServerApplication

fun main(args: Array<String>)
{
    SpringApplication.run(ResourceServerApplication::class.java, *args)
}
