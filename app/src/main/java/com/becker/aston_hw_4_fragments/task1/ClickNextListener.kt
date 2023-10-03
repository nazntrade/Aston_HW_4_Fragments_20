package com.becker.aston_hw_4_fragments.task1

import android.os.Bundle

interface ClickNextListener {
    fun onButtonClicked(
        target: String,
        canMoveBack: Boolean,
        clearHistory: Boolean,
        passedBundle: Bundle?
    )
}