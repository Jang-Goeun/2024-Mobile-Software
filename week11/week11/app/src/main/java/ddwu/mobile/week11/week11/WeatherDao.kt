package ddwu.mobile.week11.week11

class WeatherDao {
    val weathers = ArrayList<WeatherDto>()

    init{
        weathers.add(WeatherDto("01", "하월곡동","서울시 성북구","좋음"))
        weathers.add(WeatherDto("02", "상월곡동","서울시 성북구","좋음"))
        weathers.add(WeatherDto("03", "청천동","인천광역시 부평구","나쁨"))
        weathers.add(WeatherDto("04", "송현동","인천광역시 동구","나쁨"))
    }
}