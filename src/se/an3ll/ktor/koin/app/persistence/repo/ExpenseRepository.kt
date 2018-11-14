package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import se.an3ll.ktor.koin.app.persistence.model.Expense

class ExpenseRepository(private val client: MongoClient) : Repository<Expense> {
  override fun insert(objectToInsert: Expense) {
    context(client).insertOne(objectToInsert)
  }

  override fun getById(id: Id<Expense>): Expense? {
    return context(client).findOne(Expense::_id eq id)
  }

  override fun update(objectToUpdate: Expense) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: ObjectId) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
