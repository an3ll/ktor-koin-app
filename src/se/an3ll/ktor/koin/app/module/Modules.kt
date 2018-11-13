package se.an3ll.ktor.koin.app.module

import org.koin.dsl.module.module
import se.an3ll.ktor.koin.app.persistence.Fetcher
import se.an3ll.ktor.koin.app.persistence.Repository
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.UserFetcher
import se.an3ll.ktor.koin.app.persistence.UserRepository

val appModule = module {
  single<Fetcher<User>> { UserFetcher(get()) }
  single<Repository<User>> { UserRepository() }
}
