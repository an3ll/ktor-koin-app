package se.an3ll.ktor.koin.app.persistence.repo

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User

fun UserRepository.context(client: MongoClient): MongoCollection<User> {
  val database = client.getDatabase("test")
  return database.getCollection()
}

fun ExpenseRepository.context(client: MongoClient): MongoCollection<Expense> {
  val database = client.getDatabase("test")
  return database.getCollection()
}
