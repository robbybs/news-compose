package com.rbs.firstapp.articles.data

import com.rbs.firstapp.articles.data.ArticleItem
import com.rbs.firstapp.articles.data.ArticleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "a5f228aaa6e1489f9dd216ebf980b744"

    suspend fun getArticles(): List<ArticleItem> {
        val response: ArticleResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }
}