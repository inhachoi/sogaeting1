package com.example.sogating_final.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.sogating_final.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_intro.joinBtn
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    private val TAG = "JoinActivity"
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        // Initialize Firebase Auth
        auth = Firebase.auth

        joinBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(emailArea.text.toString(), pwdArea.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    }
                }

        }

    }
}