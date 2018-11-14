package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import org.bson.types.ObjectId
import org.litote.kmongo.*
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User

class ExpenseRepository(private val client: MongoClient) : ChildRepository<User, Expense> {

  override fun insert(userId: Id<User>, objectToInsert: Expense) {
    context(client).updateOne(User::_id eq ObjectId(userId.toString()), push(User::expenses, objectToInsert))
  }

  override fun getById(id: Id<Expense>): Expense? {
    val user = context(client).findOne(User::expenses / Expense::_id eq ObjectId(id.toString()))
    return user?.expenses?.find { it._id.toString() == id.toString() }
  }

  override fun update(objectToUpdate: Expense) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: Id<Expense>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
