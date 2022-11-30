package com.zlrab.demo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import com.zlrab.demo.fragment.MainContainerFragment
import com.zlrab.demo.tool.OnBackPressedCallbacksMonitoring
import java.util.ArrayDeque

/**
 * @author: ZLRab
 * @project: BackPressedDispatcherDemo
 * @Desc:
 * @createDate: 2022-11-10 11:02
 */
class FragmentTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedCallbacksMonitoring()
        setContentView(R.layout.activity_fragment_test)
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Toast.makeText(this@FragmentTestActivity, "finish", Toast.LENGTH_SHORT).show()
                    finish()
                }
            })
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainContainerFragment())
            commit()
        }
    }

    /**
     * Static proxy monitoring m On Back Pressed Callbacks registration[ArrayDeque.add] and unRegistration[ArrayDeque.remove] changes
     */
    private fun onBackPressedCallbacksMonitoring() {
        val filed = OnBackPressedDispatcher::class.java.getDeclaredField("mOnBackPressedCallbacks")
        filed.isAccessible = true
        val original = filed.get(onBackPressedDispatcher) as ArrayDeque<OnBackPressedCallback>
        val proxy = OnBackPressedCallbacksMonitoring(original, false)
        filed.set(onBackPressedDispatcher, proxy)
    }
}

