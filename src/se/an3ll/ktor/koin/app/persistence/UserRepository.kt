package se.an3ll.ktor.koin.app.persistence

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import se.an3ll.ktor.koin.app.persistence.model.Category
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User

class UserRepository(private val client: MongoClient) : Repository<User> {

  override fun getById(id: Id<User>): User? {
    return getMongoContext().findOne(User::_id eq id)
  }

  override fun insert(objectToInsert: User) {
    getMongoContext().insertOne(objectToInsert)
  }

  override fun update(objectToUpdate: User) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: ObjectId) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  private fun getMongoContext() : MongoCollection<User> {
    val database = client.getDatabase("test")
    return database.getCollection()
  }

  private fun createFakeUser(id: Id<User>) =
    User(
      _id = id,
      name = "Åke Åkesson",
      expenses = listOf(
        Expense(
          amount = 33,
          category = Category(
            name = "Datortillbehör"
          )
        ),
        Expense(
          amount = 78.99,
          category = Category(
            name = "Datortillbehör"
          )
        )
      )
    )
}
