package se.an3ll.ktor.koin.app.persistence

interface Fetcher<T : Fetchable> {
  fun getById(id: String) : T?
  fun compareIdTo(loadable: T) : T
  fun get() : T
}
