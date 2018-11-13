package se.an3ll.ktor.koin.app.persistence.user

import se.an3ll.ktor.koin.app.persistence.Fetcher
import se.an3ll.ktor.koin.app.persistence.Repository

class UserFetcher(private val repository: Repository<User>) : Fetcher<User> {

  override fun getById(id: String): User? {
    return repository.getById(id)
  }

  override fun compareIdTo(loadable: User): User {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun get(): User {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
