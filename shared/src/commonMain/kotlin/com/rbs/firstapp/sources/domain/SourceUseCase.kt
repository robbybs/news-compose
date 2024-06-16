package com.rbs.firstapp.sources.domain

import com.rbs.firstapp.sources.data.SourceItem
import com.rbs.firstapp.sources.data.SourceRepository

class SourceUseCase(private val repository: SourceRepository) {
    suspend fun getSources(): List<Source> = mapSource(repository.getSources())

    private fun mapSource(listSource: List<SourceItem>): List<Source> =
        listSource.map {
            Source(
                it.id,
                it.name,
                it.description,
                it.language,
                it.country
            )
        }
}