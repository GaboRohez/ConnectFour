package com.gaborohez.connectfour

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaborohez.connectfour.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var gameArray = arrayOf(
        arrayOf("", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", ""))

    private var xPosition = 0
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "<font color=#C62828>Conn</font><font color=#FF8F00>ect 4</font>"
        binding.tvTitle.text = Html.fromHtml(text)
        setUpEvents()
    }

    private fun setUpEvents() {
        binding.addInOne.setOnClickListener {
            xPosition = 0
            fillBound()
            printArray()
        }

        binding.addInTwo.setOnClickListener {
            xPosition = 1
            fillBound()
        }

        binding.addInThree.setOnClickListener {
            xPosition = 2
            fillBound()
        }

        binding.addInFour.setOnClickListener {
            xPosition = 3
            fillBound()
        }

        binding.addInFive.setOnClickListener {
            xPosition = 4
            fillBound()
        }

        binding.addInSix.setOnClickListener {
            xPosition = 5
            fillBound()
        }

        binding.addInSeven.setOnClickListener {
            xPosition = 6
            fillBound()
        }
    }

    private fun fillBound() {

        for (yPosition in 0..6) {
            if (yPosition < 6){
                if (gameArray[yPosition][xPosition].isEmpty()){
                    gameArray[yPosition][xPosition] = "1"
                    break
                }
            }
        }

    }

    private fun printArray() {
        for (i in 5 downTo 0) {
            println(gameArray[i].contentToString())
        }
    }

    companion object {
        private const val TAG = "GameFragment"
    }
}