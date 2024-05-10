package ddwu.mobile.week10.recyclerviewtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val layout: Int, val list :  ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // RecyclerView 에 표시할 전체 뷰의 개수 == 원본 데이터의 개수
    override fun getItemCount(): Int {
        return list.size
    }

    // 각 항목의 뷰를 보관하는 Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(layout, parent, false)
        Log.d("MyViewHolder", "onCreateViewHolder")
        return MyViewHolder(view)
    }

    // Holder에 보관중인 View 에 원본 데이터 연결
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvText.text = list[position]
        Log.d("MyViewHolder", "onBindViewHolder")
    }

    // 항목의 뷰를 생성한 후 멤버변수로 보관하는 ViewHolder
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvText : TextView = view.findViewById(R.id.tvText)
        init {
            view.setOnClickListener{
                Toast.makeText(view.context, "항목 $adapterPosition View 터치!", Toast.LENGTH_SHORT).show()
            }

            view.setOnLongClickListener{
                list.removeAt(adapterPosition)
                this@MyAdapter.notifyDataSetChanged()
                true
            }

            tvText.setOnClickListener{
                Toast.makeText(view.context, "TextView Click!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}