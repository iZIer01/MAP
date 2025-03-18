package jetbrains.kotlin.course.alias.util

typealias Identifier = Int

class IdentifierFactory{
    private var count: Int = 0

    //creating a function to incremant the count, to create a new id
    fun uniqueIdentifier(): Identifier{
        count = count + 1
        return count
    }
}

