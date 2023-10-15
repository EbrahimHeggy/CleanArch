package dev.ebrahim.task.data.local

class LetterDataSource : ILetterDataSource {
    override fun getLetter(): String {
        val letters = listOf("I", "S")
        return letters.random()
    }
}


