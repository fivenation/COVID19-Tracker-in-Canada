package com.example.covid_19incanada

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.covid_19incanada.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val summaryFragment = SummaryFragment()
        val provinceFragment = ProvinceFragment()
        makeCurrentFragment(summaryFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener  {
            when(it.itemId){
                R.id.ic_summary -> makeCurrentFragment(summaryFragment)
                R.id.ic_province -> makeCurrentFragment(provinceFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}