package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var productList: ArrayList<Product>

    private fun createStaticProducts(){
        //Products
        val jeansBlack = Product("0", "Black Jeans", 100.0, "black", "jeans_black", "Flexible jeans with black color")
        val jeansBlue = Product("1", "Blue Jeans", 80.0, "blue", "jeans_blue", "Flexible jeans with blue color")
        val hoodiePink = Product("2", "Pink Hoodie", 20.0, "pink", "hoodie_pink", "Nice hoodie for girls")
        val hoodieBlue = Product("3", "Blue Hoodie", 25.0, "blue", "hoodie_blue", "Nice hoodie for boys")
        val tShirt = Product("4", "Red T-shirt", 15.0, "red", "t_shirt_red", "Simple T-Shirt for everyone")
        val headset = Product("5", "Headset", 60.0, "pink", "headset", "Headset with inline microphone")

        productList = arrayListOf(jeansBlack, jeansBlue, hoodiePink, hoodieBlue, tShirt, headset)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createStaticProducts()
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = CustomAdapter(this, productList)
    }
}