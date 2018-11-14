package se.an3ll.ktor.koin.app.persistence.repo

import org.bson.types.ObjectId
import org.litote.kmongo.Id
import se.an3ll.ktor.koin.app.persistence.model.Crudable

interface Repository<T : Crudable> {
  fun insert(objectToInsert: T)
  fun getById(id: Id<T>): T?
  fun update(objectToUpdate: T)
  fun deleteById(id: ObjectId)
}
