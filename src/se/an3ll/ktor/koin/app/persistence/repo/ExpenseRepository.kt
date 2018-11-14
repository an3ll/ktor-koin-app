package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User

class ExpenseRepository(private val client: MongoClient) : Repository<Expense> {
  override fun insert(objectToInsert: Expense) {
//    context(client).insertOne(objectToInsert)
  }

  override fun getById(id: Id<Expense>): Expense? {
//    val user = context(client).findOne("{'expenses.amount' : 78.99}")
    val user = context(client).findOne(User::expenses / Expense::_id eq ObjectId(id.toString()))
    return user?.expenses?.find { it._id.toString() == id.toString() }
  }

  override fun update(objectToUpdate: Expense) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: ObjectId) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
