package com.example.warehouseapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srwa.Adapter.FabricAdapter
import com.example.srwa.Model.Fabric
import com.example.srwa.activity.AddItemActivity
import com.example.srwa.databinding.FragmentFabricBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FabricFragment : Fragment() {

    private lateinit var binding: FragmentFabricBinding
    private lateinit var fabricList: ArrayList<Fabric>
    private lateinit var fabricAdapter: FabricAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFabricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabricList = arrayListOf()
        fabricAdapter = FabricAdapter(fabricList)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = fabricAdapter

        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(context, AddItemActivity::class.java))
        }

        loadItemsFromDatabase()
    }

    private fun loadItemsFromDatabase() {
        val database = FirebaseDatabase.getInstance().reference.child("fabrics")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                fabricList.clear()
                for (dataSnapshot in snapshot.children) {
                    val fabric = dataSnapshot.getValue(Fabric::class.java)
                    fabric?.let {
                        fabricList.add(it)
                    }
                }
                fabricAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
