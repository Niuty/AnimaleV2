package com.example.animale



import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.animale.Adapter.Adapter
import com.example.animale.interfaceNew.ItemClickListener
import com.example.animale.model.*


class MainActivity : AppCompatActivity() , ItemClickListener {

    private val mRecyclerView: RecyclerView? = null
    private val mAdapter: Adapter? = null
    private val mAnimals: MutableList<Entertainment> = ArrayList()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.RV_Animals)

        val animals: MutableList<Entertainment> = ArrayList()
        Log.e("FragmentRecyclerView", "onViewCreated:  merge")

        animals.add(ModelEuropa("Urs", "Europa"))
        animals.add(ModelAsia("Panda", "Asia"))
        animals.add(ModelAmerica("Vultur", "America"))
        animals.add(ModelAustralia("Cangur", "Australia"))
        animals.add(ModelAfrica("Leu", "Africa"))
        animals.add(ModelEuropa("Urs", "Europa"))
        animals.add(ModelEuropa("Urs", "Europa"))
        animals.add(ModelEuropa("Urs", "Europa"))


        //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext())
        mAnimals.addAll(animals)
        val adapter = Adapter(animals)

        recyclerView.adapter = adapter

        val closeButton = findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener { finishAffinity() }

        adapter.setClickListener(this)

    }


    override fun onClick(view: View, position: Int) {
        Log.e("main", "onClick: Merge  " + position.toString())
        setContentView(R.layout.animal_full)

        var nameTextView: TextView? = null
        var continentTextView: TextView? = null
        nameTextView = view.findViewById<TextView>(R.id.nameAnimal)
        continentTextView = view.findViewById<TextView>(R.id.continemAnimal)


        Log.e("main", mAnimals[position].type.name)
        var aux = mAnimals[position].toString()
        Log.e("main", aux.name)
        //nameTextView.setText(mAnimals[position].type.name.toString())
        //continentTextView.setText(mAnimals[position].type.key.toString())

    }


}