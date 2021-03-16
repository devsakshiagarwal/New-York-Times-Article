package com.goyals.smartdubai.view.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goyals.smartdubai.R

class ArticleDetailFragment : Fragment() {

  private lateinit var viewModel: ArticleDetailViewModel

  override fun onCreateView(inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_article_detail, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(ArticleDetailViewModel::class.java)
    // TODO: Use the ViewModel
  }
}