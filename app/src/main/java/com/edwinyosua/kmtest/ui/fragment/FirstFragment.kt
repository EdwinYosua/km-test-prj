package com.edwinyosua.kmtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.edwinyosua.kmtest.R
import com.edwinyosua.kmtest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)

        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }

            btnCheck.setOnClickListener {
                val palindrome = edtPalindrome.text?.trim().toString()

                if (checkPalindrome(palindrome)) {
                    showToast("isPalindrome")
                } else {
                    showToast("Not Palindrome")
                }

            }
        }
    }

    private fun checkPalindrome(palindrome: String) = palindrome == palindrome.reversed()

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}