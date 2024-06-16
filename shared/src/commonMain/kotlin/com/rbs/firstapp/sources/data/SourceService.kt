package com.rbs.firstapp.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceService(private val httpClient: HttpClient) {
    private val apiKey = "a5f228aaa6e1489f9dd216ebf980b744"

    suspend fun getSources(): List<SourceItem> {
        val response: SourceResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}