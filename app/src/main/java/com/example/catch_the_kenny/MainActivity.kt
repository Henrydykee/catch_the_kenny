package com.example.catch_the_kenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import kotlin.random.Random


class MainActivity : AppCompatActivity() {


    var score : Int = 0;
    var imageArray = ArrayList<ImageView>()
    var handler: Handler = Handler();
    var runnable : Runnable = Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeText :TextView = findViewById(R.id.timeText);
        val scoreText :TextView = findViewById(R.id.scoreText);
        val imageView : ImageView = findViewById(R.id.imageView)
        val imageView2 : ImageView = findViewById(R.id.imageView2)
        val imageView3 : ImageView = findViewById(R.id.imageView3)
        val imageView4 : ImageView = findViewById(R.id.imageView4)
        val imageView5 : ImageView = findViewById(R.id.imageView5)
        val imageView6 : ImageView = findViewById(R.id.imageView6)
        val imageView7 : ImageView = findViewById(R.id.imageView7)
        val imageView8 : ImageView = findViewById(R.id.imageView8)
        val imageView9 : ImageView = findViewById(R.id.imageView9)

        hideImages()

        score =0
        imageArray = arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)

        object:CountDownTimer(1000,10000){
            override fun onFinish() {
                timeText.text = "Time's Up"
                handler.removeCallbacks(runnable)
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                TODO("Not yet implemented")
            }

            override fun onTick(p0: Long) {
                timeText.text = "Time" + p0 / 1000
                TODO("Not yet implemented")
            }

        }.start()
    }



    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val random = Random
                val index = random.nextInt(8-0)
                imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }

    fun increaseScore(view: View) {
        val scoreText :TextView = findViewById(R.id.scoreText);
        score++
        scoreText.text = "Score: " + score
    }
}