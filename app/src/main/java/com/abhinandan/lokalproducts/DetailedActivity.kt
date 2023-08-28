package com.abhinandan.lokalproducts

import com.abhinandan.lokalproducts.adapters.CustomAdapterOfImages
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinandan.lokalproducts.models.productModel

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val data : productModel = intent.getSerializableExtra("Data") as productModel
        supportActionBar?.title = data.title
        val recyclerview = findViewById<RecyclerView>(R.id.imageList)
        recyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        val adapter = CustomAdapterOfImages(data.images!!)
        recyclerview.adapter = adapter
        findViewById<TextView>(R.id.descriptionTextView).text=data.description
        findViewById<TextView>(R.id.category).text=data.category
        findViewById<TextView>(R.id.price).text="$ "+data.price.toString()
        findViewById<TextView>(R.id.rating).text=data.rating.toString()
        findViewById<TextView>(R.id.brand).text=data.brand
        findViewById<TextView>(R.id.stock).text=data.stock.toString()
        findViewById<TextView>(R.id.disper).text=data.discountPercentage.toString()

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
