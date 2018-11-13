package se.an3ll.ktor.koin.app.persistence

interface Repository<out T : Fetchable> {
    fun getById(id: String): T
}
