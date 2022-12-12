package com.practiceseven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practiceseven.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var result: String? =""
        childFragmentManager.setFragmentResultListener("main_data",this){
            _, bundle ->
            result = bundle.getString("text")
            binding.textView.text = result
        }
        binding.button.setOnClickListener{
            result?.let {
                findNavController().navigate(BlankFragmentDirections.toFragment2(it))
            }
        }
    }

}