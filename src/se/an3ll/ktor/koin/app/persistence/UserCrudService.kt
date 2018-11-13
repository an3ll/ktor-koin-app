package se.an3ll.ktor.koin.app.persistence

import org.litote.kmongo.toId
import se.an3ll.ktor.koin.app.persistence.model.User

class UserCrudService(private val repository: Repository<User>) : CrudService<User> {
  override fun create(objectToCreate: User) {
    repository.insert(objectToCreate)
  }

  override fun getById(id: String): User? {
    return repository.getById(id.toId())
  }
}
