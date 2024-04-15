package ddwu.mobile.c1

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.c1.databinding.ActivityMainBinding
import ddwu.mobile.c1.databinding.DialogInterfaceBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // var selectedIdx = 0    라디오 버튼
    //var selectedItems = booleanArrayOf(false, false, false, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener{
            val dialogBinding = DialogInterfaceBinding.inflate(layoutInflater)

            val builder = AlertDialog.Builder(this).apply {
                setTitle("대화상자 제목")
                setView(dialogBinding.root)
                setIcon(R.mipmap.ic_launcher_round)
                setNegativeButton("취소", null)
                setCancelable(true)
            }

            builder.show()
        }
    }
}




//        val onOnClick = object :DialogInterface.OnClickListener {
//            override fun onClick(p0: DialogInterface?, whichButton: Int) {
//                Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        val onOnClick = DialogInterface.OnClickListener {
//            dialogInerface : DialogInterface?, whichButton: Int ->
//                Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_SHORT).show()
//        }

//setMessage("대화상자 메시지")
//setItems(R.array.foods) {
//    dialogInterface : DialogInterface?, idx: Int ->
//        val food = resources.getStringArray(R.array.foods)
//        Toast.makeText(this@MainActivity, "${food[idx]}", Toast.LENGTH_SHORT).show()
//}  아이템 항목을 선택할 수 있기 때문

//setSingleChoiceItems(R.array.foods, selectedIdx) {
//    dialogInterface : DialogInterface?, idx: Int ->
//        selectedIdx = idx
//}    라디오버튼
//setPositiveButton("확인"){
//       p0: DialogInterface?, whichButton: Int ->
//    val food = resources.getStringArray(R.array.foods)
//    Toast.makeText(this@MainActivity, "${food[selectedIdx]}", Toast.LENGTH_SHORT).show()
//}

//setMultiChoiceItems(R.array.foods, selectedItems){
//    p0: DialogInterface?, idx: Int, isChecked:Boolean ->
//        selectedItems[idx] = true
//}

//setPositiveButton("확인"){
//    p0: DialogInterface?, idx: Int ->
//        Log.d("MainActivity","${selectedItems.toList()}")
//        val food = resources.getStringArray(R.array.foods)
//        Toast.makeText(this@MainActivity, "${selectedItems.toList()}", Toast.LENGTH_SHORT).show()
//}




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