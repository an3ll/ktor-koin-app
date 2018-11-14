package se.an3ll.ktor.koin.app.persistence.repo

import org.bson.types.ObjectId
import org.litote.kmongo.Id
import se.an3ll.ktor.koin.app.persistence.model.Crudable

interface RootRepository<T : Crudable> {
  fun insert(objectToInsert: T)
  fun getById(id: Id<T>): T?
  fun update(userId: Id<T>, objectToUpdate: T)
  fun deleteById(id: ObjectId)
}

interface ChildRepository<T : Crudable, S : Crudable> {
  fun insert(userId: Id<T>, objectToInsert: S)
  fun getById(id: Id<S>): S?
  fun update(objectToUpdate: S)
  fun deleteById(id: Id<S>)
}
