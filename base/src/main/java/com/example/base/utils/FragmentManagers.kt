package com.example.base.utils

import androidx.fragment.app.FragmentManager
import com.example.base.OnBackPressedListener

fun FragmentManager.findOnBackPressedListener(): OnBackPressedListener? {
    fragments.reversed().forEach { fragment ->
        fragment.childFragmentManager.findOnBackPressedListener()?.let { return it }
        (fragment as? OnBackPressedListener)?.let { return it }
    }
    return null
}