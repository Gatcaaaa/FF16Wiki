package com.project.ff16char

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val listOFChar: ArrayList<Characterff16>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val charImg: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_character_ff16, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = listOFChar.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val (imgChar, nameChar, descChar) = listOFChar[position]
        holder.charImg.setImageResource(imgChar)
        holder.tvName.text = nameChar
        holder.tvDescription.text = descChar

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("CharacterImg", imgChar)
            intent.putExtra("CharacterName", nameChar)
            intent.putExtra("CharacterDescription", descChar)
            holder.itemView.context.startActivity(intent)
        }
    }
}