package com.goyals.smartdubai.model

object Urls {
  private const val URL_MOST_POPULAR = "mostpopular"
  private const val URL_VERSION_2 = "v2"
  private const val URL_MOST_VIEWED = "mostviewed"
  const val URL_MOST_POPULAR_NY_TIMES =
    "$URL_MOST_POPULAR/$URL_VERSION_2/$URL_MOST_VIEWED/{section}/{period}.json"
}