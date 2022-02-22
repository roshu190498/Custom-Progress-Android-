package com.example.customprogressdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sample_one.*

class SampleOne : AppCompatActivity() {

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_one)

        timer = countDownTimerWithProgress(
            tvCounter,
            60000,
            1000
        )
        timer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

    fun countDownTimerWithProgress(
        txtTimer: TextView?,
        timer: Long,
        countDownInterval: Long
    ): CountDownTimer? {
        var countDownTimer: CountDownTimer?
        countDownTimer = object : CountDownTimer(timer, countDownInterval) {
            override fun onFinish() {
                txtTimer?.text = "0"
                pbCounter.progress = 0
                countDownTimer = null
            }

            override fun onTick(millisUntilFinished: Long) {
                var seconds = (millisUntilFinished / 1000).toInt()
                seconds %= 60
                txtTimer?.text = (millisUntilFinished / 1000).toString()
                pbCounter.progress = (millisUntilFinished / 1000)?.toInt()
            }
        }
        return countDownTimer
    }

}