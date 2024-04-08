package ddwu.mobile.eventtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ddwu.mobile.eventtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    val TAG = "MainActivity"
    val mainBinding: ActivityMainBinding  by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

//        val myClick = object: View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity, "익명 리스너 인터페이스 구현", Toast.LENGTH_SHORT).show()
//            }
//        }
//        mainBinding.myButton.setOnClickListener (myClick)

//        mainBinding.mainLayout.setOnLongClickListener {
//            Toast.makeText(this@MainActivity, "롱클릭", Toast.LENGTH_SHORT).show()
//            true  //롱클릭은 반환값이 있어야 함.
//        }

        mainBinding.myButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "SAM 적용", Toast.LENGTH_SHORT).show()

            Log.d(TAG, "SAM 적용")
        }
    }



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(mainBinding.root)
//        mainBinding.myButton.setOnClickListener(this)
//    }
//
//    override fun onClick(v: View?) {
//        Toast.makeText(this, "액티비티에서 구현", Toast.LENGTH_SHORT).show()
//    }



/*리스너 인터페이스 클래스 구현*/
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(mainBinding.root)
//
//        val myClick = MyClick(this)  // 2번으로 수행: MyClick 클래스 객체 생성
//
//        mainBinding.myButton.setOnClickListener( myClick )
//    }
//
//
//
//    class MyClick (val context: Context): View.OnClickListener {   // 1번으로 수행: MyClick 만들기
//        override fun onClick(v: View?) {
//            Toast.makeText(context, "리스너 인터페이스 구현 클래스", Toast.LENGTH_SHORT).show()
//        }
//    }
}