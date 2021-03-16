package com.goyals.smartdubai.view.listing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.goyals.smartdubai.R
import com.goyals.smartdubai.databinding.ItemArticleBinding
import com.goyals.smartdubai.model.schema.Result
import com.goyals.smartdubai.view.listing.ArticleListAdapter.ViewHolder

class ArticleListAdapter(private val context: Context,
  private val articleClickListener: ArticleClickListener) : RecyclerView.Adapter<ViewHolder>() {
  private lateinit var items: List<Result>

  fun setData(items: List<Result>) {
    this.items = items
  }

  override fun onCreateViewHolder(parent: ViewGroup,
    viewType: Int): ViewHolder {
    val binding: ItemArticleBinding =
      DataBindingUtil.inflate(LayoutInflater.from(context),
        R.layout.item_article, parent, false)
    return ViewHolder(binding.root)
  }

  class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(
    itemView) {
    var binding: ItemArticleBinding? = DataBindingUtil.bind(itemView)
  }

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: ViewHolder,
    position: Int) {
    val item = items[position]
    holder.binding?.item = item
    holder.binding?.click = articleClickListener
  }

  interface ArticleClickListener {
    fun onArticleClick(article: Result)
  }
}