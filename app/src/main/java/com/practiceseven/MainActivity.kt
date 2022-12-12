package com.practiceseven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.practiceseven.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.fragmentContainerView.getFragment<NavHostFragment>()
        val firstFragment = navHostFragment.childFragmentManager.fragments[0] as BlankFragment

        firstFragment.childFragmentManager
            .setFragmentResult(
                "main data",
                bundleOf("text" to "data_from_main_activity")
            )
    }
}