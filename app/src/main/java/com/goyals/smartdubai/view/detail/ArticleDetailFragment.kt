package com.goyals.smartdubai.view.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.goyals.smartdubai.R
import com.goyals.smartdubai.databinding.FragmentArticleDetailBinding
import com.goyals.smartdubai.model.schema.Result
import com.goyals.smartdubai.view.utils.ToolBarClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailFragment : Fragment(),
  ToolBarClick,
  ArticleDetailClickListener {
  lateinit var binding: FragmentArticleDetailBinding
  private var article: Result = Result()

  override fun onCreateView(inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?): View {
    binding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_article_detail,
        container, false)
    return binding.root
  }

  override fun onViewCreated(view: View,
    savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    arguments?.let {
      article = it.getParcelable("result")!!
    }
    initViews()
  }

  override fun onClickBack() {
    findNavController().navigateUp()
  }

  override fun onUrlClick(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
  }

  private fun initViews() {
    binding.layoutToolbar.title = article.source
    binding.layoutToolbar.ivNavigation.visibility = View.VISIBLE
    binding.layoutToolbar.click = this
    binding.click = this
    binding.item = article
  }
}

interface ArticleDetailClickListener {
  fun onUrlClick(url: String)
}
