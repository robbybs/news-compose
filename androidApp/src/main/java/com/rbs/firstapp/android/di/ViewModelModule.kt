package com.rbs.firstapp.android.di

import com.rbs.firstapp.articles.presentation.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}