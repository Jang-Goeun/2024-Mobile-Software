package ddwu.mobile.week11.foodrecyclerviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ListItemBinding

class FoodAdapter(val foods: ArrayList<FoodDto>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    /*재정의 필수 - 데이터의 개수 확인이 필요할 떄 호출*/
    override fun getItemCount(): Int = foods.size

    /*재정의 필수 - 각 item view의  view holder 생성 시 호출*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        //val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        //return FoodViewHolder(itemView)
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(itemBinding)
    }

    /*재정의 필수 - 각 item view 의 항목에 데이터 결합 시 호출*/
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        holder.photo.setImageResource( foods[position].photo)
//        holder.food.text = foods[position].food
//        holder.count.text = foods[position].count.toString()
        holder.itemBinding.ivPhoto.setImageResource( foods[position].photo)
        holder.itemBinding.tvFood.text = foods[position].food
        holder.itemBinding.tvCount.text = foods[position].count.toString()
    }

    //inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    inner class FoodViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        val TAG = "FoodViewHolder"
        init {
//            itemBinding.root.setOnClickListener{
//                listener.onItemClick(it, adapterPosition)
//            }

            itemBinding.root.setOnLongClickListener{
                longClickListener.onItemLongClick(it, adapterPosition)
            }
        }
    }
//    val photo = view.findViewById<ImageView>(R.id.ivPhoto)
//        val food = view.findViewById<TextView>(R.id.tvFood)
//        val count = view.findViewById<TextView>(R.id.tvCount)

//    interface  OnItemClickListener {
//        fun onItemClick(view: View, position: Int)
//    }
//
//    lateinit var listener: OnItemClickListener
//
//    fun setOnItemClickListner (listener: OnItemClickListener){
//        this.listener = listener
//    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int) : Boolean
    }

    lateinit var longClickListener: OnItemLongClickListener

    fun setOnItemLongClickListener (longClickListener: OnItemLongClickListener){
        this.longClickListener = longClickListener
    }
}