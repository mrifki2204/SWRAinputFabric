package com.example.srwa.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srwa.Model.Fabric
import com.example.srwa.R
import com.google.firebase.database.FirebaseDatabase

class EditFabricActivity : AppCompatActivity() {

    private lateinit var fabricId: String
    private lateinit var typeEditText: EditText
    private lateinit var colorEditText: EditText
    private lateinit var quantityEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_fabric)

        fabricId = intent.getStringExtra("fabricId") ?: ""
        typeEditText = findViewById(R.id.editTextType)
        colorEditText = findViewById(R.id.editTextColor)
        quantityEditText = findViewById(R.id.editTextQty)
        saveButton = findViewById(R.id.buttonSave)

        saveButton.setOnClickListener {
            editFabricInDatabase()
        }

        deleteButton.setOnClickListener {
            deleteFabricFromDatabase()
        }

        // Retrieve Fabric details and populate the EditText fields
        val fabric = intent.getSerializableExtra("fabric") as Fabric?
        fabric?.let {
            typeEditText.setText(it.type)
            colorEditText.setText(it.color)
            quantityEditText.setText(it.qty.toString())
        }
    }

    private fun editFabricInDatabase() {
        val type = typeEditText.text.toString().trim()
        val color = colorEditText.text.toString().trim()
        val quantityString = quantityEditText.text.toString().trim()

        if (type.isEmpty() || color.isEmpty() || quantityString.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }

        val quantity = quantityString.toInt()

        val database = FirebaseDatabase.getInstance().reference.child("fabrics").child(fabricId)
        val fabric = Fabric(fabricId, type, color, quantity)

        database.setValue(fabric)
            .addOnSuccessListener {
                Toast.makeText(this, "Fabric updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to update fabric", Toast.LENGTH_SHORT).show()
            }
    }

    private fun deleteFabricFromDatabase() {
        val database = FirebaseDatabase.getInstance().reference.child("fabrics").child(fabricId)
        database.removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Fabric deleted successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to delete fabric", Toast.LENGTH_SHORT).show()
            }
    }
}
