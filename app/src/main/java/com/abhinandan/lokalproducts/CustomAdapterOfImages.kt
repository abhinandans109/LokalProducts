import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinandan.lokalproducts.DetailedActivity
import com.abhinandan.lokalproducts.ImageViewerActivity
import com.abhinandan.lokalproducts.R
import com.abhinandan.lokalproducts.productModel
import com.squareup.picasso.Picasso

class CustomAdapterOfImages(private val mList: List<String>) : RecyclerView.Adapter<CustomAdapterOfImages.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_model, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imageUri = mList[position]
        Picasso.get().load(imageUri)
            .placeholder(R.drawable.loading)
            .into(holder.image)
        holder.itemView.setOnClickListener {
           var intent= Intent(holder.itemView.context, ImageViewerActivity::class.java)
            intent.putExtra("imageUrl",imageUri)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.imageModel)
    }
}
