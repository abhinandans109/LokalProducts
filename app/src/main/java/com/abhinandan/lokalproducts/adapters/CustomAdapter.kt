package com.abhinandan.lokalproducts.adapters

import android.content.Intent
import android.content.Intent.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinandan.lokalproducts.DetailedActivity
import com.abhinandan.lokalproducts.R
import com.abhinandan.lokalproducts.models.productModel
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<productModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_model, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productModel = mList[position]
        holder.title.text = productModel.title
        Picasso.get().load(productModel.thumbnail)
            .placeholder(R.drawable.loading)
            .centerCrop()
            .resize(500,500)
            .into(holder.thumbnail)
        holder.itemView.setOnClickListener {
           val intent= Intent(holder.itemView.context, DetailedActivity::class.java)
            intent.flags =
                FLAG_ACTIVITY_BROUGHT_TO_FRONT or FLAG_ACTIVITY_REORDER_TO_FRONT or FLAG_FROM_BACKGROUND
            intent.putExtra("Data",productModel)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val thumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
        val title: TextView = itemView.findViewById(R.id.title)
    }
}
