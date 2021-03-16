package com.goyals.smartdubai.model.schema

import com.google.gson.annotations.SerializedName

data class Media(@SerializedName(
  "approved_for_syndication") val approvedForSyndication: Int = 0,
  @SerializedName("caption") val caption: String = "",
  @SerializedName("copyright") val copyright: String = "",
  @SerializedName(
    "media-metadata") val mediaMetadata: List<MediaMetadata> = listOf(),
  @SerializedName("subtype") val subtype: String = "",
  @SerializedName("type") val type: String = "")