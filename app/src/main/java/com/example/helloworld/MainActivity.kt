package com.example.helloworld
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ShowableListMenu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // クリック時の処理
        findViewById<View>(R.id.morningBtn).setOnClickListener {
            val messageView = findViewById<TextView>(R.id.greetingText)
            messageView.text = getString(R.string.good_morning_text)
            val s: Short = 10
            val i: Int
            i = s.toInt()
            val ints: List<Int> = listOf<Int>(1,3,5)
            print(ints)
            print(ints[0])
            print(ints.get(1))
            print(ints.size)
            // 実行結果
            // [1,3,5]133

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