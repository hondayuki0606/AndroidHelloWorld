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

            if(4 in 1..5){
                d("4 in 1..5", "true")
            } else {
                d("4 in 1..5", "false=")
            }
            val range: IntRange = 2..5
            range.toList()
            d("Print", "mfruies=$range.toList()")
            // 実行結果
            // D/Print: mfruies={apple=100, banana=60, pear=150}

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