package se.an3ll.ktor.koin.app.persistence

import se.an3ll.ktor.koin.app.persistence.model.Category
import se.an3ll.ktor.koin.app.persistence.model.Expense
import se.an3ll.ktor.koin.app.persistence.model.User

class UserRepository : Repository<User> {
  override fun getById(id: String) =
    User(
      id = id,
      name = "Åke Åkesson",
      expenses = listOf(
        Expense(
          id = id,
          amount = 33,
          category = Category(
            id = id,
            name = "Datortillbehör"
          )
        ),
        Expense(
          id = id,
          amount = 78.99,
          category = Category(
            id = id,
            name = "Datortillbehör"
          )
        )
      )
    )
}
