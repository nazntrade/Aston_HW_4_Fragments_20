package com.becker.aston_hw_4_fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_4_fragments.databinding.FragmentCBinding
import com.becker.aston_hw_4_fragments.task1.FragmentB.Companion.PASSED_TEXT_FROM_B_TO_C_EXTRA
import com.becker.aston_hw_4_fragments.task1.FragmentD.Companion.FRAGMENT_D_TAG

class FragmentC : Fragment() {

    private var textFromFragmentB: String? = null
    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textFromFragmentB = arguments?.getString(PASSED_TEXT_FROM_B_TO_C_EXTRA)

        with(binding) {
            textFromB.text = textFromFragmentB

            buttonBack.setOnClickListener {
                (requireActivity() as? BackButtonPressedListener)?.onBackButtonPressed()
            }

            buttonCtoD.setOnClickListener {
                (requireActivity() as? ClickNextListener)?.onButtonClicked(
                    target = FRAGMENT_D_TAG,
                    canMoveBack = true,
                    clearHistory = false,
                    passedBundle = null
                )
            }
        }


    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        @JvmStatic
        fun newInstance(passedBundle: Bundle): FragmentC {
            val fragment = FragmentC()
            fragment.arguments = passedBundle
            return fragment
        }
    }
}