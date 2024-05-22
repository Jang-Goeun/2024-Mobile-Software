package ddwu.mobile.week12.activityClass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ddwu.mobile.week12.activityClass.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity()  {
    val subBinding by lazy {
        ActivitySubBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(subBinding.root)
    }
}