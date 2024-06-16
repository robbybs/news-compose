package com.rbs.firstapp.articles.di

import com.rbs.firstapp.articles.data.ArticleDataSource
import com.rbs.firstapp.articles.data.ArticleRepository
import com.rbs.firstapp.articles.data.ArticleService
import com.rbs.firstapp.articles.domain.ArticleUseCase
import com.rbs.firstapp.articles.presentation.ArticleViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticleService> { ArticleService(get()) }
    single<ArticleUseCase> { ArticleUseCase(get()) }
    single<ArticleViewModel> { ArticleViewModel(get()) }
    single<ArticleDataSource> { ArticleDataSource(get()) }
    single<ArticleRepository> { ArticleRepository(get(), get()) }
}