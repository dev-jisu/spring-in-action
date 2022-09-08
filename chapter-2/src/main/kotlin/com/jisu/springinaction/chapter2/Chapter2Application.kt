package com.jisu.springinaction.chapter2

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Chapter2Application

inline fun <reified T> T.logger(): Logger {
	return LoggerFactory.getLogger(T::class.java)
}

fun main(args: Array<String>) {
	runApplication<Chapter2Application>(*args)
}
