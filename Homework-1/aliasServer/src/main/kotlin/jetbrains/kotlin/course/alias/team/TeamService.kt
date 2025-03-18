package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class TeamService {

    //  Define the IdentifierFactory to help generate unique IDs

    // Creating a map to store the unique id of teams
    companion object {
        val teamsStorage: TeamMap<Identifier,Team> = teamMapOf()
    }

    // Generate teams for one round
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = teamMapOf<Team>()

        // Create the teams, generate IDs, and store them
        for (i in 0 until teamsNumber) {
            val teamId = identifierFactory.uniqueIdentifier()
            val team = Team(teamId) teamsStorage[teamId] = team  // Store the team in the teamsStorage
            teams.add(team
