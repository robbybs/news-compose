package com.rbs.firstapp.articles.presentation

import com.rbs.firstapp.articles.domain.Article

data class ArticleState(
    val articles: List<Article> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)