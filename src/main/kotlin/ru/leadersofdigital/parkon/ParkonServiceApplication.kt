package ru.leadersofdigital.parkon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParkonServiceApplication

fun main(args: Array<String>) {
    runApplication<ParkonServiceApplication>(*args)
}
