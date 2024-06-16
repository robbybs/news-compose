package com.rbs.firstapp.di

import com.rbs.firstapp.articles.di.articleModule
import com.rbs.firstapp.sources.di.sourceModule

val sharedKoinModule = listOf(
    articleModule,
    sourceModule,
    networkModule
)