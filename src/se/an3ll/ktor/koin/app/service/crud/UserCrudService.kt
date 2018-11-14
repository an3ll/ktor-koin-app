package se.an3ll.ktor.koin.app.service.crud

import org.litote.kmongo.toId
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.repo.RootRepository
import se.an3ll.ktor.koin.app.service.RootCrudService

class UserCrudService(private val repository: RootRepository<User>) : RootCrudService<User> {

  override fun create(objectToCreate: User) {
    repository.insert(objectToCreate)
  }

  override fun getById(id: String): User? {
    return repository.getById(id.toId())
  }
}
