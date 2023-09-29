package com.ivan.week4app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In these lines you are assigning a View to a variable.
        // Using the function "findViewById" you are locating the view on the UI and assigning it to a variable
        // The type of view inside the <> is what you are looking for.
        // if for some reason the text shows in red, you can make use of the funcitonality of AndroidStudio,
        // placing your pointer on top of the View Type (in this case TextView) and press ALT+Enter (CMD+RETURN in mac)
        var welcomeText = findViewById<TextView>(R.id.helloWorldText)

        // Once you have assigned the view to the variable, you can start modifying all its attributes
        // ussually by typing a dot after the variable. and then the IDE (Android Studio) will provide some suggestions

        // To modify the text of the view welcometext, just type this line of code
        welcomeText.text ="Hello Again"

        //Repeat for all elements on screen
        var nameText = findViewById<TextView>(R.id.nameEditText)
//        nameText.text = "Ivan"


        var lastNameText = findViewById<TextView>(R.id.lastNameEditText)
//        lastNameText.text = "Zepeda"

        var helloButton = findViewById<Button>(R.id.helloButton)

        // When you want to LISTEN every time you CLICK on a BUTTON, you use the property of the button variable "serOnCLickListener"
        // inside of it you give a certain action.
        // change () to {} and then inside place your code.
        helloButton.setOnClickListener{
            //in this case, we want to show the text from name and lastname on the welcometext
            welcomeText.text = "Hello ${nameText.text} ${lastNameText.text}"

            //This is a condition, usually starts with "if"
            //This one is checkin ig welcomeText is Visible, if it is, then is TRUE,
            //therefore, the first block of code will be executed
            if(welcomeText.isVisible){
                // This line will set the visibility of welcomeText to INVISIBLE
                welcomeText.visibility = View.INVISIBLE

            }else {
                //  if the visibility is FALSE, then will run this code, which will set it to VISIBLE
                welcomeText.visibility = View.VISIBLE
            }


        }


        var nextButton  = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener{
            //Screens in android are called an Activity.
            // In android all actions are called "Intent"
            // When you are calling a new Activity, you do it with an INTENT
            // This is how you create an Intent, and want to call the activity called "SecondActivity"
            var intent  =  Intent(this, SecondActivity::class.java)
            // When you want to send information to the following screen, you can do it adding EXTRA information to the INTENT
            // where the first argument (transfering_name) is the name of how you are going to identify the variable,
            // and the second argument (nameText.text.toString()) is the value
            // MAke sure the datatype of your variable match on both activities, sending a string using ".toString()"
            intent.putExtra("transfering_name",nameText.text.toString())
            intent.putExtra("transfering_lastName",lastNameText.text.toString())

            startActivity(intent)

        }


    }
}