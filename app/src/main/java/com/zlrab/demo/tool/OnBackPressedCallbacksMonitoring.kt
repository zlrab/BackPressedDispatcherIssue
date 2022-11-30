package com.zlrab.demo.tool

import android.util.Log
import androidx.activity.OnBackPressedCallback
import java.util.ArrayDeque


/**
 * @author: ZLRab
 * @project: BackPressedDispatcherDemo
 * @Desc:
 * @createDate: 2022-11-30 16:14
 */
class OnBackPressedCallbacksMonitoring(
    private val original: ArrayDeque<OnBackPressedCallback>,
    private val printStack: Boolean,
) :
    ArrayDeque<OnBackPressedCallback>() {
    override fun add(element: OnBackPressedCallback): Boolean {
        if (printStack) {
            Log.e("ZTag-Call", "call add:$element", Throwable())
        } else {
            Log.e("ZTag-Call", "call add:$element")
        }
        return original.add(element)
    }

    override fun remove(element: OnBackPressedCallback?): Boolean {
        if (printStack) {
            Log.e("ZTag-Call", "call remove:$element", Throwable())
        } else {
            Log.e("ZTag-Call", "call remove:$element")
        }
        return original.remove(element)
    }

    override fun descendingIterator(): MutableIterator<OnBackPressedCallback> {
        return original.descendingIterator()
    }
}

