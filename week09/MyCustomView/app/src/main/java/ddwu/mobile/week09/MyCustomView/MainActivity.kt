package ddwu.mobile.week09.MyCustomView

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.mobile.week09.MyCustomView.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selected : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        registerForContextMenu(mainBinding.myCustomView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
        when (selected) {
            1 -> {
                menu?.findItem(R.id.red)?.setChecked(true)
            }
            2 -> {
                menu?.findItem(R.id.blue)?.setChecked(true)
            }
            3 -> {
                menu?.findItem(R.id.green)?.setChecked(true)
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.bigger -> {
                mainBinding.myCustomView.radius += 10
            }
            R.id.smaller -> {
                mainBinding.myCustomView.radius -= 10
            }
        }

        mainBinding.myCustomView.invalidate()
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.red -> {
                mainBinding.myCustomView.paintColor = Color.RED
                selected = 1
            }
            R.id.blue -> {
                mainBinding.myCustomView.paintColor = Color.BLUE
                selected = 2
            }
            R.id.green -> {
                mainBinding.myCustomView.paintColor = Color.GREEN
                selected = 3
            }
        }
        mainBinding.myCustomView.invalidate()
        return true
    }
}