package com.zavierdev.lotieanimations

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AnimationAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val animationUrls: List<String>,
    private val pages: Int
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = pages

    override fun createFragment(position: Int): Fragment {
        val animationsFragment = AnimationsFragment()
        animationsFragment.arguments = Bundle().apply {
            putString(AnimationsFragment.ARG_ANIMATION, animationUrls[position])
        }
        return animationsFragment
    }
}