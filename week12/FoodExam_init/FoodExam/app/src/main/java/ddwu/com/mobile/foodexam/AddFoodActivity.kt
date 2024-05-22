package ddwu.com.mobile.foodexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwu.com.mobile.foodexam.databinding.ActivityAddFoodBinding

class AddFoodActivity : AppCompatActivity() {
    val TAG = "AddFoodActivity"
    lateinit var binding : ActivityAddFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val newFood = binding.etNewFood.text.toString()
            val country = binding.etCountry.text.toString()
            val intent = Intent()
            val dto = FoodDto(newFood, country)
            intent.putExtra("newFood", dto)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnCancel.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}