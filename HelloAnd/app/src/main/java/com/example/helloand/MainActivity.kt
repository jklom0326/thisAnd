package com.example.helloand

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var Button1:Button
        lateinit var Button2:Button
        lateinit var Button3:Button
        lateinit var Button4:Button

        Button1 = findViewById(R.id.button1)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)
        Button4 = findViewById(R.id.button4)

        Button1.setOnClickListener {
            val intent1 = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.naver.com/"))
            startActivity(intent1)
        }

        Button2.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW,Uri.parse("tel:/911"))
            startActivity(intent2)
        }

        Button3.setOnClickListener {
            val intent3 =Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"))
            startActivity(intent3)
        }

        Button4.setOnClickListener {
            finish()
        }

    }
}