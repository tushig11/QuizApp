package com.example.quizapp

data class Product(var id:String, var title:String, var price:Double, var color:String, var image:String, var desc:String){
    override fun toString(): String {
        return "$title / Price: $price"
    }
}