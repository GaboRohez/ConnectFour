package com.gaborohez.connectfour

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gaborohez.connectfour.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvVersion.text = String.format(requireActivity().getString(R.string.version), BuildConfig.VERSION_NAME)
        setUpEvents()
    }

    private fun setUpEvents() {
        binding.contentGithub.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(requireActivity().getString(R.string.github_url))
            startActivity(i)
        }

        binding.contentEmail.setOnClickListener {

            try {
                val i = Intent(Intent.ACTION_SEND)
                i.type = "message/rfc822"
                i.putExtra(Intent.EXTRA_EMAIL, arrayOf(requireActivity().getString(R.string.email)))
                startActivity(Intent.createChooser(i, getString(R.string.message_from_intent_email)))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), getString(R.string.no_email_client), Toast.LENGTH_SHORT).show()
            }
        }
    }

}