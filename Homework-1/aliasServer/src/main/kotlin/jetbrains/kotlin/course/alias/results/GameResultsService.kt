package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

// Type alias to store game results
typealias GameResult = List<Team>

class GameResultsService {

    companion object {
        private val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Result cannot be empty" }
        require(result.all { TeamService.teamsStorage.containsKey(it.id) }) {
            "All team IDs must be valid"
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
