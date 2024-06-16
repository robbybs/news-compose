package com.rbs.firstapp.articles.domain

import com.rbs.firstapp.articles.data.ArticleItem
import com.rbs.firstapp.articles.data.ArticleRepository

class ArticleUseCase(private val repository: ArticleRepository) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> =
        mapArticle(repository.getArticles(forceFetch))

    private fun mapArticle(listArticle: List<ArticleItem>): List<Article> = listArticle.map {
        Article(
            it.title,
            it.description.orEmpty(),
            it.date,
            it.imageUrl.orEmpty()
        )
    }
}