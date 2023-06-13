package com.example.gnnmens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DishMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_menu)

        val mealName = intent.getStringExtra("mealName")
        val mealImage = intent.getIntExtra("mealImage", 0)
        val mealTarif = intent.getStringExtra("mealtarif")
        val mealNameTextView: TextView = findViewById(R.id.dishNameTextView)
        mealNameTextView.text = mealName
        val mealImageView: ImageView = findViewById(R.id.dishImageView)
        mealImageView.setImageResource(mealImage)
        val mealtarif: TextView = findViewById(R.id.tarif)
        mealtarif.text = mealTarif


    }
}

