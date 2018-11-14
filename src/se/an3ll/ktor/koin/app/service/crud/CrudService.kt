package se.an3ll.ktor.koin.app.service.crud

import se.an3ll.ktor.koin.app.persistence.model.Crudable

interface RootCrudService<T : Crudable> {
  fun create(objectToCreate: T)
  fun getById(id: String): T?
}

interface ChildCrudService<T : Crudable> {
  fun create(userId: String, objectToCreate: T)
  fun getById(id: String): T?
}
