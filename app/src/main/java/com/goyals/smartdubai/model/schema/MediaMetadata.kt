package com.goyals.smartdubai.model.schema

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMetadata(@SerializedName("format") val format: String = "",
  @SerializedName("height") val height: Int = 0,
  @SerializedName("url") val url: String = "",
  @SerializedName("width") val width: Int = 0) : Parcelable