package com.rbs.firstapp.sources.presentation

import com.rbs.firstapp.BaseViewModel
import com.rbs.firstapp.sources.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourceViewModel(private val useCase: SourceUseCase) : BaseViewModel() {
    private val _sourceState: MutableStateFlow<SourceState> =
        MutableStateFlow(SourceState(isLoading = true))
    val sourceState: StateFlow<SourceState> get() = _sourceState

    init {
        getSource()
    }

    fun getSource() {
        scope.launch {
            _sourceState.emit(SourceState(isLoading = true, sources = _sourceState.value.sources))
            val fetchData = useCase.getSources()
            _sourceState.emit(SourceState(isLoading = false, sources = fetchData))
        }
    }
}