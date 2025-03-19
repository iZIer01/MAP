package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory

class CardService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory()
) {

    private val word = listOf(
        "apple", "banana", "carrot", "dragon", "elephant",
        "forest", "guitar", "honey", "igloo", "jacket",
        "kangaroo", "lemon", "mountain", "notebook"
    )

    companion object {
        const val WORDS_IN_CARD = 4
        val cardsAmount: Int
            get() = word.size / WORDS_IN_CARD
    }

    val cards: List<card> = generateCards()

    private fun List<String>.toWords(): List<word> = this.map { word(it) }

    private fun generateCards(): List<card> {
        return word.shuffled()
            .chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .map { chunk -> card(identifierFactory.uniqueIdentifier(), chunk.toWords()) }
    }

    fun getCardByIndex(index: Int): card {
        return cards.getOrNull(index) ?: error("Card at index $index not found")
    }
}
