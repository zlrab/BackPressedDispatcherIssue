package com.zlrab.demo.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.zlrab.demo.R

/**
 * @author: ZLRab
 * @project: BackPressedDispatcherDemo
 * @Desc:
 * @createDate: 2022-11-10 11:15
 */
class Business1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_business, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).text = "business 1"
        view.setBackgroundColor(Color.RED)
        view.findViewById<Button>(R.id.goto_next)
            .setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    add(R.id.container, Business2Fragment())
                    addToBackStack("business_2")
                    commit()
                }
            }
    }
}