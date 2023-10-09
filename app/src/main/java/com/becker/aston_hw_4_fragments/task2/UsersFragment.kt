package com.becker.aston_hw_4_fragments.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.becker.aston_hw_4_fragments.databinding.FragmentUsersBinding
import com.becker.aston_hw_4_fragments.task2.EditUserFragment.Companion.FRAGMENT_EDIT_USER_TAG
import com.becker.aston_hw_4_fragments.task2.EditUserFragment.Companion.PASSED_DATA_TO_USERS_FRAGMENT_EXTRA

class UsersFragment : Fragment() {

    private var users = listOf<User>()
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        initFieldOfUsers()
    }

    private fun initList() {
        users = listOf(
            User(
                1,
                "https://3.img-dpreview.com/files/p/TS600x450~sample_galleries/3002635523/4971879462.jpg",
                "Andrew",
                "Becker",
                "+736799999009"
            ),
            User(
                2,
                "https://1.img-dpreview.com/files/p/TS600x450~sample_galleries/3002635523/3243077643.jpg",
                "Ron",
                "Shonen",
                "+79935469977799"
            ),
            User(
                3,
                "https://1.img-dpreview.com/files/p/TS600x450~sample_galleries/3002635523/0040716489.jpg",
                "Gate",
                "Bilts",
                "+15346555467"
            ),
            User(
                4,
                "https://2.img-dpreview.com/files/p/TS600x450~sample_galleries/3002635523/4284047485.jpg",
                "Zucker",
                "Marckerberck",
                "+4486785676"
            ),
        )

        val newUsers =
            (arguments?.getParcelableArrayList<User>(PASSED_DATA_TO_USERS_FRAGMENT_EXTRA))

        if (userCurrentIndex != null && newUsers != null) {
            users = newUsers
        }

        arguments = null
    }

    private fun createBundleOfUsers(): Bundle {
        val bundleOfUsers = Bundle()
        bundleOfUsers.putParcelableArrayList(PASSED_DATA_TO_EDIT_EXTRA, ArrayList(users))
        return bundleOfUsers
    }

    private fun initFieldOfUsers() {
        val bundleOfUsers = createBundleOfUsers()

        with(binding) {
            photoOne.load(users[0].photoLink)
            photoTwo.load(users[1].photoLink)
            photoThird.load(users[2].photoLink)
            photoForth.load(users[3].photoLink)
            nameOne.text = users[0].name
            nameTwo.text = users[1].name
            nameThird.text = users[2].name
            nameForth.text = users[3].name
            secondNameOne.text = users[0].secondName
            secondNameTwo.text = users[1].secondName
            secondNameThird.text = users[2].secondName
            secondNameForth.text = users[3].secondName
            phoneNumberOne.text = users[0].phoneNumber
            phoneNumberTwo.text = users[1].phoneNumber
            phoneNumberThird.text = users[2].phoneNumber
            phoneNumberForth.text = users[3].phoneNumber

            userContainerOne.setOnClickListener {
                (requireActivity() as? ClickItemListener)?.onItemClicked(
                    targetFragmentTag = FRAGMENT_EDIT_USER_TAG,
                    passedBundle = bundleOfUsers,
                    index = 0
                )
            }
            userContainerTwo.setOnClickListener {
                (requireActivity() as? ClickItemListener)?.onItemClicked(
                    targetFragmentTag = FRAGMENT_EDIT_USER_TAG,
                    passedBundle = bundleOfUsers,
                    index = 1
                )
            }
            userContainerThird.setOnClickListener {
                (requireActivity() as? ClickItemListener)?.onItemClicked(
                    targetFragmentTag = FRAGMENT_EDIT_USER_TAG,
                    passedBundle = bundleOfUsers,
                    index = 2
                )
            }
            userContainerForth.setOnClickListener {
                (requireActivity() as? ClickItemListener)?.onItemClicked(
                    targetFragmentTag = FRAGMENT_EDIT_USER_TAG,
                    passedBundle = bundleOfUsers,
                    index = 3
                )
            }
        }
    }

    companion object {
        const val FRAGMENT_USERS_TAG = "FRAGMENT_USERS_TAG"
        const val PASSED_DATA_TO_EDIT_EXTRA = "PASSED_DATA_TO_EDIT_EXTRA"
        var userCurrentIndex: Int? = null

        @JvmStatic
        fun newInstance(passedBundle: Bundle?, index: Int?): UsersFragment {
            val fragment = UsersFragment()
            if (passedBundle != null) {
                fragment.arguments = passedBundle
            }
            if (index != null) {
                userCurrentIndex = index
            }
            return fragment
        }
    }
}