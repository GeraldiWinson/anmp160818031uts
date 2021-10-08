package com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.multimedia2018.ubaya.a160818031_geraldi_uts_notesandplannerapp.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null)
        {
            val username = ProfileFragmentArgs.fromBundle(requireArguments()).username
            txtProfileName.text = "Hi, $username"
        }
        btnProfileDetail.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileDetail()
            Navigation.findNavController(it).navigate(action)
        }

        btnSettings.setOnClickListener {
            val action = ProfileFragmentDirections.actionSettings()
            Navigation.findNavController(it).navigate(action)
        }
    }
}