package com.becker.aston_hw_4_fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_4_fragments.databinding.FragmentBBinding
import com.becker.aston_hw_4_fragments.task1.FragmentC.Companion.FRAGMENT_C_TAG

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundleToFragmentC = Bundle()
        bundleToFragmentC.putString(PASSED_TEXT_FROM_B_TO_C_EXTRA, "Hello Fragment C")

        with(binding) {
            buttonBtoC.setOnClickListener {
                (requireActivity() as ClickNextListener).onButtonClicked(
                    target = FRAGMENT_C_TAG,
                    canMoveBack = true,
                    clearHistory = false,
                    passedBundle = bundleToFragmentC
                )
            }

            buttonBack.setOnClickListener {
                (requireActivity() as? BackButtonPressedListener)?.onBackButtonPressed()
            }
        }
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"
        const val PASSED_TEXT_FROM_B_TO_C_EXTRA = "PASSED_TEXT_FROM_B_TO_C_EXTRA"

        @JvmStatic
        fun newInstance() = FragmentB()
    }
}