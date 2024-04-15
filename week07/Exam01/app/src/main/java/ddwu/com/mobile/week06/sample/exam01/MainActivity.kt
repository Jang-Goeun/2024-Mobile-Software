package ddwu.com.mobile.week06.sample.exam01

import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        mainBinding.btnDisplay.setOnClickListener{
            val text:String = mainBinding.etInput.text.toString()

            val builder = AlertDialog.Builder(this).apply {
                setTitle("입력 확인")
                setMessage("${text}를 입력하시겠습니까?")
                setPositiveButton("네") {dialogInerface : DialogInterface?, whichButton: Int ->
                    val tvDisplay = findViewById<TextView>(R.id.tvDisplay)
                    tvDisplay.text = mainBinding.etInput.text.toString()
                }
                setNegativeButton("아니오", null)
                setCancelable(true)
            }

            builder.show()
        }
    }

}