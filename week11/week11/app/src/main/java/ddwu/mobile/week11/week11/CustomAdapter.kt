package ddwu.mobile.week11.week11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ddwu.mobile.week11.week11.databinding.ListWeatherBinding

class CustomAdapter (val weathers: ArrayList<WeatherDto>) : RecyclerView.Adapter<CustomAdapter.WeatherViewHolder>() {
    /*재정의 필수 - 데이터의 개수 확인이 필요할 떄 호출*/
    override fun getItemCount(): Int = weathers.size

    /*재정의 필수 - 각 item view의  view holder 생성 시 호출*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemBinding = ListWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(itemBinding)
    }

    /*재정의 필수 - 각 item view 의 항목에 데이터 결합 시 호출*/
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.itemBinding.tvNo.text = weathers[position].no
        holder.itemBinding.tvDong.text = weathers[position].dong
        holder.itemBinding.tvLoc.text = weathers[position].loc
        holder.itemBinding.tvWeather.text = weathers[position].weather
    }

    inner class WeatherViewHolder(val itemBinding: ListWeatherBinding) : RecyclerView.ViewHolder(itemBinding.root)
}