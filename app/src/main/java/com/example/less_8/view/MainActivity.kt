package com.example.less_8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.less_8.R.*
import com.example.less_8.R.color.*
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.example.less_8.R
import com.example.less_8.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.container, MainFragment.newInstance())
                .commitNow()
            binding.buttonHome.setTextColor(getColor(purple_700))
            binding.buttonHome.setBackgroundColor(getColor(white))

        }
        initView()
    }

    private fun initView() {
//        initToolbar()
        //todo
        binding.buttonHome.setOnClickListener {
            addFragment(MainFragment())
        }
        binding.buttonFav.setOnClickListener {
            addFragment(HistoryFragment())
        }
        binding.buttonRat.setOnClickListener {
            addFragment(RatingsFragment())
        }
    }

    private fun initToolbar() {
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        //todo search
        return true
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.container, fragment).commit()
    }
}