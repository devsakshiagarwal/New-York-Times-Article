package com.goyals.smartdubai.model.schema

import com.google.gson.annotations.SerializedName

data class NyTimesSchema(@SerializedName(
  "copyright") val copyright: String = "",
  @SerializedName("num_results") val numResults: Int = 0,
  @SerializedName("results") val results: List<Result> = listOf(),
  @SerializedName("status") val status: String = "")