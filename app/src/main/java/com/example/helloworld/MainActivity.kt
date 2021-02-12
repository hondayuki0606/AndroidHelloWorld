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

            val strs: MutableSet<String> = mutableSetOf("ABC","BCD","CDE")
            strs.add("CDE")
            // 実行結果
            // false
            print(strs)
            // 実行結果
            // [ABC,BCD,CDE]
            strs.add("DEF")
            strs.remove("BCD")
            // 実行結果
            // [ABC,CDE,DEF]

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