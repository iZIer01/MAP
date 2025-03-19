package jetbrains.kotlin.course.alias.team

typealias Identifier = Int

data class Team(
     val id: Identifier,  // Declare id as a parameter in the constructor
     var point: Int = 0    // Default value for point
) {
     val name: String = "Team#${id + 1}"  // Generate the name based on the id
}
