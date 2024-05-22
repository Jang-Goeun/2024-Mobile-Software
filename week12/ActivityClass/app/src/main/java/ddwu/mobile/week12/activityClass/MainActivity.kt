package ddwu.mobile.week12.activityClass

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.week12.activityClass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    val TAG = "MainActivity"
    val DETAIL_ACTIVITY_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)

//            val dto = FoodDto(R.mipmap.ic_launcher, "치킨", 10)
//            intent.putExtra("food", dto)

//            startActivity(intent)
            startActivityForResult(intent, DETAIL_ACTIVITY_CODE)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == DETAIL_ACTIVITY_CODE){
            when (resultCode){
                RESULT_OK -> {
                    val result = data?.getStringExtra("result_data")
                    Log.d(TAG, result!!)
                }
                RESULT_CANCELED -> {
                    Log.d(TAG, "Canceled")
                }
            }
        }
    }

}