package com.rbs.firstapp.sources.di

import com.rbs.firstapp.sources.data.SourceRepository
import com.rbs.firstapp.sources.data.SourceService
import com.rbs.firstapp.sources.domain.SourceUseCase
import com.rbs.firstapp.sources.presentation.SourceViewModel
import org.koin.dsl.module

val sourceModule = module {
    single<SourceService> { SourceService(get()) }
    single<SourceUseCase> { SourceUseCase(get()) }
    single<SourceViewModel> { SourceViewModel(get()) }
    single<SourceRepository> { SourceRepository(get()) }
}