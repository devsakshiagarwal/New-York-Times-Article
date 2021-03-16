package com.goyals.smartdubai.model.api

import com.goyals.smartdubai.model.Urls
import com.goyals.smartdubai.model.schema.NyTimesSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NyTimesMostPopularApi {
  @GET(Urls.URL_MOST_POPULAR_NY_TIMES)
  suspend fun getNyTimesMostPopularList(@Path("section") section: String,
    @Path("period") period: String,
    @Query("api-key") apiKey: String): Response<NyTimesSchema>
}