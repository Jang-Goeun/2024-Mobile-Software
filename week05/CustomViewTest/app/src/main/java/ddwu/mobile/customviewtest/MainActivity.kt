package ddwu.mobile.customviewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import ddwu.mobile.customviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(mainBinding.root)
        //val myView = MyViewClass(this)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener {
            mainBinding.myView.color = Color.RED
            mainBinding.myView.invalidate()
        }
    }
}