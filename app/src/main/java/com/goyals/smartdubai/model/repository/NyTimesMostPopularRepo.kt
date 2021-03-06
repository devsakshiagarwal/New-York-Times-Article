package com.goyals.smartdubai.model.repository

import com.goyals.smartdubai.arch.netwrok.BaseDataSource
import com.goyals.smartdubai.model.api.NyTimesMostPopularApi
import javax.inject.Inject

class NyTimesMostPopularRepo @Inject constructor(private val nyTimesMostPopularApi: NyTimesMostPopularApi) :
  BaseDataSource() {
  suspend fun getNyTimesMostPopularList(section: String,
    period: String,
    apiKey: String) = getResult {
    nyTimesMostPopularApi.getNyTimesMostPopularList(section, period, apiKey)
  }
}