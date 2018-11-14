package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import se.an3ll.ktor.koin.app.persistence.model.User

class UserRepository(private val client: MongoClient) : RootRepository<User> {

  override fun getById(id: Id<User>): User? {
    return context(client).findOne(User::_id eq id)
  }

  override fun insert(objectToInsert: User) {
    context(client).insertOne(objectToInsert)
  }

  override fun update(userId: Id<User>, objectToUpdate: User) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: ObjectId) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}

