package com.example.databinding

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this

        binding.copyButton.setOnClickListener {
            Log.d("TEst", "testestest")
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("copy pass", binding.accountText.text.toString()) //label, 복사할 값
            clipboardManager.setPrimaryClip(clip) //클립보드에 데이터 set
            Toast.makeText(this.applicationContext, "복사가 완료되었습니다.", Toast.LENGTH_SHORT).show()
        }
        binding.sendMony.setOnClickListener {
            Toast.makeText(this.applicationContext, "이걸 누른 당신 새해 복 받아라!", Toast.LENGTH_SHORT).show()
        }

    }
}