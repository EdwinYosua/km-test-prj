package com.edwinyosua.kmtest.ui.fragment.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.edwinyosua.kmtest.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)

        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //inset for enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, windowsInsets ->
            val insets = windowsInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
                bottomMargin = insets.bottom
            }
            WindowInsetsCompat.CONSUMED
        }

        binding.apply {
            txtName.text = SecondFragmentArgs.fromBundle(arguments as Bundle).name

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnChooseUser.setOnClickListener {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment())
            }
        }
    }
}