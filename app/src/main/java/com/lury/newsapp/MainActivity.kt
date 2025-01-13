package com.lury.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.lury.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.apply {
            setupWithNavController(navController)
        }




//        val adapter = NewsAdapter(object : NewsAdapter.OnItemClickListener {
//            override fun onItemClicked(newsUi: NewsUi) {
//                Toast.makeText(this@MainActivity, newsUi.toString(), Toast.LENGTH_SHORT).show()
//            }
//        })
//        binding.rvNews.adapter = adapter
//
//        newsListViewModel.getNewsHeadline.observe(this) { news ->
//            when (news) {
//                is Resource.Error -> showToast(news.message.toString())
//                is Resource.Loading -> showLoading(true)
//                is Resource.Success -> {
//                    showLoading(false)
//                    adapter.submitList(news.data)
//                }
//            }
//        }
    }

//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    private fun showLoading(isLoading: Boolean) {
//        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
//    }

}