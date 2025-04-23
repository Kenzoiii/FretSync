package com.example.fretsync.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fretsync.LoginActivity
import com.example.fretsync.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Find About Section
        val aboutSection = view.findViewById<View>(R.id.aboutSection)
        aboutSection.setOnClickListener {
            showAboutDialog()
        }

        val developerSection = view.findViewById<View>(R.id.developerSection)
        developerSection.setOnClickListener {
             showDeveloperDialog()
        }

        val logoutButton = view.findViewById<Button>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }

    private fun showAboutDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_about_app)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent) // Make background transparent

        val closeButton = dialog.findViewById<ImageView>(R.id.btnClose)
        closeButton.setOnClickListener {
            dialog.dismiss()  // Close the popup
        }

        dialog.show()
    }

    private fun showDeveloperDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_about_developer)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val closeButton = dialog.findViewById<ImageView>(R.id.btnCloseDeveloper)
        closeButton.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

}
