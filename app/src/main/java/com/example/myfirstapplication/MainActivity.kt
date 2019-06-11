package com.example.myfirstapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var editTextPassword: EditText
    lateinit var editTextUser: EditText
    lateinit var buttonLogin: Button

    private val TAG = "MainApplication"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPassword = findViewById<View>(R.id.editTextLoginPassword) as EditText
        editTextUser = findViewById<View>(R.id.editTextLoginUser) as EditText
        buttonLogin = findViewById<View>(R.id.buttonLogin) as Button

        val sharedPreferences = getSharedPreferences("KotlinPref", Context.MODE_PRIVATE)

        val isLogged = sharedPreferences.getBoolean("login-done", false)

        if (isLogged) {
            startActivity(Intent(this@MainActivity, ListActivity::class.java))
            finish()
        }

        buttonLogin.setOnClickListener {
            val isValid = editTextPassword.validatePassword()
            if (isValid) {
                // startActivity(Intent(this@MainActivity, ListActivity::class.java))

                val intent = Intent(this@MainActivity, ListActivity::class.java)
                intent.putExtra("User", editTextUser.text.toString())
                startActivity(intent)
                sharedPreferences.edit {
                    putBoolean("login-done", true)
                }
            } else {
                Toast.makeText(this@MainActivity, "Password invalid", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
