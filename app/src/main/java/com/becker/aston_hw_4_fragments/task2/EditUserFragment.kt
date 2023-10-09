package com.becker.aston_hw_4_fragments.task2

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import coil.load
import com.becker.aston_hw_4_fragments.databinding.FragmentEditUserBinding
import com.becker.aston_hw_4_fragments.task2.UsersFragment.Companion.FRAGMENT_USERS_TAG
import com.becker.aston_hw_4_fragments.task2.UsersFragment.Companion.PASSED_DATA_TO_EDIT_EXTRA

class EditUserFragment : Fragment() {

    private var _binding: FragmentEditUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val users = arguments?.getParcelableArrayList<User>(PASSED_DATA_TO_EDIT_EXTRA)
        val newPhotos = listOf(
            "https://people.com/thmb/sojvooGiIWKUymbCHg4K6691JRE=/364x242/filters:no_upscale():max_bytes(150000):strip_icc():focal(753x329:755x331):format(webp)/Saweetie-070423-10-03665b4e69bb4cc0947e3dad53ffa80b.jpg",
            "https://people.com/thmb/lQCzDCzB49T2fdvBvNFg9A9uIJE=/282x188/filters:no_upscale():max_bytes(150000):strip_icc():focal(705x34:707x36):format(webp)/chrissy-teigen-and-john-legends-kids-fourth-of-july-070523-e746cef4af2c46cb895810f3e80d5936.jpg",
            "https://people.com/thmb/GF-7h9vAUwzK9Ux9cjU7gO03VEM=/282x188/filters:no_upscale():max_bytes(150000):strip_icc():focal(942x160:944x162):format(webp)/carson-daly-throwbacks-062123-3-db48e66cbf7e4af4bcf7f7bbb0317328.jpg",
            "https://people.com/thmb/TGHU396un61dNnyWoW0-uXhf9oU=/282x188/filters:no_upscale():max_bytes(150000):strip_icc():focal(749x0:751x2):format(webp)/harrison-ford-calista-flockhart-2-3e4b60c52e8f4fa8823db83ff1fce0c1.jpg",
            "https://people.com/thmb/nMrXbJgFKGTbJwPtCfrwlNiP-UY=/282x188/filters:no_upscale():max_bytes(150000):strip_icc():focal(749x0:751x2):format(webp)/family-ties-cast-then-now-041423-1-0c69704717cc4c06bd18fd08f179ac37.jpg",
            "https://people.com/thmb/ggxaAwpXbo4Q9D5cQpkzIpRi_BM=/282x188/filters:no_upscale():max_bytes(150000):strip_icc():focal(939x385:941x387):format(webp)/travis-barker-052023-01-2000-1795a736fb93405c85c422f3a75a7a52.jpg"
        )
        val photoImageView = binding.photoImageView
        val nameEditText = binding.nameEditText
        val secondNameEditText = binding.secondNameEditText
        val phoneEditText = binding.phoneEditText

        photoImageView.load(users?.get(userCurrentIndex)?.photoLink)
        nameEditText.setText(users?.get(userCurrentIndex)?.name)
        secondNameEditText.setText(users?.get(userCurrentIndex)?.secondName)
        phoneEditText.setText(users?.get(userCurrentIndex)?.phoneNumber)

        with(binding) {
            buttonEditPhoto.setOnClickListener {
                users?.get(userCurrentIndex)?.photoLink = newPhotos.random()
                photoImageView.load(users?.get(userCurrentIndex)?.photoLink)
            }
            saveBtn.setOnClickListener {
                users?.get(userCurrentIndex)?.name = nameEditText.text.toString()
                users?.get(userCurrentIndex)?.secondName = secondNameEditText.text.toString()
                users?.get(userCurrentIndex)?.phoneNumber = phoneEditText.text.toString()
                (requireActivity() as? ClickItemListener)?.onItemClicked(
                    targetFragmentTag = FRAGMENT_USERS_TAG,
                    passedBundle = createBundleOfUsers(users),
                    index = userCurrentIndex
                )
            }
        }
    }

    private fun createBundleOfUsers(users: ArrayList<User>?): Bundle {
        val bundleOfUsers = Bundle()
        bundleOfUsers.putParcelableArrayList(PASSED_DATA_TO_USERS_FRAGMENT_EXTRA, users)
        return bundleOfUsers
    }

    companion object {
        const val FRAGMENT_EDIT_USER_TAG = "FRAGMENT_EDIT_USER_TAG"
        const val PASSED_DATA_TO_USERS_FRAGMENT_EXTRA = "PASSED_DATA_TO_USERS_FRAGMENT_EXTRA"
        var userCurrentIndex = 0

        @JvmStatic
        fun newInstance(passedBundle: Bundle, index: Int?): EditUserFragment {
            val fragment = EditUserFragment()
            fragment.arguments = passedBundle
            if (index != null) {
                userCurrentIndex = index
            }
            return fragment
        }
    }
}