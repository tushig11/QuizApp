package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var context: Context, var productList :ArrayList<Product>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imgIdentifier = context.resources.getIdentifier(productList[position].image, "drawable", context.packageName)
        holder.imgView.setImageResource(imgIdentifier)
        holder.name.text = productList[position].title
        holder.price.text = productList[position].price.toString()
        holder.color.text = productList[position].color

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            val item = productList[position]
            Toast.makeText(context," $item clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("title", item.title)
            intent.putExtra("image", item.image)
            intent.putExtra("color", item.color)
            intent.putExtra("price", item.price)
            intent.putExtra("desc", item.desc)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return productList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById<TextView>(R.id.name)
        var price: TextView = itemView.findViewById<TextView>(R.id.price)
        var color: TextView = itemView.findViewById<TextView>(R.id.color)
        var imgView : ImageView = itemView.findViewById<ImageView>(R.id.image)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.itemDisplay) as RelativeLayout
    }
}