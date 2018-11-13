package se.an3ll.ktor.koin.app.persistence.user

import se.an3ll.ktor.koin.app.persistence.Repository

class UserRepository : Repository<User> {
  override fun getById(id: String) = User(id = id, name = "Åke Åkesson", age = 34)
}
