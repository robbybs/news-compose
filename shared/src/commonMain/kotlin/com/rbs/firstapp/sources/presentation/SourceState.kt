package com.rbs.firstapp.sources.presentation

import com.rbs.firstapp.sources.domain.Source

data class SourceState(
    val sources: List<Source> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)