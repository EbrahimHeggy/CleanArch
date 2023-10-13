package dev.ebrahim.task.data.local

class FakeLetterDataSource : LetterDataSource {
    override fun getLetter(): String {
        val letters = listOf("I", "S")
        return letters.random()
    }
}


