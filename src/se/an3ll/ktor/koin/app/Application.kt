package se.an3ll.ktor.koin.app

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.ktor.ext.inject
import org.koin.ktor.ext.installKoin
import org.litote.kmongo.id.jackson.IdJacksonModule
import se.an3ll.ktor.koin.app.module.appModule
import se.an3ll.ktor.koin.app.persistence.CrudService
import se.an3ll.ktor.koin.app.persistence.model.User

fun main(args: Array<String>) {
  embeddedServer(Netty, commandLineEnvironment(args)).start()
}

fun Application.module() {
  installFeatures()
  setupRouter()
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
      registerModule(IdJacksonModule())
    }
  }
}

fun Application.setupRouter() {

  //injection via koin
  val userCrudService: CrudService<User> by inject()

  //api
  routing {
    route("/users") {
      post {
        val user = call.receive<User>()
        call.respond(userCrudService.create(user))
      }
      get("/{id}") {
        val id: String = call.parameters["id"]!!
        val user = userCrudService.getById(id)
        if (user != null) call.respond(message = user) else call.respond(message = "User not found", status = HttpStatusCode.NotFound)
      }
    }
  }
}
