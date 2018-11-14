package se.an3ll.ktor.koin.app.service.crud

import org.litote.kmongo.toId
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User
import se.an3ll.ktor.koin.app.persistence.repo.ChildRepository
import se.an3ll.ktor.koin.app.service.ChildCrudService

class ExpenseCrudService(private val repository: ChildRepository<User, Expense>) : ChildCrudService<Expense> {

  override fun create(userId: String, objectToCreate: Expense) {
    repository.insert(userId.toId(), objectToCreate)
  }

  override fun getById(id: String): Expense? {
    return repository.getById(id.toId())
  }
}
