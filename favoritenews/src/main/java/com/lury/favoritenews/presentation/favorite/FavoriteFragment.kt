package com.lury.favoritenews.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lury.favoritenews.databinding.FragmentFavoriteBinding
import com.lury.favoritenews.di.DaggerFavoriteComponent
import com.lury.favoritenews.presentation.model.favoriteUiToNewsUi
import com.lury.newsapp.di.FavoriteModuleDependency
import com.lury.newsapp.presentation.listnews.component.NewsAdapter
import com.lury.newsapp.presentation.model.NewsUi
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment(){

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels{
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        DaggerFavoriteComponent.builder().context(requireContext()).appDependencies(
            EntryPointAccessors.fromApplication(
                requireContext(),
                FavoriteModuleDependency::class.java
            )
        ).build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NewsAdapter(object : NewsAdapter.OnItemClickListener {
            override fun onItemClicked(newsUi: NewsUi) {
                val action = FavoriteFragmentDirections.actionFavoriteToDetail(newsUi)
                findNavController().navigate(action)
            }
        })

        binding.favoriteRecyclerView.adapter = adapter

        viewModel.getFavoriteName.observe(viewLifecycleOwner) { favoriteNews ->
            adapter.submitList(favoriteNews.map { it.favoriteUiToNewsUi() })
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}