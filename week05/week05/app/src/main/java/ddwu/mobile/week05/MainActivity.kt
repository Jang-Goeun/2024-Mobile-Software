package ddwu.mobile.week05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import ddwu.mobile.week05.databinding.ActivityMainBinding
import ddwu.mobile.week05.databinding.LinearLayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.linear_layout)

//        val mainBinding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        // val newBinding : NewLayoutBinding = NewLayoutBinding.inflate(layoutInflater)
//        setContentView(mainBinding.root)

        val linearBinding : LinearLayoutBinding = LinearLayoutBinding.inflate(layoutInflater)
        setContentView(linearBinding.root)

        linearBinding.button2.setOnClickListener {
            val layout : LinearLayout = findViewById(R.id.linear_layout)
            layout.orientation = LinearLayout.VERTICAL
        }

//        val button : Button = findViewById(R.id.button2)
//
//        button.setOnClickListener {
//            val layout : LinearLayout = findViewById(R.id.linear_layout)
//            layout.orientation = LinearLayout.VERTICAL
//        }
    }

//    fun onClick(view: View){
//        val layout : LinearLayout = findViewById(R.id.linear_layout)
//        layout.orientation = LinearLayout.VERTICAL
//    }
}