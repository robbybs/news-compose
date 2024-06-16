package com.rbs.firstapp.articles.data

class ArticleRepository(
    private val dataSource: ArticleDataSource,
    private val apiService: ArticleService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleItem> {
        if (forceFetch) {
            dataSource.deleteArticle()
            return fetchArticles()
        }

        val articleDb = dataSource.getAllArticles()

        if (articleDb.isEmpty()) {
            val getArticles = apiService.getArticles()
            dataSource.insertArticle(getArticles)
            return getArticles
        }

        return articleDb
    }

    private suspend fun fetchArticles(): List<ArticleItem> {
        val getArticles = apiService.getArticles()
        dataSource.insertArticle(getArticles)
        return getArticles
    }
}