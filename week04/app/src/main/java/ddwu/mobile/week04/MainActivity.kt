package ddwu.mobile.week04

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myText : TextView = findViewById(R.id.textView)   // 실제 객체는 아니고 아이디 값임 -> 이를 가지고 실제 객체를 찾아야 함 -> findViewById()이용
        myText.text = "Goeun!!"
        myText.setTextColor(Color.GREEN)


        /*    val textView : TextView = TextView(this)
        textView.setText("코드로 문자열 출력")
        setContentView((textView))*/
    }

    fun onClick(view: View){
        val myEdit : EditText = findViewById(R.id.myEdit)

        val myText : TextView = findViewById(R.id.textView)

        myText.text = myEdit.text

        myEdit.setText("copy")

        Toast.makeText(this, "버튼을 클릭함", Toast.LENGTH_SHORT).show()
    }
}