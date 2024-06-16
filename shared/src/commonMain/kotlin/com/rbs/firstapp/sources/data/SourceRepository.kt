package com.rbs.firstapp.sources.data

class SourceRepository(private val apiService: SourceService) {
    suspend fun getSources(): List<SourceItem> = apiService.getSources()
}