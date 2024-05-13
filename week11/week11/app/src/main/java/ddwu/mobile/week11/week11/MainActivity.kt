package ddwu.mobile.week11.week11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.mobile.week11.week11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        /*데이터 준비*/
        val weathers = WeatherDao().weathers

        /*어댑터 생성*/
        val adapter = CustomAdapter(weathers)

        /*레이아웃 매니저 생성 및 설정*/
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        /*RecyclerView 에 레이아웃 매니저 및 Adapter 설정*/
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}