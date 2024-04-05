package ddwu.mobile.a20200298

import android.app.Activity
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
    }

    fun onClick(view: View){
        if (view.getId() == R.id.btnHello) {
            val etName : EditText = findViewById(R.id.etName)

            val etPhone : EditText = findViewById(R.id.etPhone)

            Toast.makeText(this, "안녕하세요, 저는 ${etName.text} 입니다. 전화번호는 ${etPhone.text} 입니다.", Toast.LENGTH_SHORT).show()
        } else{
            finish()
        }
    }
}