package se.an3ll.ktor.koin.app.service.crud

import se.an3ll.ktor.koin.app.persistence.model.Crudable

interface CrudService<T : Crudable> {
  fun create(objectToCreate: T)
  fun getById(id: String): T?
}
