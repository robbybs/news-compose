package com.rbs.firstapp.articles.presentation

import com.rbs.firstapp.BaseViewModel
import com.rbs.firstapp.articles.domain.ArticleUseCase
import com.rbs.firstapp.articles.presentation.ArticleState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private val useCase: ArticleUseCase) : BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(isLoading = true))
    val articleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articleState.emit(ArticleState(isLoading = true, articles = _articleState.value.articles))
            val fetchData = useCase.getArticles(forceFetch)
            _articleState.emit(ArticleState(articles = fetchData))
        }
    }
}