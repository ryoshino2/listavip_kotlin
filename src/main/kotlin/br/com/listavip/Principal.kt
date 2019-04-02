package br.com.listavip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class Principal

fun main(args: Array<String>) {
    runApplication<Principal>(*args)
}
