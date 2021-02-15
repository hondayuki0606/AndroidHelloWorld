package com.example.helloworld
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // クリック時の処理
        findViewById<View>(R.id.morningBtn).setOnClickListener {
            val messageView = findViewById<TextView>(R.id.greetingText)
            messageView.text = getString(R.string.good_morning_text)

            val score = 65
            if (score >= 60) {
                d("tag", "Pass")
            } else {
                d("tag", "Fail")
            }
            // 実行結果
            // Pass

            val decision = if (score >= 90) {
                "S"
            } else if (score >= 80) {
                "A"
            } else if (score >= 70) {
                "B"
            } else if (score >= 60) {
               "C"
            } else {
                "D"
            }
            d("tag", "decision=$decision")
        }
        // クリック時の処理
        findViewById<View>(R.id.afternoonBtn).setOnClickListener {
            val messageView = findViewById<TextView>(R.id.greetingText)
            messageView.text = getString(R.string.good_afternoon_text)
        }

        // クリック時の処理
        findViewById<View>(R.id.eveningBtn).setOnClickListener {
            val messageView = findViewById<TextView>(R.id.greetingText)
            messageView.text = getString(R.string.good_evening_text)
        }
    }
}