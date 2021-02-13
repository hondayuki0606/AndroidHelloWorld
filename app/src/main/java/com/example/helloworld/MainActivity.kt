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

            val fruies: Map<String, Int> = mapOf("apple" to 100, "orange" to 80, "banana" to 60)
            print(fruies["apple"])
            // 実行結果
            // 100
            print(fruies["orange"])
            // 実行結果
            // 80
            val mfruies: MutableMap<String, Int> = mutableMapOf("apple" to 100, "orange" to 80, "banana" to 60)
            mfruies.put("pear", 150)
            mfruies.remove("orange")
            d("Print", "mfruies=$mfruies")
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