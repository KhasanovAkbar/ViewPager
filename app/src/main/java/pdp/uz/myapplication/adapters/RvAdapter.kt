package pdp.uz.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_view.view.*
import pdp.uz.myapplication.R

class RvAdapter(var imageList: ArrayList<Int>, var onMyItemClickListener: OnMyItemClickListener) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(img: Int) {
            itemView.image_view.setImageResource(img)
            itemView.setOnClickListener {
                onMyItemClickListener.onItemClick(img)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.image_view, null, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    interface OnMyItemClickListener {
        fun onItemClick(image: Int)
    }
}