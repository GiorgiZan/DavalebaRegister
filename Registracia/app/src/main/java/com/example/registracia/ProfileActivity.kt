package com.example.registracia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth



class ProfileActivity : AppCompatActivity() {

    private lateinit var logOutButton: Button
    private lateinit var emailShow: TextView
    private lateinit var  userId: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_acticity)


        logOutButton = findViewById(R.id.buttonLogOut)
        emailShow = findViewById(R.id.emailShow)
        userId = findViewById(R.id.userId)



        emailShow.text = "Email: ${FirebaseAuth.getInstance()?.currentUser?.email}"
        userId.text = "User Id : ${FirebaseAuth.getInstance()?.currentUser?.uid}"



        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity:: class.java))
            finish()
        }

    }
}