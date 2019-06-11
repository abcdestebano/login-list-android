package com.example.myfirstapplication

import android.widget.EditText

fun EditText.validatePassword(): Boolean {
    return this.text.toString().isNotEmpty() && this.text.length > 6
}


