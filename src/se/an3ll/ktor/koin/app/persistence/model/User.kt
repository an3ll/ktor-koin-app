package se.an3ll.ktor.koin.app.persistence.model

import se.an3ll.ktor.koin.app.persistence.Fetchable

data class User(
  val id: String,
  val name: String,
  val expenses: List<Expense> = emptyList()
) : Fetchable

data class Expense(
  val id: String,
  val category: Category,
  val amount: Number)

data class Category(
  val id: String,
  val name: String,
  val parentId: String? = null)

