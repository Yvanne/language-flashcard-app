package com.example.flashcard_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val wordList = arrayListOf<String>("boca", "arroz","pagar", "tienda",
        "mesa", "gato", "cerveza", "dulces", "cielos")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            wordBtn.setOnClickListener {
                val random = Random()
                val randomWord = random.nextInt(wordList.count())
                selectedWord.text = wordList[randomWord]
            }
    }
}