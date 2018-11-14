package se.an3ll.ktor.koin.app.module

import org.koin.dsl.module.module
import org.litote.kmongo.KMongo
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.repo.ExpenseRepository
import se.an3ll.ktor.koin.app.persistence.repo.Repository
import se.an3ll.ktor.koin.app.persistence.repo.UserRepository
import se.an3ll.ktor.koin.app.service.CrudService
import se.an3ll.ktor.koin.app.service.ExpenseCrudService
import se.an3ll.ktor.koin.app.service.UserCrudService

const val userCrud = "userCrud"
const val userRepo = "userRepo"

const val expenseCrud = "expenseCrud"
const val expenseRepo = "entityRepo"

val appModule = module {

  //Mongo Db
  single{ KMongo.createClient() }

  //Services
  single<CrudService<User>>(userCrud) { UserCrudService(get(userRepo)) }
  single<CrudService<Expense>>(expenseCrud) { ExpenseCrudService(get(expenseRepo)) }

  //Repositories
  single<Repository<User>>(userRepo) { UserRepository(get()) }
  single<Repository<Expense>>(expenseRepo) { ExpenseRepository(get()) }

}
