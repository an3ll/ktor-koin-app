package se.an3ll.ktor.koin.app.module

import org.koin.dsl.module.module
import org.litote.kmongo.KMongo
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.repo.ChildRepository
import se.an3ll.ktor.koin.app.persistence.repo.ExpenseRepository
import se.an3ll.ktor.koin.app.persistence.repo.RootRepository
import se.an3ll.ktor.koin.app.persistence.repo.UserRepository
import se.an3ll.ktor.koin.app.service.crud.ChildCrudService
import se.an3ll.ktor.koin.app.service.crud.ExpenseCrudService
import se.an3ll.ktor.koin.app.service.crud.RootCrudService
import se.an3ll.ktor.koin.app.service.crud.UserCrudService

val appModule = module {

  //Mongo Db
  single { KMongo.createClient() }

  //Services
  single<RootCrudService<User>> { UserCrudService(get()) }
  single<ChildCrudService<Expense>> { ExpenseCrudService(get()) }

  //Repositories
  single<RootRepository<User>> { UserRepository(get()) }
  single<ChildRepository<User, Expense>> { ExpenseRepository(get()) }

}
