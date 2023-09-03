package com.github.mroose.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBaseApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBaseApplication>(*args)
}