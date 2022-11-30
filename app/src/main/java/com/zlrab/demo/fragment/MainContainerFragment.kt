package com.zlrab.demo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zlrab.demo.R

/**
 * @author: ZLRab
 * @project: BackPressedDispatcherDemo
 * @Desc:
 * @createDate: 2022-11-30 11:47
 */
class MainContainerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_main_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction().apply {
            add(R.id.container, Business1Fragment())
            addToBackStack("business_1")
            commit()
        }
    }
}