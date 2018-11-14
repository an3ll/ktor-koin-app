package se.an3ll.ktor.koin.app.service

import org.litote.kmongo.toId
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.repo.Repository

class ExpenseCrudService(private val repository: Repository<Expense>) : CrudService<Expense> {

  override fun create(objectToCreate: Expense) {
    repository.insert(objectToCreate)
  }

  override fun getById(id: String): Expense? {
    return repository.getById(id.toId())
  }
}
