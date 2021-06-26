package com.cpo.landing

import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cpo.landing.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var rvMenu: RecyclerView
    private lateinit var listFiturAdapter:ListFiturAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataTitle: Array<String>
    private lateinit var dataIc: TypedArray
    private var list: ArrayList<Fitur> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFitur()


        binding.btnUnduhApp.setOnClickListener {
            val url = "https://drive.google.com/file/d/1cWJyrNcK8c-xg1_rxG_0EuR6_HGSOqOl/view?usp=sharing"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        binding.btnUnduhPetunjuk.setOnClickListener {
            val url = "https://drive.google.com/drive/folders/1PlnkcTQ3UzEZLtaD-F32QVEd2dmkHYGi?usp=sharing"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
    private fun showFitur(){
        rvMenu=binding.rvFitur
        rvMenu.setHasFixedSize(true)
        rvMenu.layoutManager = LinearLayoutManager(this)
        listFiturAdapter = ListFiturAdapter(list)
        list.addAll(getListFitur())
        rvMenu.adapter = listFiturAdapter
    }

    private fun getListFitur(): ArrayList<Fitur> {
        val listFitur= ArrayList<Fitur>()
        dataTitle = resources.getStringArray(R.array.data_title)

        dataIc = resources.obtainTypedArray(R.array.data_ic)
        for(position in dataTitle.indices){
            val fitur=Fitur(
                dataTitle[position],
                dataIc.getResourceId(position, -1)
            )
            listFitur.add(fitur)
        }
        return listFitur
    }
}