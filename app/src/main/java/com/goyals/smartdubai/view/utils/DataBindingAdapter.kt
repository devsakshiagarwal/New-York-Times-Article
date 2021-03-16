package com.goyals.smartdubai.view.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.goyals.smartdubai.R

class DataBindingAdapter {
  companion object {
    @JvmStatic @BindingAdapter("imageUrl") fun loadCircleImage(view: ImageView,
      loadImageURL: String?) {
      Glide.with(view.context)
        .load(loadImageURL)
        .placeholder(R.color.teal_700)
        .error(R.color.teal_700)
        .centerCrop()
        .transform(CircleCrop())
        .into(view)
    }
  }
}