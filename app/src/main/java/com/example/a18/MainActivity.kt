package com.example.a18

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Navigation Drawer"

        toggle = ActionBarDrawerToggle(this@MainActivity, drawer,
            0, 0)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

       navView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_pplg -> {
                val fragmentPplg = supportFragmentManager.beginTransaction()
                fragmentPplg.replace(R.id.content, pplgFragment())
                fragmentPplg.commit()
                drawer.closeDrawers()
            }
            R.id.nav_busana -> {
                val fragmentBusana = supportFragmentManager.beginTransaction()
                fragmentBusana.replace(R.id.content, busanaFragment())
                fragmentBusana.commit()
                drawer.closeDrawers()
            }
            R.id.nav_to -> {
                val fragmentTo = supportFragmentManager.beginTransaction()
                fragmentTo.replace(R.id.content, toFragment())
                fragmentTo.commit()
                drawer.closeDrawers()
            }
            R.id.nav_tpfl -> {
                val fragmentTpfl = supportFragmentManager.beginTransaction()
                fragmentTpfl.replace(R.id.content, tpflFragment())
                fragmentTpfl.commit()
                drawer.closeDrawers()
            }
            R.id.nav_kuliner -> {
                val fragmentKuliner = supportFragmentManager.beginTransaction()
                fragmentKuliner.replace(R.id.content, kulinerFragment())
                fragmentKuliner.commit()
                drawer.closeDrawers()
            }
        }
        return true
    }
}