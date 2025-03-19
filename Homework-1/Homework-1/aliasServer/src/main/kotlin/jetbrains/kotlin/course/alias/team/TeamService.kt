package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class TeamService(private val identifierFactory: IdentifierFactory) {

    // Creating a map to store the unique ID of teams
    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()  // A mutable map to store teams by their IDs
    }

    // Generate teams for one round
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = mutableListOf<Team>()  // A list to store the created teams

        // Create the teams, generate IDs, and store them
        for (i in 0 until teamsNumber) {
            val teamId = identifierFactory.uniqueIdentifier()  // Get a unique ID
            val team = Team(teamId)  // Create a team with that ID
            teamsStorage[teamId] = team  // Store the team in the teamsStorage map
            teams.add(team)  // Add the created team to the list
        }
        return teams  // Return the list of teams generated
    }
}
