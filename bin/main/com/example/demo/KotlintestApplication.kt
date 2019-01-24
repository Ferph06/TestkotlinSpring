package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlintestApplication

fun main(args: Array<String>) {
	runApplication<KotlintestApplication>(*args)
}

