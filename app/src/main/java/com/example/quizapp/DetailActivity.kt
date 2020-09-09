package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.hasExtra("image") && intent.hasExtra("title") && intent.hasExtra("color")  && intent.hasExtra("desc") && intent.hasExtra("price")){
            val image = resources.getIdentifier(intent.getStringExtra("image"), "drawable", packageName)
            val color = "Color: ${intent.getStringExtra("color")}"
            val price = "Price: ${intent.getDoubleExtra("price", 0.0).toString()}"
            detailName.text = intent.getStringExtra("title")
            detailColor.text = color
            detailPrice.text = price
            descDetail.text = intent.getStringExtra("desc")
            detailImage.setImageResource(image)
        }
    }
}