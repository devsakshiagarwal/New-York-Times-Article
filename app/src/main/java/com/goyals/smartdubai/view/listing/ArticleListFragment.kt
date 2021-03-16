package com.goyals.smartdubai.view.listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.goyals.smartdubai.R
import com.goyals.smartdubai.arch.netwrok.Result.Status.ERROR
import com.goyals.smartdubai.arch.netwrok.Result.Status.LOADING
import com.goyals.smartdubai.arch.netwrok.Result.Status.SUCCESS
import com.goyals.smartdubai.databinding.FragmentArticleListBinding
import com.goyals.smartdubai.model.schema.Result
import com.goyals.smartdubai.view.listing.ArticleListAdapter.ArticleClickListener
import com.goyals.smartdubai.view.utils.ErrorDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(), ArticleClickListener {
  lateinit var binding: FragmentArticleListBinding
  private val viewModel: ArticleListViewModel by viewModels()

  override fun onCreateView(inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list,
      container, false)
    return binding.root
  }

  override fun onViewCreated(view: View,
    savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    getData()
  }

  override fun onArticleClick(article: Result) {
    findNavController().navigate(R.id.nav_article_detail,
      getBundleForArticleData(article))
  }

  private fun getData() {
    viewModel.getNyTimesMostPopularList()
      .observe(viewLifecycleOwner, {
        it?.let {
          when (it.status) {
            SUCCESS -> {
              binding.layoutProgress.visibility = View.GONE
              setAdapter(it.data?.results!!)
            }
            ERROR -> {
              binding.layoutProgress.visibility = View.GONE
              ErrorDialog.newInstance(it.message!!)
                .show(requireActivity().supportFragmentManager, "error")
            }
            LOADING -> binding.layoutProgress.visibility = View.VISIBLE
          }
        }
      })
  }

  private fun setAdapter(items: List<Result>) {
    binding.viewModel = viewModel
    binding.layoutToolbar.title = getString(R.string.app_name)
    val articleListAdapter = ArticleListAdapter(requireContext(), this)
    articleListAdapter.setData(items)
    binding.rvArticle.apply {
      adapter = articleListAdapter
    }
  }

  private fun getBundleForArticleData(result: Result): Bundle {
    val bundle = Bundle()
    bundle.putParcelable("result", result)
    return bundle
  }
}