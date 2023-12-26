package com.example.mypractice.activities

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.example.mypractice.R

class InventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        // Загрузка шрифта из файла
        val customFont = ResourcesCompat.getFont(this, R.font.zword)

// Установка шрифта для текста в action bar
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val customView = layoutInflater.inflate(R.layout.custom_action_bar, null)
        customView.findViewById<TextView>(R.id.customActionBarTitle).apply {
            text = getText(R.string.inventory)
            typeface = customFont
        }
        supportActionBar?.customView = customView

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorOnSecondaryLight)))

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorOnSecondaryDark));

        val inventoryView1: SubsamplingScaleImageView = findViewById(R.id.inventoryView1)
        inventoryView1.setImage(ImageSource.resource(R.drawable.inv1));

        val inventoryView2: SubsamplingScaleImageView = findViewById(R.id.inventoryView2)
        inventoryView2.setImage(ImageSource.resource(R.drawable.inv2));

        val inventoryView3: SubsamplingScaleImageView = findViewById(R.id.inventoryView3)
        inventoryView3.setImage(ImageSource.resource(R.drawable.inv3));

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home) finish()

        return true
    }
}