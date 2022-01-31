package com.example.quiz_app

import java.util.ArrayList

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"


    fun getQuestions():ArrayList<Question> {
        val questionsList = ArrayList<Question>()


        val questionOne = Question(
            1, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Norway", "Russia", "Demacian",
            1
        )

        val questionTwo = Question(
            2, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Sweden", "Finland", "Norway", "Belgium",
            4
        )

        val questionThree = Question(
            3, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Jordan", "Afghanistan", "Fiji", "France",
            3
        )

        val questionFour = Question(
            4, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "China", "India", "Vietnam", "Japan",
            2
        )

        val questionFive = Question(
            5, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Norway", "Sweden", "Germany", "Denmark",
            4
        )

        val questionSix = Question(
            1, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil", "Peru", "Egypt", "Mexico",
            1
        )
        questionsList.add(questionOne)
        questionsList.add(questionTwo)
        questionsList.add(questionThree)
        questionsList.add(questionFour)
        questionsList.add(questionFive)
        questionsList.add(questionSix)
        return questionsList
    }
}