package ddwu.com.mobile.week06.sample.mycustomview

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.week06.sample.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selectedIdx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.myCustomView.setOnLongClickListener {
            val builder = AlertDialog.Builder(this).apply {
                setTitle("색상 선택")
                setSingleChoiceItems(
                    R.array.colors,
                    selectedIdx
                ) { dialogInterface: DialogInterface?, idx: Int ->
                    selectedIdx = idx
                }
                setPositiveButton("확인") { dialogInterface: DialogInterface?, idx: Int ->
                    val colors = resources.getStringArray(R.array.colors)
                    val color = Color.parseColor(colors[selectedIdx])
                    mainBinding.myCustomView.paintColor = color
                    mainBinding.myCustomView.invalidate()
                }
                setNegativeButton("취소", null)
            }
            builder.show()
            true
        }
    }

}
