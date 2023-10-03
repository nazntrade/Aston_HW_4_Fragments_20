package com.becker.aston_hw_4_fragments.task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.becker.aston_hw_4_fragments.R
import com.becker.aston_hw_4_fragments.task1.FragmentA.Companion.FRAGMENT_A_TAG
import com.becker.aston_hw_4_fragments.task1.FragmentB.Companion.FRAGMENT_B_TAG
import com.becker.aston_hw_4_fragments.task1.FragmentB.Companion.PASSED_TEXT_FROM_B_TO_C_EXTRA
import com.becker.aston_hw_4_fragments.task1.FragmentC.Companion.FRAGMENT_C_TAG
import com.becker.aston_hw_4_fragments.task1.FragmentD.Companion.FRAGMENT_D_TAG

class MainActivity : AppCompatActivity(), ClickNextListener, BackButtonPressedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager) {
            commit {
                replace(R.id.main_container, FragmentA.newInstance(), FRAGMENT_A_TAG)
            }
        }
    }

    override fun onBackButtonPressed() {
        supportFragmentManager.popBackStack()
    }

    override fun onButtonClicked(
        target: String,
        canMoveBack: Boolean,
        clearHistory: Boolean,
        passedBundle: Bundle?
    ) {
        when (target) {
            FRAGMENT_A_TAG -> {
                with(supportFragmentManager) {
                    commit {
                        replace(
                            R.id.main_container, FragmentA.newInstance(),
                            target
                        )
                        if (canMoveBack) {
                            addToBackStack(target)
                        }
                        if (clearHistory) {
                            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                        }
                    }
                }
            }

            FRAGMENT_B_TAG -> {
                with(supportFragmentManager) {
                    commit {
                        replace(
                            R.id.main_container, FragmentB.newInstance(),
                            target
                        )
                        if (canMoveBack) {
                            addToBackStack(target)
                        }
                        if (clearHistory) {
                            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                        }
                    }
                }
            }

            FRAGMENT_C_TAG -> {
                with(supportFragmentManager) {
                    commit {
                        val reserveBundle = Bundle()
                        reserveBundle.putString(
                            PASSED_TEXT_FROM_B_TO_C_EXTRA,
                            "nothing has been submitted"
                        )
                        replace(
                            R.id.main_container,
                            FragmentC.newInstance(passedBundle = (passedBundle ?: reserveBundle)),
                            target
                        )
                        if (canMoveBack) {
                            addToBackStack(target)
                        }
                        if (clearHistory) {
                            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                        }
                    }
                }
            }

            FRAGMENT_D_TAG -> {
                with(supportFragmentManager) {
                    commit {
                        replace(
                            R.id.main_container, FragmentD.newInstance(),
                            target
                        )
                        if (canMoveBack) {
                            addToBackStack(target)
                        }
                        if (clearHistory) {
                            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                        }
                    }
                }
            }
        }
    }
}