package com.google.android.gms.samples.vision.ocrreader

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var username:String
        var password:String

        username_input_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                print("hello")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                print("hello")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString() == "") {
                    login_button.setClickable(false)
                    login_button.setEnabled(false)
                    login_button.setBackgroundResource(R.drawable.disabled_button)
                }else{
                    login_button.setClickable(true)
                    login_button.setEnabled(true)
                    login_button.setBackgroundResource(R.drawable.button_background)
                }
            }

        })

        password_input_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString() == "") {
                    login_button.setClickable(false)
                    login_button.setEnabled(false)
                    login_button.setBackgroundResource(R.drawable.disabled_button)
                }else{
                    login_button.setClickable(true)
                    login_button.setEnabled(true)
                    login_button.setBackgroundResource(R.drawable.button_background)
                }
            }

        })

        login_button.setOnClickListener {
            username = username_input_text.text.toString()
            password = password_input_text.text.toString()
            Log.d("username : ",username)
            Log.d("password : ",password)

            if(username == "admin" && password == "admin") {
                error_message.text = ""
                intent = Intent(this , OcrCaptureActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)

                startActivity(intent)
            } else {
                error_message.text = "Your Credentials are wrong ! please change your username and password and retry !"
            }
        }
    }
}
