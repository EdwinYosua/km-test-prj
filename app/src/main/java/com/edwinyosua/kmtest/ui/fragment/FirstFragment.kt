package com.edwinyosua.kmtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.edwinyosua.kmtest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            btnNext.setOnClickListener {
                val sendDataToSecondFragment =
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment()

                if (edtName.text?.isEmpty() == true) {
                    sendDataToSecondFragment.name
                } else {
                    sendDataToSecondFragment.name = edtName.text?.trim().toString()
                }

                findNavController().navigate(sendDataToSecondFragment)
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

    private fun checkPalindrome(palindrome: String) =
        palindrome.equals(palindrome.reversed(), ignoreCase = true)

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}