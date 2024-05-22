package ddwu.mobile.week12.activityClass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.week12.activityClass.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    val detailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    val TAG = "DetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(detailBinding.root)

//        val data = intent.getSerializableExtra("food") as FoodDto
//        Log.d(TAG, "음식: ${data.food}")

        detailBinding.btnResult.setOnClickListener{
            val resultIntent = Intent()
            resultIntent.putExtra("result_data", "돌려받은 결과")

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}