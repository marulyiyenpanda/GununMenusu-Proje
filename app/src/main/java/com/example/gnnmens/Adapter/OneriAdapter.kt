package com.example.gnnmens.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gnnmens.Model.Oneri
import com.example.gnnmens.R

class OneriAdapter(private val oneriListesi: List<Oneri>) : RecyclerView.Adapter<OneriAdapter.OneriViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneriViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.onerimenu, parent, false)
        return OneriViewHolder(view)
    }

    override fun onBindViewHolder(holder: OneriViewHolder, position: Int) {
        val oneri = oneriListesi[position]
        holder.bind(oneri)
    }

    override fun getItemCount(): Int {
        return oneriListesi.size
    }

    inner class OneriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView1: ImageView = itemView.findViewById(R.id.imageView1)
        private val imageView2: ImageView = itemView.findViewById(R.id.imageView2)
        private val imageView3: ImageView = itemView.findViewById(R.id.imageView3)
        private val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)

        fun bind(oneri: Oneri) {
            imageView1.setImageResource(oneri.imageResource1)
            imageView2.setImageResource(oneri.imageResource2)
            imageView3.setImageResource(oneri.imageResource3)
            textViewTitle.text = oneri.textTitle
        }
    }
}
