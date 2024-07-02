package dduw.com.mobile.finalreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dduw.com.mobile.finalreport.databinding.ActivityDevBinding

class DevActivity : AppCompatActivity() {
    val devBinding by lazy {
        ActivityDevBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(devBinding.root)

        // 돌아가기 버튼
        devBinding.backBtn.setOnClickListener{
            finish()
        }
    }
}