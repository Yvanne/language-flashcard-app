package com.example.flashcard_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.core.widget.doOnTextChanged
import com.example.flashcard_app.model.Word
import com.example.flashcard_app.model.Language
import com.example.flashcard_app.model.exampleWords
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_card.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        add_english.doOnTextChanged { text, start, count, after ->
            currentEnglish = text?.toString() ?: ""
            println(currentEnglish)
        }

        add_translation.doOnTextChanged { text, start, count, after ->
            currentTranslation = text?.toString() ?: ""
            println(currentTranslation)
        }

        createBtn.setOnClickListener {
            addFlashcard()
            if (currentEnglish != "" && currentTranslation != "") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    var currentEnglish: String = ""
    var currentTranslation: String = ""

    private fun addFlashcard() {
        if (currentEnglish != "" || currentTranslation != "") {
            var newWord = Word(currentEnglish, currentTranslation, Language.SPANISH)
            exampleWords += newWord
        }
    }
}