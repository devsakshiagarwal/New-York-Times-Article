package com.goyals.smartdubai.view.listing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goyals.smartdubai.R

class ArticleListFragment : Fragment() {
  companion object {
    fun newInstance() = ArticleListFragment()
  }

  private lateinit var viewModel: ArticleListViewModel

  override fun onCreateView(inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_article_list, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
    // TODO: Use the ViewModel
  }
}