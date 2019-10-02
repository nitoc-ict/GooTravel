package com.ict.mito.gootravel.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter



/**
 * Created by mitohato14 on 2019-10-02.
 */
@BindingAdapter("bind:imageBitmap")
fun ImageView.loadImage(bitmap: Bitmap) {
    this.setImageBitmap(bitmap)
}
