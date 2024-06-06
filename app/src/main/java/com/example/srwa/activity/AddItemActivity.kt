package com.example.srwa.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srwa.Model.Fabric
import com.example.srwa.databinding.ActivityAddItemBinding
import com.google.firebase.database.FirebaseDatabase

class AddItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener {
            saveFabricToDatabase()
        }
    }

    private fun saveFabricToDatabase() {
        val id = binding.editTextId.text.toString().trim()
        val type = binding.editTextType.text.toString().trim()
        val color = binding.editTextColor.text.toString().trim()
        val quantityStr = binding.editTextQty.text.toString().trim()

        if (id.isEmpty() || type.isEmpty() || color.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val quantity = try {
            quantityStr.toInt()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show()
            return
        }

        val fabric = Fabric(id, type, color, quantity)
        val database = FirebaseDatabase.getInstance().reference.child("fabrics").child(id)
        database.setValue(fabric).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Fabric saved successfully", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to save fabric: ${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
