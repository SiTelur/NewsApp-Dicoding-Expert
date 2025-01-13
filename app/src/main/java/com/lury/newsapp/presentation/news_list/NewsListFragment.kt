package com.lury.newsapp.newslist.presentation.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.databinding.FragmentNewsListBinding
import com.lury.newsapp.newslist.presentation.news_list.component.NewsAdapter
import com.lury.newsapp.presentation.model.NewsUi
import com.lury.newsapp.presentation.news_list.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private var _newsListBinding: FragmentNewsListBinding? = null
    private val newsListBinding get() = _newsListBinding!!

    private val newsListViewModel: NewsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _newsListBinding = FragmentNewsListBinding.inflate(layoutInflater, container, false)
        return newsListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsAdapter(object : NewsAdapter.OnItemClickListener {
            override fun onItemClicked(newsUi: NewsUi) {
                val action = NewsListFragmentDirections.actionNewsToDetail(newsUi)
                findNavController().navigate(action)
            }
        })

        newsListBinding.rvNews.adapter = adapter

        newsListViewModel.getNewsHeadline.observe(viewLifecycleOwner) { news ->
            when (news) {
                is Resource.Error -> showToast(news.message.toString())
                is Resource.Loading -> showLoading(true)
                is Resource.Success -> {
                    showLoading(false)
                    adapter.submitList(news.data)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _newsListBinding = null
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(isLoading: Boolean) {
        newsListBinding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }


}