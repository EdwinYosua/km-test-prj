package com.edwinyosua.kmtest.ui.fragment.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinyosua.kmtest.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_third, container, false)

        _binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}