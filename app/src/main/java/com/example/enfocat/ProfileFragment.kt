package com.example.enfocat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
/**
 * A simple [Fragment] subclass.
 */

enum class ProviderType{
    BASIC
}
class ProfileFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vv = inflater.inflate(R.layout.fragment_profile, fragmentContainer, false)
        val btnSettings = vv.findViewById<View>(R.id.btn_settings) as Button






        btnSettings.setOnClickListener{
            val intent = Intent(this@ProfileFragment.context,settings::class.java)
            startActivity(intent)

            val bundle = intent.extras
            val email= bundle?.getString("email")
            setup(email ?: "")
        }
        return vv}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    private fun setup(email: String) {
        emailText.text = email

        LogOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

        }



}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_signUp.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_authentication)
        }
    }
}

