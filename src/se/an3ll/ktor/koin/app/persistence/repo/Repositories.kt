package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.getCollection
import se.an3ll.ktor.koin.app.persistence.model.Crudable
import se.an3ll.ktor.koin.app.persistence.model.User

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

fun context(client: MongoClient): MongoCollection<User> {
  val database = client.getDatabase("test")
  return database.getCollection()
}
