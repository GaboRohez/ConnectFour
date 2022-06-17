package com.gaborohez.connectfour

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.gaborohez.connectfour.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTitleAndVersion()
        setUpEvents()
    }

    private fun setUpTitleAndVersion() {
        val text = "<font color=#C62828>Conn</font><font color=#FF8F00>ect 4</font>"
        binding.tvTitle.text = Html.fromHtml(text)
        binding.tvVersion.text = String.format(requireActivity().getString(R.string.version), BuildConfig.VERSION_NAME)
    }

    private fun setUpEvents() {
        val navController = Navigation.findNavController(view!!)

        binding.btnPlay.setOnClickListener {
            navController.navigate(R.id.action_menu_to_game)
        }

        binding.btnInfo.setOnClickListener{
            navController.navigate(R.id.action_menu_to_info)
        }
    }
}