package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
@RequestMapping("/health")
class HealthController {
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun test() = println("Health checked ${LocalDateTime.now()}")
}

@RestController
@RequestMapping("/ready")
class ReadinessController {
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun test() = println("Readiness checked ${LocalDateTime.now()}")
}

@RestController
@RequestMapping("/events/sport")
class SportEventsQuery {
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun test() = listOf(
		SportEvent("Man swimming championships", LocalDateTime.now()),
		SportEvent("Woman swimming championships", LocalDateTime.now())
	)
}

data class SportEvent(val organizerName: String, val dateTime: LocalDateTime)