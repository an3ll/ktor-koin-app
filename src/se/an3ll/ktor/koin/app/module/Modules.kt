package se.an3ll.ktor.koin.app.module

import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import io.ktor.config.tryGetString
import io.ktor.util.KtorExperimentalAPI
import org.koin.dsl.module.module
import org.litote.kmongo.KMongo
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.repo.ChildRepository
import se.an3ll.ktor.koin.app.persistence.repo.ExpenseRepository
import se.an3ll.ktor.koin.app.persistence.repo.RootRepository
import se.an3ll.ktor.koin.app.persistence.repo.UserRepository
import se.an3ll.ktor.koin.app.service.ChildCrudService
import se.an3ll.ktor.koin.app.service.RootCrudService
import se.an3ll.ktor.koin.app.service.crud.ExpenseCrudService
import se.an3ll.ktor.koin.app.service.crud.UserCrudService

@KtorExperimentalAPI
val appModule = module {

  val conf: Config = ConfigFactory.load()

  val mongoHost = conf.getString("ktor.mongo.mongoHost")
  val mongoUser = conf.tryGetString("ktor.mongo.mongoUser")
  val mongoPassword = conf.tryGetString("ktor.mongo.mongoPassword")
  val server = ServerAddress(mongoHost, 27017)

  //Mongo Db
  if (mongoUser != null && mongoPassword != null) {
    single { KMongo.createClient(server, listOf(MongoCredential.createCredential(mongoUser, "test", mongoPassword.toCharArray()))) }
  } else {
    single { KMongo.createClient(server) }
  }

  //Services
  single<RootCrudService<User>> { UserCrudService(get()) }
  single<ChildCrudService<Expense>> { ExpenseCrudService(get()) }

  //Repositories
  single<RootRepository<User>> { UserRepository(get()) }
  single<ChildRepository<User, Expense>> { ExpenseRepository(get()) }

}
