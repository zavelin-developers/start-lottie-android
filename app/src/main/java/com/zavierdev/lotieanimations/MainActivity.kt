package com.zavierdev.lotieanimations

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val animationUrl = listOf(
        "https://assets9.lottiefiles.com/packages/lf20_g0rjjzet.json",
        "https://assets6.lottiefiles.com/packages/lf20_ss10xmcn.json",
        "https://assets2.lottiefiles.com/packages/lf20_ghxcp9go.json",
        "https://assets1.lottiefiles.com/packages/lf20_bjyiojos.json",
        "https://assets4.lottiefiles.com/packages/lf20_pepphvu9.json"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tb_layout)
        val animationsViewpager: ViewPager2 = findViewById(R.id.animations_viewpager)
        val animationAdapter =
            AnimationAdapter(supportFragmentManager, lifecycle, animationUrl, animationUrl.size)

        animationsViewpager.adapter = animationAdapter
        TabLayoutMediator(tabLayout, animationsViewpager) { tab, position ->
            tab.text = "Animation ${position + 1}"
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.animation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_raw_animation -> {
                val intent = Intent(this, OfflineAnimationActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}