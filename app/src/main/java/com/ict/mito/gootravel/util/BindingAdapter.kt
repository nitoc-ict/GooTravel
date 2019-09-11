package com.ict.mito.gootravel.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by mitohato14 on 2019-09-11.
 */
object BindingAdapter {
    @BindingAdapter("android:src")
    @JvmStatic
    fun ImageView.imageResource(resource: Int) {
        this.setImageResource(resource)
    }
}