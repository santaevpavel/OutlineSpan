package ru.santaev.outlinespan

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import santaev.ru.outlinespan.R
import santaev.ru.outlinespan.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
    }

    @SuppressLint("SetTextI18n")
    private fun initUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val outlineSpan = OutlineSpan(
                strokeColor = Color.RED,
                strokeWidth = 4F
        )
        val outlineSpanBlue = OutlineSpan(
                strokeColor = Color.BLUE,
                strokeWidth = 2F
        )
        val text = "Outlined text"
        val spannable = SpannableString(text)
        spannable.setSpan(outlineSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(outlineSpanBlue, 9, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.simpleText.text = "Simple text"
        binding.outlinedText.text = spannable

        updateText()

        binding.root.setOnClickListener { updateText() }
    }


    private fun updateText() {
        val outlineSpan = OutlineSpan(
                strokeColor = Color.RED,
                strokeWidth = 2F
        )
        val text = getString(R.string.text)
        val spannable = SpannableString(text)
        val words = text.split(' ')
        val idx = Random().nextInt(words.size)
        val charIdx = words
                .asSequence()
                .take(idx)
                .sumBy { it.length + 1 }
        spannable.setSpan(
                outlineSpan,
                charIdx,
                charIdx + words[idx].length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.outlinedText2.text = spannable
    }

}
