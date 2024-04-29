package ddwu.mobile.week09

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.week09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selected : Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.food_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        when (selected) {
            1 -> {
                menu?.findItem(R.id.food01)?.setChecked(true)
            }
            2 -> {
                menu?.findItem(R.id.food02)?.setChecked(true)
            }
            3 -> {
                menu?.findItem(R.id.food03)?.setChecked(true)
            }
            4 -> {
                menu?.findItem(R.id.food04)?.setChecked(true)
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.food01 -> {
                Toast.makeText(this, "짜장면", Toast.LENGTH_SHORT).show()
                selected = 2
            }
            R.id.food02 -> {
                Toast.makeText(this, "짬뽕", Toast.LENGTH_SHORT).show()
                selected = 2
            }
            R.id.food03 -> {
                Toast.makeText(this, "김치찌게", Toast.LENGTH_SHORT).show()
                selected = 3
            }
            R.id.food04 -> {
                Toast.makeText(this, "순두부찌개", Toast.LENGTH_SHORT).show()
                selected = 4
            }
        }
        return true
    }

    fun onMenuClick(item: MenuItem) {

    }
}