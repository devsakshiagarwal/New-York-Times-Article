package com.goyals.smartdubai.view.listing

import androidx.lifecycle.ViewModel
import com.goyals.smartdubai.Configuration
import com.goyals.smartdubai.arch.netwrok.performNwOperation
import com.goyals.smartdubai.model.repository.NyTimesMostPopularRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(private val nyTimesMostPopularRepo: NyTimesMostPopularRepo) :
  ViewModel() {

  fun getNyTimesMostPopularList() = performNwOperation {
    nyTimesMostPopularRepo.getNyTimesMostPopularList("all-sections", "7",
      Configuration.NY_TIMES_API_KEY)
  }

  //method for testing
  fun getSum(a: Int,
    b: Int) = a + b
}