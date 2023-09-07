package com.project.ff16char


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val CharacterImg = intent.getIntExtra("CharacterImg", R.id.img_item_photo)
        val CharacterName = intent.getStringExtra("CharacterName")
        val CharacterDescription = intent.getStringExtra("CharacterDescription")

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)

        imgPhoto.setImageResource(CharacterImg)
        tvName.text = CharacterName
        tvDescription.text = CharacterDescription
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail ,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                val CharacterName = intent.getStringExtra("CharacterName")
                val CharacterDescription = intent.getStringExtra("CharacterDescription")
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Character Name : " + CharacterName + "\n Character Description : " + CharacterDescription)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}