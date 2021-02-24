package com.example.helloworld
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    fun square(x:Int):Int {
        return x * x
    }
    fun hello(name: String?): Unit {
        if (name != null) {
            Log.d("if","Hello $name!")
        }
        else {
            Log.d("else", "Hi there")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // クリック時の処理
        findViewById<View>(R.id.morningBtn).setOnClickListener {
            val messageView = findViewById<TextView>(R.id.greetingText)
            messageView.text = getString(R.string.good_morning_text)

            val plus = {x: Int, y: Int -> x + y}
            Log.d("Tag","plus=" + plus(1,1))
            val plus2: (Int, Int ) -> Int = {x: Int, y: Int -> x + y}
            // ラムダ式を省略して記述できる
            Log.d("Tag","plus=" + plus2(2,2))
            // 上記のラムダ式を省略して記述できる
            val plus3: (Int, Int ) -> Int = {x, y -> x + y}
            Log.d("Tag","plus=" + plus3(3,3))
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