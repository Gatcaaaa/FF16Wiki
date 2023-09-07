package com.project.ff16char

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFf16: RecyclerView
    private val list = ArrayList<Characterff16>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFf16 = findViewById(R.id.rv_Ff16)
        rvFf16.setHasFixedSize(true)

        list.addAll(getListCharacter())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main ,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutku -> {
                val intentAbout = Intent(this, AboutActivity::class.java)
                startActivity(intentAbout)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun getListCharacter() : ArrayList<Characterff16>{
        val dataImg = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listofCharacter = ArrayList<Characterff16>()
        for (i in dataName.indices){
            val character = Characterff16(dataImg.getResourceId(i, -1),dataName[i],dataDescription[i])
            listofCharacter.add(character)
        }
        return listofCharacter
    }
    private fun showRecyclerList(){
        rvFf16.layoutManager = LinearLayoutManager(this)
        val characterAdapter = CharacterAdapter(list)
        rvFf16.adapter = characterAdapter
    }
}