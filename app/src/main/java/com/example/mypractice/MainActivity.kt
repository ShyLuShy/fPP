package com.example.mypractice

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.mypractice.activities.FightActivity
import com.example.mypractice.activities.InventoryActivity
import com.example.mypractice.activities.ItemsActivity
import com.example.mypractice.activities.MapsActivity
import com.example.mypractice.activities.ShelterActivity
import com.example.mypractice.activities.TraderActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Загрузка шрифта из файла
        val customFont = ResourcesCompat.getFont(this, R.font.zword)

// Установка шрифта для текста в action bar
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val customView = layoutInflater.inflate(R.layout.custom_action_bar, null)
        customView.findViewById<TextView>(R.id.customActionBarTitle).apply {
            text = getText(R.string.app_name)
            typeface = customFont
        }
        supportActionBar?.customView = customView


        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorOnSecondaryLight)))

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorOnSecondary));


        // переход в Карты
        val mapView: ImageView = findViewById(R.id.mapView)
        mapView.setOnClickListener{
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            startActivity(intent)
        }

        // Переход в Ведение боя
        val fightView: ImageView = findViewById(R.id.fightView)
        fightView.setOnClickListener{
            val intent = Intent(this@MainActivity, FightActivity::class.java)
            startActivity(intent)
        }

        // Переход в Убежище
        val shelterView: ImageView = findViewById(R.id.shelterView)
        shelterView.setOnClickListener{
            val intent = Intent(this@MainActivity, ShelterActivity::class.java)
            startActivity(intent)
        }

        // Переход в Инвентарь
        val inventoryView: ImageView = findViewById(R.id.inventoryView)
        inventoryView.setOnClickListener{
            val intent = Intent(this@MainActivity, InventoryActivity::class.java)
            startActivity(intent)
        }

        // Переход в Торговцы
        val traderView: ImageView = findViewById(R.id.traderView)
        traderView.setOnClickListener{
            val intent = Intent(this@MainActivity, TraderActivity::class.java)
            startActivity(intent)
        }

        // Переход в Предметы
        val itemView: ImageView = findViewById(R.id.itemView)
        itemView.setOnClickListener{
            val intent = Intent(this@MainActivity, ItemsActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.info){
            showAboutDialog(this)
        }

        return true
    }

    private fun showAboutDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("О программе")
        val message = "Программа разработана\nв рамках производственной практики, прошедшей в " +
                "«МБДОУ Детский сад № 20 «Ромашка»\n\nВыполнил: Ефименко Максим"
        builder.setMessage(message)

        builder.setPositiveButton("Закрыть") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()


    }

}