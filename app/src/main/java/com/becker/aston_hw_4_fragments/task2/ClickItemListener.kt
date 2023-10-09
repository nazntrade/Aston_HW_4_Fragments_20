package com.becker.aston_hw_4_fragments.task2

import android.os.Bundle

interface ClickItemListener {
    fun onItemClicked(targetFragmentTag: String, passedBundle: Bundle, index: Int)
}