package com.rbs.firstapp.articles.data

import com.rbs.firstapp.db.AppDatabase

class ArticleDataSource(private val database: AppDatabase) {
    fun getAllArticles(): List<ArticleItem> =
        database.appDatabaseQueries.selectArticle(::mapToArticleItem).executeAsList()

    fun insertArticle(article: List<ArticleItem>) {
        database.appDatabaseQueries.transaction {
            article.forEach {
                insertArticle(it)
            }
        }
    }

    fun deleteArticle() = database.appDatabaseQueries.removeAllArticle()

    private fun mapToArticleItem(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleItem = ArticleItem(title, desc, date, imageUrl)

    private fun insertArticle(articleItem: ArticleItem) {
        database.appDatabaseQueries.insertArticle(
            articleItem.title,
            articleItem.description,
            articleItem.date,
            articleItem.imageUrl
        )
    }
}