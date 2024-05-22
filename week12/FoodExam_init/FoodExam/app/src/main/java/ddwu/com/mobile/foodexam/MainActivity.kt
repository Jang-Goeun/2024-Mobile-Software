package ddwu.com.mobile.foodexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.foodexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val TAG = "MainActivity"
    val DETAIL_ACTIVITY_CODE = 100
    val foods = FoodDao().foods
    val adapter = FoodAdapter(foods)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        // btnAdd를 클릭하면 AddFoodActivity 실행
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivityForResult(intent, DETAIL_ACTIVITY_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == DETAIL_ACTIVITY_CODE){
            when (resultCode){
                RESULT_OK -> {
                    val dto = FoodDao().foods
                    val result = data?.getSerializableExtra("newFood") as FoodDto
                    foods.add(result)
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, result.toString())
                }
                RESULT_CANCELED -> {
                    Log.d(TAG, "Canceled")
                }
            }
        }
    }
}