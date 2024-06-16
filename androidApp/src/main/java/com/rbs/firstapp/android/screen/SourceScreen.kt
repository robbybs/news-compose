package com.rbs.firstapp.android.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.rbs.firstapp.sources.domain.Source
import com.rbs.firstapp.sources.presentation.SourceViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SourceScreen(viewModel: SourceViewModel = getViewModel()) {
    val state by viewModel.sourceState.collectAsState()

    Column {
        AppBar()
        if (state.error != null) ErrorMessage(state.error!!)
        if (state.sources.isNotEmpty()) SourceListView(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(title = { Text(text = "Sources") })
}

@Composable
fun SourceListView(viewModel: SourceViewModel) {
    SwipeRefresh(
        state = SwipeRefreshState(viewModel.sourceState.value.isLoading),
        onRefresh = { viewModel.getSource() }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.sourceState.value.sources) { source ->
                SourceItemView(source = source)
            }
        }
    }
}

@Composable
fun SourceItemView(source: Source) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description)

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.country,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}