package com.becker.aston_hw_4_fragments.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.becker.aston_hw_4_fragments.R
import com.becker.aston_hw_4_fragments.task2.EditUserFragment.Companion.FRAGMENT_EDIT_USER_TAG
import com.becker.aston_hw_4_fragments.task2.UsersFragment.Companion.FRAGMENT_USERS_TAG

class SecondActivity : AppCompatActivity(), ClickItemListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        with(supportFragmentManager) {
            commit {
                add(
                    R.id.second_container,
                    UsersFragment.newInstance(null, index = null),
                    FRAGMENT_USERS_TAG
                )
            }
        }
    }

    override fun onItemClicked(
        targetFragmentTag: String,
        passedBundle: Bundle,
        index: Int
    ) {
        val instanceEditUserFragment = EditUserFragment.newInstance(passedBundle, index)
        val instanceUsersFragment = UsersFragment.newInstance(passedBundle, index)

        with(supportFragmentManager) {
            commit {
                when (targetFragmentTag) {
                    FRAGMENT_USERS_TAG -> {
                        replace(
                            R.id.second_container,
                            instanceUsersFragment,
                            targetFragmentTag
                        )
                        popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    }

                    FRAGMENT_EDIT_USER_TAG -> {
                        replace(
                            R.id.second_container,
                            instanceEditUserFragment,
                            targetFragmentTag
                        )
                        addToBackStack(targetFragmentTag)
                    }
                }
            }
        }
    }
}