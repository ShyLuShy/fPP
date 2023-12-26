package com.example.mypractice.activities

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.mypractice.R
import com.example.mypractice.maps.CustomsActivity
import com.example.mypractice.maps.FactoryActivity
import com.example.mypractice.maps.InterchangeActivity
import com.example.mypractice.maps.LaboratoryActivity
import com.example.mypractice.maps.LighthouseActivity
import com.example.mypractice.maps.ReserveActivity
import com.example.mypractice.maps.ShorelineActivity
import com.example.mypractice.maps.StreetsActivity
import com.example.mypractice.maps.WoodsActivity
import com.google.android.material.imageview.ShapeableImageView

class MapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

// Загрузка шрифта из файла
        val customFont = ResourcesCompat.getFont(this, R.font.zword)

// Установка шрифта для текста в action bar
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val customView = layoutInflater.inflate(R.layout.custom_action_bar, null)
        customView.findViewById<TextView>(R.id.customActionBarTitle).apply {
            text = getText(R.string.selectMap)
            typeface = customFont
        }
        supportActionBar?.customView = customView


        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorOnSecondaryLight)))

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorOnSecondaryDark));

        // Переход в Берег
        val shorelineButton: ShapeableImageView = findViewById(R.id.buttonShoreline)
        shorelineButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, ShorelineActivity::class.java)
            startActivity(intent)
        }

        // Переход в Таможня
        val customsButton: ShapeableImageView = findViewById(R.id.buttonCustoms)
        customsButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, CustomsActivity::class.java)
            startActivity(intent)
        }

        // Переход в Завод
        val factoryButton: ShapeableImageView = findViewById(R.id.buttonFactory)
        factoryButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, FactoryActivity::class.java)
            startActivity(intent)
        }

        // Переход в Развязка
        val interchangeButton: ShapeableImageView = findViewById(R.id.buttonInterchange)
        interchangeButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, InterchangeActivity::class.java)
            startActivity(intent)
        }

        // Переход в Маяк
        val lighthouseButton: ShapeableImageView = findViewById(R.id.buttonLighthouse)
        lighthouseButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, LighthouseActivity::class.java)
            startActivity(intent)
        }

        // Переход в Лес
        val woodsButton: ShapeableImageView = findViewById(R.id.buttonWoods)
        woodsButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, WoodsActivity::class.java)
            startActivity(intent)
        }

        // Переход в Резерв
        val reserveButton: ShapeableImageView = findViewById(R.id.buttonReserve)
        reserveButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, ReserveActivity::class.java)
            startActivity(intent)
        }

        // Переход в Улицы
        val streetsButton: ShapeableImageView = findViewById(R.id.buttonStreets)
        streetsButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, StreetsActivity::class.java)
            startActivity(intent)
        }

        // Переход в Лаборатория
        val labButton: ShapeableImageView = findViewById(R.id.buttonLab)
        labButton.setOnClickListener{
            val intent = Intent(this@MapsActivity, LaboratoryActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home) finish()

        return true
    }
}