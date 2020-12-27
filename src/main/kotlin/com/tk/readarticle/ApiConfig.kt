package com.tk.readarticle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiConfig

fun main(args: Array<String>) {
	runApplication<ApiConfig>(*args)
}
