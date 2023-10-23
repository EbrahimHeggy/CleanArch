package dev.ebrahim.task.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun TextScreen(viewModel: TextChangeViewModel) {
    val textLiveData by viewModel.textLiveData.observeAsState()
    val textStateFlow by viewModel.textStateFlow.collectAsState()
    val textSharedFlow by viewModel.textSharedFlow.collectAsState("Hello!")
    val textFlow by viewModel.textFlow.collectAsState("Hello!")

    val context = LocalContext.current
    var toastMessage by remember { mutableStateOf<String?>(null) }
    fun showToast(message: String) {
        toastMessage = message
    }
    LaunchedEffect(toastMessage) {
        toastMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            toastMessage = null
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        textLiveData?.let { Text(text = it) }
        Button(onClick = {
            viewModel.onLiveDataButtonClicked()
            showToast("Update LiveData")
        }) {
            Text(text = "LiveData")
        }

        Text(text = textStateFlow)
        Button(onClick = {
            viewModel.onStateFlowButtonClicked()
            showToast("Update StateFlow")
        }) {
            Text(text = "StateFlow")
        }

        Text(text = textSharedFlow)
        Button(onClick = {
            viewModel.onSharedFlowButtonClicked()
            showToast("Update SharedFlow")
        }) {
            Text(text = "SharedFlow")
        }

        Text(text = textFlow)
        Button(onClick = {
            viewModel.onFlowButtonClicked()
            showToast("Update Flow")
        }) {
            Text(text = "Flow")
        }
    }
}

