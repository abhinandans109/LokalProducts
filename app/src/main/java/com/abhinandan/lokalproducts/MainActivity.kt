package com.abhinandan.lokalproducts

import com.abhinandan.lokalproducts.adapters.CustomAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinandan.lokalproducts.models.RetrofitBuilder
import com.abhinandan.lokalproducts.models.productModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerview: RecyclerView
    lateinit var data : List<productModel>
    lateinit var pb:ProgressBar
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pb=findViewById(R.id.pb)
        GlobalScope.launch {
             val response = RetrofitBuilder.getInstance().getProducts()
             if(response.isSuccessful){
               if(response.body()!=null){
                   data= response.body()!!.products
                   runOnUiThread {
                       recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
                       recyclerview.layoutManager = LinearLayoutManager(applicationContext)
                       adapter = CustomAdapter(data)
                       recyclerview.adapter = adapter
                       pb.visibility= View.GONE
                   }
               }else{
                   Log.e("LogTag","Data received incorrectly")
                   runOnUiThread{
                       pb.visibility= View.GONE
                   }
               }
            }else{
                 Log.e("LogTag","Api failed")
                 runOnUiThread{
                     pb.visibility= View.GONE
                 }
             }

        }

    }
}