package com.becker.aston_hw_4_fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_4_fragments.databinding.FragmentDBinding
import com.becker.aston_hw_4_fragments.task1.FragmentA.Companion.FRAGMENT_A_TAG

class FragmentD : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDtoA.setOnClickListener {
            (requireActivity() as? ClickNextListener)?.onButtonClicked(
                target = FRAGMENT_A_TAG,
                canMoveBack = true,
                clearHistory = true,
                passedBundle = null
            )
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        @JvmStatic
        fun newInstance() = FragmentD()
    }
}