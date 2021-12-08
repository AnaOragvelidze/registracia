package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {

     private lateinit var editTextEmail : EditText
     private lateinit var editTextPassword : EditText
     private lateinit var editTextPassword2 : EditText
     private lateinit var buttonLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init ()
    }

    private fun init () {
        editTextEmail = findViewById(R.id. editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPassword2 = findViewById(R.id. editTextPassword2)
        buttonLogin = findViewById(R.id. buttonLogin)

    }

    private fun registerListeners() {
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val password2 = editTextPassword2.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "შეიყვანეთ ელ.ფოსტა:", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isNotEmpty()) {
                Toast.makeText(this, "შეიყვანეთ პაროლი:", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 9) {
                Toast.makeText(this, "პაროლი უნდა შეიცავდეს 9 სიმბოლოს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password2.isNotEmpty()) {
                Toast.makeText(this, "გთხოვთ, გაიმეოროთ პაროლი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password2 != password) {
                Toast.makeText(this, "პაროლები ერთნაირი არ არის", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "თქვენ წარმატებით დარეგისტრირდით", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(
                            this,
                            "აღნიშნული ელ. ფოსტა არ არსებობს ან უკვე რეგისტრირებულია",
                            Toast.LENGTH_SHORT
                        ).show()


                    }


                }









