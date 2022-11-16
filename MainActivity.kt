package com.example.vizesinavihazirlik2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

// Vizeye Yönelik Ders :
/*
 RadioButton dan işlem seçilen Hesap Makinesi Yapımı ve
 datePicker a girilen tarihe göre doğum tarihi göstertme :
 */

class MainActivity : AppCompatActivity() {

    lateinit var editTextAd: EditText
    lateinit var editTextSayi1: EditText
    lateinit var editTextSayi2: EditText
    lateinit var RGislemler: RadioGroup
    lateinit var radiobuttonTopla:RadioButton
    lateinit var radiobuttonCikart:RadioButton
    lateinit var radiobuttonCarp:RadioButton
    lateinit var radiobuttonBol:RadioButton
    lateinit var spinner: Spinner
    lateinit var textViewSonuc: TextView
    lateinit var button: Button // Bu tanımlamalarda hata yapmamaya ÖZEN göster DİKKATLİ OL !

    fun init(){
        editTextAd = findViewById(R.id.editTextAd)
        editTextSayi1 = findViewById(R.id.editTextSayi1)
        editTextSayi2 = findViewById(R.id.editTextSayı2)
        RGislemler = findViewById(R.id.RGislemler)
        radiobuttonTopla = findViewById(R.id.radiobuttonTopla)
        radiobuttonCikart = findViewById(R.id.radiobuttonCikart)
        radiobuttonCarp = findViewById(R.id.radiobuttonCarp)
        radiobuttonBol = findViewById(R.id.radiobuttonBol)
        spinner = findViewById(R.id.spinner)
        textViewSonuc = findViewById(R.id.textViewSonuc)
        button = findViewById(R.id.button)
    }


    var SecilenIslemRB = ""
    var Sayi1 = 0
    var Sayi2 = 0
    var SecilenIslemSP = ""
    var sonuc = 0
    var sayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       init()

        button.setOnClickListener {

            intent = Intent(this@MainActivity,ActivitySonuclar::class.java)

            var Ad = editTextAd.text.toString()
            intent.putExtra("isim",Ad)

            // Spinner ve RadioGroup verilerini gönderme işlemi :

            intent.putExtra("SPsecilenislem",SecilenIslemSP)
            intent.putExtra("RGsecilenislem",SecilenIslemRB)
            intent.putExtra("sonuc",sonuc)


            startActivity(intent)


        } // button sonu

        // RadioGroup İşlemleri (Hesap Makinesi):

        RGislemler.setOnCheckedChangeListener { group, checkedId ->
            Toast.makeText(this@MainActivity,"RadioGroup kullandınız",Toast.LENGTH_SHORT).show()
            if(checkedId == R.id.radiobuttonTopla){
                Sayi1 = editTextSayi1.text.toString().toInt()
                Sayi2 = editTextSayi2.text.toString().toInt()
                sonuc = Sayi1 + Sayi2
                textViewSonuc.text = sonuc.toString()
                SecilenIslemRB = "Toplama"
            }
            else if(checkedId == R.id.radiobuttonCikart){
                Sayi1 = editTextSayi1.text.toString().toInt()
                Sayi2 = editTextSayi2.text.toString().toInt()
                sonuc = Sayi1 - Sayi2
                textViewSonuc.text = sonuc.toString()
                SecilenIslemRB = "Çıkartma"
            }
            else if(checkedId == R.id.radiobuttonCarp){
                Sayi1 = editTextSayi1.text.toString().toInt()
                Sayi2 = editTextSayi2.text.toString().toInt()
                sonuc = Sayi1 * Sayi2
                textViewSonuc.text = sonuc.toString()
                SecilenIslemRB = "Çarpma"
            }
            else if(checkedId == R.id.radiobuttonBol){
                Sayi1 = editTextSayi1.text.toString().toInt()
                Sayi2 = editTextSayi2.text.toString().toInt()
                sonuc = Sayi1 / Sayi2
                textViewSonuc.text = sonuc.toString()
                SecilenIslemRB = "Bölme"
            }

        } // RG sonu

       // Spinner İşlemleri :

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,"Spinner kullandınız",Toast.LENGTH_SHORT).show()
                if(sayac == 0){ sayac++ }
                else {
                    when(position){
                        0->{ Sayi1 = editTextSayi1.text.toString().toInt()
                             Sayi2 = editTextSayi2.text.toString().toInt()
                             sonuc = Sayi1 + Sayi2
                            textViewSonuc.text = sonuc.toString()
                             SecilenIslemSP = "Toplama"}

                        1->{ Sayi1 = editTextSayi1.text.toString().toInt()
                            Sayi2 = editTextSayi2.text.toString().toInt()
                            sonuc = Sayi1 - Sayi2
                            textViewSonuc.text = sonuc.toString()
                            SecilenIslemSP = "Çıkartma"}

                        2->{ Sayi1 = editTextSayi1.text.toString().toInt()
                            Sayi2 = editTextSayi2.text.toString().toInt()
                            sonuc = Sayi1 * Sayi2
                            textViewSonuc.text = sonuc.toString()
                            SecilenIslemSP = "Çarpma"}

                        3->{ Sayi1 = editTextSayi1.text.toString().toInt()
                            Sayi2 = editTextSayi2.text.toString().toInt()
                            sonuc = Sayi1 / Sayi2
                            textViewSonuc.text = sonuc.toString()
                            SecilenIslemSP = "Bölme"}
                    }
                } // else sonu
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
}