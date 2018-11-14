package se.an3ll.ktor.koin.app.persistence.model

import org.litote.kmongo.Id
import org.litote.kmongo.newId

data class User(
  val _id: Id<User> = newId(),
  val name: String,
  val expenses: List<Expense> = emptyList()
) : Crudable

data class Expense(
  val _id: Id<Expense> = newId(),
  val category: Category,
  val amount: Number
) : Crudable

data class Category(
  val _id: Id<Category> = newId(),
  val name: String,
  val parentId: String? = null)
