package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service

// Data class to store game results
data class GameResult(val playerName: String, val score: Int)

@Service
class GameResultsService {
    private val gameResults = mutableListOf<GameResult>()  // In-memory list to store results

    // Function to save a game result
    fun saveGameResults(result: GameResult) {
        gameResults.add(result)  // Add result to the list
    }

    // Function to retrieve all game results
    fun getAllGameResults(): List<GameResult> {
        return gameResults.toList()  // Return a copy of the results list
    }
}
