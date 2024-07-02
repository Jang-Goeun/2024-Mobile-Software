package dduw.com.mobile.finalreport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dduw.com.mobile.finalreport.data.DiaryDto
import dduw.com.mobile.finalreport.databinding.ListItemBinding

class DiaryAdapter(val diarys: ArrayList<DiaryDto>) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {
    override fun getItemCount(): Int = diarys.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryViewHolder(itemBinding, listener, longListener)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        var index = diarys[position].id
        var image = R.mipmap.feel01
        when(index%6){     // 나머지에 따라 임의의 이미지 배정
            0 -> image = R.mipmap.feel01
            1 -> image = R.mipmap.feel02
            2 -> image = R.mipmap.feel03
            3 -> image = R.mipmap.feel04
            4 -> image = R.mipmap.feel05
            5 -> image = R.mipmap.feel06
        }
        holder.itemBinding.tvPhoto.setImageResource( image)
        holder.itemBinding.tvDay.text = diarys[position].day
        holder.itemBinding.tvWeather.text = diarys[position].weather
        holder.itemBinding.tvTitle.text = diarys[position].title
    }

    inner class DiaryViewHolder(val itemBinding: ListItemBinding, listener: OnItemClickListener?, longListener: OnItemLongClickListener?) : RecyclerView.ViewHolder(itemBinding.root){
        init {
            //클릭
            itemBinding.root.setOnClickListener{
                listener?.onItemClick(it, adapterPosition)  // adapterPosition 은 클릭 위치 index
            }

            //롱클릭
            itemBinding.root.setOnLongClickListener{
                longListener?.onItemLongClick(it, adapterPosition)
                true
            }

        }
    }



    //클릭 이벤트 리스너
    interface OnItemClickListener {
        fun onItemClick(view : View, position : Int)
    }

    var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    //롱클릭 이벤트 리스너
    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    var longListener : OnItemLongClickListener? = null

    fun setOnItemLongClickListener(listener: OnItemLongClickListener?) {
        this.longListener = listener
    }
}