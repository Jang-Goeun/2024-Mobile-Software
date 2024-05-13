package ddwu.mobile.week11.week11

class WeatherDto(val no: String, val dong: String, var loc: String, val weather: String) {
    override  fun toString() = "$no $dong $loc $weather"
}