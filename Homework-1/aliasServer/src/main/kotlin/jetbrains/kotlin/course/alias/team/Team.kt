package jetbrains.kotlin.course.alias.team

typealias Identifier = Int


data class Team {
     val  id: Identifier,
     var point: Int = 0,
     val name: String = `Team#${ id + 1}`
}