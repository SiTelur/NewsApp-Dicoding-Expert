package com.lury.newsapp.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.lury.newsapp.R
import com.lury.newsapp.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val args: DetailActivityArgs by navArgs()
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel : DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(args.News){
            Glide.with(this@DetailActivity).load(urlToImage)
                .into(binding.imageView)
            binding.titleTextView.text = title
            binding.authorTextView.text = author
            binding.publishedAtTextView.text = publishedAt.formatedDate // Format this as needed
            binding.descriptionTextView.text = description
            binding.contentTextView.text = content

            binding.goToLinkButton.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }

        detailViewModel.isNewsFavorite(args.News).observe(this) { isFavorite ->
            binding.loveButton.setOnClickListener{
                if (isFavorite) {
                    detailViewModel.deleteFavoriteNews(args.News)
                }else {
                    detailViewModel.saveFavoriteNews(args.News)
                }
            }
        }


        detailViewModel.isNewsFavorite(args.News).observe(this) { isFavorited ->
            if (isFavorited) {
                binding.loveButton.setImageResource(R.drawable.ic_favorite_24) // Ganti dengan ikon yang terisi
            } else {
                binding.loveButton.setImageResource(R.drawable.ic_favorite_border_24) // Ganti dengan ikon yang tidak terisi
            }
        }

    }
}