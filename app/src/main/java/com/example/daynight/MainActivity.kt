package com.example.daynight


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dayOrNightLayout = findViewById<ConstraintLayout>(R.id.layout)
        val etDayOrNight = findViewById<EditText>(R.id.et_dayOrNight)
        val btnChangeBG = findViewById<Button>(R.id.btnChangeBG)
        val tvDayOrNight = findViewById<TextView>(R.id.tv_dayOrNight)

        btnChangeBG.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var dayOrNightStr = etDayOrNight.text?.toString()?.toLowerCase()
                when(dayOrNightStr){
                    "day"->{val time = Time()
                        time.changeBackground(dayOrNightLayout,1)
                        etDayOrNight.setTextColor(Color.BLACK)
                        tvDayOrNight.setTextColor(Color.BLACK)
                    }
                    "night"->{val time = Time()
                        time.changeBackground(dayOrNightLayout,0)
                        etDayOrNight.setTextColor(Color.WHITE)
                        tvDayOrNight.setTextColor(Color.WHITE)
                    }
                    else->{Toast.makeText(this@MainActivity, "wrong input", Toast.LENGTH_SHORT).show()
                    }}
            }

        })





    }
}



class Time {



    fun changeBackground(layout:View,Time:Int){

        when (Time){
            0->{layout.setBackgroundResource(R.drawable.night)}
            1->{layout.setBackgroundResource(R.drawable.day)}
        }

    }
}