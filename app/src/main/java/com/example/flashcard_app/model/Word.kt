package com.example.flashcard_app.model

data class Word(
    var english: String,
    val translation: String,
    val language: Language
)

var exampleWords = listOf(
    Word("Dog", "Perro", Language.SPANISH),
    Word("Rice", "Arroz", Language.SPANISH),
    Word("Hello", "Hola", Language.SPANISH),
    Word("Sugar", "Azucar", Language.SPANISH)
)

val wordList = arrayListOf<String>("boca", "arroz","pagar", "tienda",
    "mesa", "gato", "cerveza", "dulces", "cielos")