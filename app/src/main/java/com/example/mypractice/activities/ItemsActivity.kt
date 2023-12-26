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

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        // Загрузка шрифта из файла
        val customFont = ResourcesCompat.getFont(this, R.font.zword)

// Установка шрифта для текста в action bar
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val customView = layoutInflater.inflate(R.layout.custom_action_bar, null)
        customView.findViewById<TextView>(R.id.customActionBarTitle).apply {
            text = getText(R.string.items)
            typeface = customFont
        }
        supportActionBar?.customView = customView

        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorOnSecondaryLight)))

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorOnSecondaryDark));

        val itemsHelpView: SubsamplingScaleImageView = findViewById(R.id.shelterHelpView)
        itemsHelpView.setImage(ImageSource.resource(R.drawable.itemshelp));

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home) finish()

        return true
    }
}