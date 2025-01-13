package com.lury.favoritenews.di

import android.content.Context
import com.lury.favoritenews.presentation.favorite.FavoriteFragment
import com.lury.newsapp.di.FavoriteModuleDependency
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependency::class])
interface FavoriteComponent {
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteComponent: FavoriteModuleDependency): Builder
        fun build(): FavoriteComponent
    }
}