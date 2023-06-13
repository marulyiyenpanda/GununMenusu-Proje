package com.example.gnnmens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gnnmens.Adapter.OneriAdapter
import com.example.gnnmens.Model.Oneri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class OneriMenuler : AppCompatActivity() {
    private lateinit var oneriAdapter: OneriAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oneri_menuler)
        recyclerView = findViewById(R.id.recyclerViewoneri)

        val oneriListesi = listOf(
            Oneri(R.drawable.mercimek, R.drawable.izgara, R.drawable.muhallebi, "Öneri Menümüz (Mercimek, Izgara, Muhallebi) "),
            Oneri(R.drawable.mercimek, R.drawable.noodle, R.drawable.irmikhelva, "Öneri Menümüz(Mercimek, Sebzeli Noodle , İrmik Helvası) "),
            Oneri(R.drawable.kremalimantar, R.drawable.izgara, R.drawable.profiterol, "Öneri Menümüz(Kremalı Mantar Çorbası,Izgara,Profiterol ) "),
            Oneri(R.drawable.tavuksuyu, R.drawable.sinitzel, R.drawable.pannacotta, "Öneri Menümüz(Tavuk suyuna çorba ,Şinitzel, PannaCotta) "),
            Oneri(R.drawable.yogurt, R.drawable.sinitzel, R.drawable.tiramisu, "Öneri Menümüz (Yoğurt Çorbası,Şinitzel, Tiramisu)"),
            Oneri(R.drawable.telsehriye, R.drawable.mantarsote, R.drawable.muhallebi, "Öneri Menümüz(Tel Şehriyeli Çorba, Mantar Sote, Muhallebi) "),
            Oneri(R.drawable.tarhana, R.drawable.etsote, R.drawable.ciksufle, "Öneri Menümüz (Tarhana Çorbası , Et Sote, Çikolatalı Sufle)"),
            Oneri(R.drawable.ezogelin, R.drawable.mantarsote, R.drawable.cheescake, "Öneri Menümüz (Ezogelin Çorbası, Mantar Sote , CheesCake)"),
            Oneri(R.drawable.mercimek, R.drawable.bolonez, R.drawable.irmikhelva, " Öneri Menümüz (Mercimek Çorbası, Bolonez Spagetti, İrmik Helvası)"),
        )

        oneriAdapter = OneriAdapter(oneriListesi)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = oneriAdapter
    }
}
