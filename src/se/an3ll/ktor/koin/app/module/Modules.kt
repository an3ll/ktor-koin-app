package se.an3ll.ktor.koin.app.module

import org.koin.dsl.module.module
import org.litote.kmongo.KMongo
import se.an3ll.ktor.koin.app.persistence.CrudService
import se.an3ll.ktor.koin.app.persistence.Repository
import se.an3ll.ktor.koin.app.persistence.UserCrudService
import se.an3ll.ktor.koin.app.persistence.UserRepository
import se.an3ll.ktor.koin.app.persistence.model.User

val appModule = module {

  //Mongo Db
  single{ KMongo.createClient() }

  //Internal beans
  single<CrudService<User>> { UserCrudService(get()) }
  single<Repository<User>> { UserRepository(get()) }
}
