package com.zavierdev.lotieanimations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

class AnimationsFragment : Fragment() {
    companion object {
        const val ARG_ANIMATION = "AnimationFragment SEND RESOURCE ANIMATION"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(ARG_ANIMATION) }?.apply {
            val animationView: LottieAnimationView = view.findViewById(R.id.lottie_anim_view)
            val animationUrl = getString(ARG_ANIMATION)
            animationView.setAnimationFromUrl(animationUrl)
        }
    }
}