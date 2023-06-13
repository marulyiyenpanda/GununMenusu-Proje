package com.example.gnnmens.Adapter

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gnnmens.DishMenu
import com.example.gnnmens.Model.Meal
import com.example.gnnmens.R

class dishAdapter : RecyclerView.Adapter<dishAdapter.RecipeViewHolder>() {
    private var arrayData = ArrayList<Meal>()
    private var selectedMeals = ArrayList<Meal>()

    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView? = null
        var imageView: ImageView? = null
        var tarif: TextView? = null


        init {
            textView = view.findViewById(R.id.tv_dish_name)
            imageView = view.findViewById(R.id.iv_dish_image)
            tarif = view.findViewById(R.id.tarif)

        }
    }

    fun setData(data: ArrayList<Meal>) {
        arrayData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dishlist, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayData.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = arrayData[position]
        holder.textView?.text = recipe.name
        holder.imageView?.setImageResource(recipe.imageResource)
        holder.tarif?.text = recipe.tarif

        holder.imageView?.setOnClickListener {
            holder.imageView?.setOnClickListener {
                // Tıklanan yemeği seçili yemekler listesine ekle
                selectedMeals.add(recipe)
                Toast.makeText(
                    holder.itemView.context,
                    "Yemek sepete eklendi.",
                    Toast.LENGTH_SHORT
                ).show()

                val channelId = "my_channel_id"
                val notificationId = position // veya farklı bir benzersiz değer

                // Bildirim oluştur
                val builder = NotificationCompat.Builder(holder.itemView.context, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Yemek Sepete Eklendi")
                    .setContentText(recipe.name)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                // Bildirimi göster
                val notificationManager =
                    holder.itemView.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(notificationId, builder.build())
            }

        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DishMenu::class.java)
            intent.putExtra("mealName", recipe.name)
            intent.putExtra("mealImage", recipe.imageResource)
            intent.putExtra("mealtarif", recipe.tarif)
            holder.itemView.context.startActivity(intent)
        }
    }
}