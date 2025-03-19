package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

// Class representing a word
@JvmInline
value class Word(val word: String)

// Class representing a card
data class Card(
    val id: Identifier,
    val words: List<Word>
)
