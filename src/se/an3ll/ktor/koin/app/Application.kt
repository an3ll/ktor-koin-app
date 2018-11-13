package se.an3ll.ktor.koin.app

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.ktor.ext.inject
import org.koin.ktor.ext.installKoin
import se.an3ll.ktor.koin.app.module.appModule
import se.an3ll.ktor.koin.app.persistence.Fetcher
import se.an3ll.ktor.koin.app.persistence.user.User

fun main(args: Array<String>) {
  embeddedServer(Netty, commandLineEnvironment(args)).start()
}

fun Application.module() {

  installFeatures()

  val userFetcher: Fetcher<User> by inject()

  routing {
    get("/users/{id}") {
      val id: String = call.parameters["id"]!!
      userFetcher.getById(id)?.let { user -> call.respond(message = user) }
    }
  }
}

fun Application.installFeatures() {

  //Install dependency injection by koin
  installKoin(listOf(appModule))

  //Install other ktor features
  install(DefaultHeaders)
  install(CallLogging)
  install(ContentNegotiation) {
    jackson {
      enable(SerializationFeature.INDENT_OUTPUT)
    }
  }
}
