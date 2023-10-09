package com.becker.aston_hw_4_fragments.task1

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.becker.aston_hw_4_fragments.R
import com.becker.aston_hw_4_fragments.databinding.FragmentABinding
import com.becker.aston_hw_4_fragments.task1.FragmentB.Companion.FRAGMENT_B_TAG

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.exit))
                    .setMessage(getString(R.string.are_you_really_want))
                    .setPositiveButton(getString(R.string.yes)) { _, _ -> requireActivity().finish() }
                    .setNegativeButton(getString(R.string.no), null)
                    .show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAtoB.setOnClickListener {
            (requireActivity() as? ClickNextListener)?.onButtonClicked(
                target = FRAGMENT_B_TAG,
                canMoveBack = true,
                clearHistory = false,
                passedBundle = null
            )
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}