package dduw.com.mobile.finalreport.data

import java.io.Serializable

data class DiaryDto(val id: Int, var day: String, var weather: String, var title: String, var content: String, var location: String) : Serializable {
    override fun toString() = "$id ($day) ($weather) ($title) ($content) ($location)"
}