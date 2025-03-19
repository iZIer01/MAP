package jetbrains.kotlin.course.alias.results

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service
import java.io.File

@Service
class GameResultsService {

    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
        private val objectMapper = jacksonObjectMapper()
        private const val GAME_HISTORY_FILE = "game_history.json"

        // Load game history when the service starts
        init {
            loadGameHistory()
        }

        fun saveGameHistory() {
            objectMapper.writeValue(File(GAME_HISTORY_FILE), gameHistory)
        }

        private fun loadGameHistory() {
            val file = File(GAME_HISTORY_FILE)
            if (file.exists()) {
                gameHistory.addAll(objectMapper.readValue(file))
            }
        }
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Game result cannot be empty." }
        require(result.all { it.id in TeamService.teamsStorage }) {
            "Invalid team found in the result. All teams must exist in TeamService."
        }
        gameHistory.add(result)

        // Persist game history after each save
        saveGameHistory()
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
