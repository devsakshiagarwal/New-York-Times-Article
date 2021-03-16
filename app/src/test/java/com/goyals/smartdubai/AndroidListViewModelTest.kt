package com.goyals.smartdubai

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.goyals.smartdubai.model.api.NyTimesMostPopularApi
import com.goyals.smartdubai.model.repository.NyTimesMostPopularRepo
import com.goyals.smartdubai.view.listing.ArticleListViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AndroidListViewModelTest {
  @get:Rule val testInstantTaskExecutorRule: TestRule =
    InstantTaskExecutorRule()
  @Mock private lateinit var api: NyTimesMostPopularApi
  private lateinit var nyTimesMostPopularRepo: NyTimesMostPopularRepo

  @Before fun setUp() {
    nyTimesMostPopularRepo = NyTimesMostPopularRepo(api)
  }

  @Test fun getSumReturnsSuccess() {
    val viewModel = ArticleListViewModel(nyTimesMostPopularRepo)
    assertEquals(viewModel.getSum(3, 3), 6)
    assertEquals(viewModel.getSum(1000, 2000), 3000)
  }

  @Test fun getSumReturnsFail() {
    val viewModel = ArticleListViewModel(nyTimesMostPopularRepo)
    assertNotEquals(viewModel.getSum(1000, 1920380940), 6)
    assertNotEquals(viewModel.getSum(1055300, 1920380940), 64565)
  }

  @After fun tearDown() {
  }
}