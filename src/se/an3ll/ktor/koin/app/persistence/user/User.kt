package se.an3ll.ktor.koin.app.persistence.user

import se.an3ll.ktor.koin.app.persistence.Fetchable

data class User(val id: String, val name: String, val age: Int) : Fetchable
