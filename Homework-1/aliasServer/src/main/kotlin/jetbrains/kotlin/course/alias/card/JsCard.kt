package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

// Value class to store a word
@JvmInline
value class word(val word: String) {
    companion object {
        val size: Any
    }
}

// Data class to represent a card
data class card(
    val id: Identifier,
    val words: List<word>
)
