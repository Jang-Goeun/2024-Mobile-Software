package ddwu.com.mobile.week06.sample.exam01

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.com.mobile.week06.sample.exam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*viewBinding 관련 부분 작성할 것*/
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

//        val myClick = object: View.OnClickListener {
//            override fun onClick(v: View?) {
//                mainBinding.tvDisplay.text = mainBinding.etInput.text
//            }
//        }
//        mainBinding.btnOutput.setOnClickListener(myClick)

        mainBinding.btnOutput.setOnClickListener{
            mainBinding.tvDisplay.text = mainBinding.etInput.text
        }
    }
}