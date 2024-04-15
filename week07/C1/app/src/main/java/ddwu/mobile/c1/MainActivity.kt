package ddwu.mobile.c1

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.c1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainBinding.root)

//        val onOnClick = object :DialogInterface.OnClickListener {
//            override fun onClick(p0: DialogInterface?, whichButton: Int) {
//                Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_SHORT).show()
//            }
//        }

        val onOnClick = DialogInterface.OnClickListener {
            dialogInerface : DialogInterface?, whichButton: Int ->
                Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_SHORT).show()
        }

        mainBinding.button.setOnClickListener{
            val builder = AlertDialog.Builder(this).apply {
                setTitle("대화상자 제목")
                setMessage("대화상자 메시지")
                setIcon(R.mipmap.ic_launcher_round)
                setPositiveButton("확인", onOnClick)
                setNegativeButton("취소") { p0: DialogInterface?, whichButton: Int ->
                    Toast.makeText(this@MainActivity, "취소!", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("대기", { p0: DialogInterface?, whichButton: Int ->
                    Toast.makeText(this@MainActivity, "대기!", Toast.LENGTH_SHORT).show()
                })
                setCancelable(true)
            }

//            val builder : AlertDialog.Builder = AlertDialog.Builder(this)
//            builder.setTitle("대화상자 제목")
//            builder.setMessage("대화상자 메시지")
//            builder.setIcon(R.mipmap.ic_launcher_round)
//            builder.setPositiveButton("확인", null)
//            builder.setNeutralButton("대기", null)
//            builder.setNegativeButton("취소", null)
//            builder.setCancelable(false)

            //val dialog: Dialog = builder.create()
            // dialog.show()
            builder.show()
        }
    }
}







