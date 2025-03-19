package jetbrains.kotlin.course.alias.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameJsResult
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

// Convert Card to JsCard
fun Card.toJsCard(): JsCard = JsCard(this.id, this.words.map { it.text }.toTypedArray())

// Convert Team to JsTeam
fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.point, this.name)

// Convert List of Team to Array of JsTeam
fun List<Team>.toArrayJsTeams() = this.map { it.toJsTeam() }.toTypedArray()

// Convert GameJsResult to GameResult
fun GameJsResult.toGameResult(): GameResult {
    // Map the received list of JsTeams to actual Teams
    val teams = this.map {
        val team = TeamService.teamsStorage[it.id] ?: error("Internal error! Unknown team with id: ${it.id} was received!")
        team.point = it.points
        team  // Returning the modified Team object
    }

    // Assuming GameResult expects a score (possibly an Int) and playerName (int for playerId)
    val totalScore = teams.sumOf { it.point }  // Calculate the total score of all teams

    // If playerName should be an Int, pass an integer value here (e.g., 1 for player1 or specific team ID)
    return GameResult(playerName = 1.toString(), score = totalScore) // Passing score as Int and playerName as an Int
}
