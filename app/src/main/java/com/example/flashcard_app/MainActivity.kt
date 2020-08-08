package com.example.flashcard_app

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.flashcard_app.model.Word
import com.example.flashcard_app.model.exampleWords
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateRandomWord()

        text_input.doOnTextChanged { text, start, count, after ->
            currentGuess = text?.toString() ?: ""
            println(currentGuess)
        }

        submitBtn.setOnClickListener {
            checkAnswer()
        }

        addCardBtn.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }
    }

    var currentGuess: String = ""

    var lastRandomIndex = -1
    var currentWord: Word? = null
    private val random = Random()
    var correctGuesses = 0

    private fun checkAnswer() {
        val english = currentWord?.english ?: ""
        if (currentGuess.toLowerCase() == english.toLowerCase()) {
            // We have a match!
            correctGuesses++
            scoreBox.setText(Integer.toString(correctGuesses))
            text_input.setText("")
            updateRandomWord()
        } else {
            Snackbar.make(container, "Wrong answer! Try again", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun updateRandomWord() {
        var newRandomIndex = random.nextInt(exampleWords.count())

        while(newRandomIndex == lastRandomIndex) {
            newRandomIndex = random.nextInt(exampleWords.count())
        }
        lastRandomIndex = newRandomIndex

        val randomWord = exampleWords[newRandomIndex]
        currentWord = randomWord
        translation.text = randomWord.translation
        english.text = "${randomWord.english.length} letters"

    }
}