package com.example.vizesinavihazirlik2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ActivitySonuclar : AppCompatActivity() {

    lateinit var textViewAd: TextView
    lateinit var textViewRBSecilenIslem: TextView
    lateinit var textViewSPSecilenIslem: TextView
    lateinit var textViewSonucu: TextView
    lateinit var spinner2: Spinner
    lateinit var ekran :ConstraintLayout // -> Renk değiştirmek için bunu tanımlarız

    fun init(){

        textViewAd = findViewById(R.id.textViewAd)
        textViewRBSecilenIslem = findViewById(R.id.textViewRBSecilenIslem)
        textViewSPSecilenIslem = findViewById(R.id.textViewSPSecilenIslem)
        textViewSonucu = findViewById(R.id.textViewSonucu)
        spinner2 = findViewById(R.id.spinner2)
        ekran = findViewById(R.id.ekran)
    }

    var sayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuclar)

        init()

        var bundle : Bundle
        bundle = intent.extras!!

        var isim = bundle?.get("isim")
        textViewAd.text= isim.toString()

        var RBsecilenislm = bundle?.get("RGsecilenislem")
        textViewRBSecilenIslem.text= RBsecilenislm.toString()

        var SPsecilenislm = bundle?.get("SPsecilenislem")
        textViewSPSecilenIslem.text= SPsecilenislm.toString()

        var sonucu = bundle?.get("sonuc")
        textViewSonucu.text= sonucu.toString()



        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if(sayac==0){ sayac++ }
                else{
                    when(position){
                        0->{ekran.setBackgroundColor(Color.RED)}
                        1->{ekran.setBackgroundColor(Color.GREEN)}
                        2->{ekran.setBackgroundColor(Color.GRAY)}
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }





    }
}