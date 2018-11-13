package se.an3ll.ktor.koin.app.persistence

interface CrudService<T : Crudable> {
  fun getById(id: String): T?
  fun create(objectToCreate: T)
}
