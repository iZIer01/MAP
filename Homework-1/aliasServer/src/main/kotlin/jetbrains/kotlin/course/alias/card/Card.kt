package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

// Data class to store card information
data class Card(
    val id: Identifier,
    val words: List<Word>
)
