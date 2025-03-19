package jetbrains.kotlin.course.alias.card

// Importing the words stored at the Words.kt
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

typealias Identifier = Int

data class Word(val text: String)
data class Card(val id: Identifier, val words: List<Word>)

class IdentifierFactory {
    private var currentId = 0

    fun uniqueIdentifier(): Identifier {
        return currentId++  // Increment ID each time a new identifier is needed
    }
}

@Service
class CardService(private val identifierFactory: IdentifierFactory) {
    private val cards = mutableListOf<Card>()

    // Function to generate cards using the words from util
    fun generateCards() {
        val wordList = words.toList()  // Convert Set to List
        val groupedWords = wordList.chunked(4)  // Split the list into sublists of 4

        // Create a Card for each group of 4 words
        for (group in groupedWords) {
            val card = Card(identifierFactory.uniqueIdentifier(), group.toWords())  // Create a card
            cards.add(card)  // Add the card to the list
        }
    }

    // Extension function to convert a list of strings into a list of Word objects
    private fun List<String>.toWords(): List<Word> {
        return this.map { Word(it) }  // Convert each string into a Word object
    }

    // Function to get a card by its index
    fun getCardByIndex(index: Int): Card {
        return cards.getOrElse(index) { throw IllegalArgumentException("Card not found at index $index") }
    }

    // Instance function to return the number of cards
    fun cardsAmount(): Int {
        return cards.size // Return the number of cards in the list
    }
}
