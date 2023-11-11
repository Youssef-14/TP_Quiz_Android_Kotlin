package com.example.tp_quiz

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.widget.Button

// QuizActivity.kt
class QuizActivity : ComponentActivity() {

    // Liste des questions et réponses
    private val questions = listOf(
        "Quelle est la capitale de la France?",
        "Combien de continents y a-t-il?",
        // Ajoutez d'autres questions ici
    )

    private val correctAnswers = listOf(
        "Paris",
        "7",
        // Ajoutez les bonnes réponses correspondantes ici
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Initialisez les éléments d'interface utilisateur (TextView, Button, etc.)

        val startButton = findViewById<Button>(R.id.startButton)
        val answerButton = findViewById<Button>(R.id.answerButton)
        val questionTextView = findViewById<TextView>(R.id.questionTextView)

        startButton.setOnClickListener {
            startButton.visibility = View.GONE
            answerButton.visibility = View.VISIBLE
            showNextQuestion()
        }

        answerButton.setOnClickListener {
            // Vérifiez la réponse et mettez à jour le score
            checkAnswer()
            // Passez à la question suivante
            showNextQuestion()
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]
            val questionTextView = findViewById<TextView>(R.id.questionTextView)
            questionTextView.text = question
            currentQuestionIndex++
        } else {
            // Affichez le score final une fois toutes les questions répondues
            val resultTextView = findViewById<TextView>(R.id.resultTextView)
            resultTextView.text = "Score final: $score"
        }
    }

    private fun checkAnswer() {
        val userAnswer = getUserAnswer() // Implémentez cette fonction pour obtenir la réponse de l'utilisateur
        if (userAnswer == correctAnswers[currentQuestionIndex - 1]) {
            score++
        }
    }

    private fun getUserAnswer(): String {
        // Implémentez cette fonction pour obtenir la réponse de l'utilisateur
        // Cela pourrait être un champ de texte, une liste déroulante, etc.
        // Retournez la réponse de l'utilisateur en tant que chaîne de caractères
        return ""
    }
}
