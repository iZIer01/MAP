package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {

    // Generates unique identifiers for cards
    private val identifierFactory = IdentifierFactory

    // Stores the list of generated cards
    private val cards: List<Card> = generateCards()

    companion object {
        // Number of words per card
        const val WORDS_IN_CARD = 4

        // Number of available cards
        val cardsAmount: Int = words.size / WORDS_IN_CARD
    }

    // Extension function to convert List<String> to List<Word>
    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    // Generates the list of cards
    private fun generateCards(): List<Card> {
        return words.shuffled() // Shuffle the words for randomness
            .chunked(WORDS_IN_CARD) // Divide the list into groups of WORDS_IN_CARD
            .take(cardsAmount) // Take the required number of cards
            .map { chunk ->
                Card(
                    id = identifierFactory.uniqueIdentifier(), // Generate a unique ID
                    words = chunk.toWords() // Convert words to List<Word>
                )
            }
    }

    // Retrieves a card by index or throws an error if the index is invalid
    fun getCardByIndex(index: Int): Card = cards.getOrElse(index) {
        throw IllegalArgumentException("Invalid card index: $index")
    }
}