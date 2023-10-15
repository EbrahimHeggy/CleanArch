package dev.ebrahim.task.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ebrahim.task.presentation.PhoneViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PhoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PhoneScreen(viewModel)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PhoneScreen(viewModel: PhoneViewModel) {
    // val uiModel by viewModel.uiModel.observeAsState(initial = UiModel("Phone", R.string.unknown))

    val uiModel = remember(viewModel.uiModel) { viewModel.uiModel.value }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                viewModel.fetchAndDisplayPhone()
            }
        ) {
            Text("Fetch Phone")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (uiModel != null) {
            TextField(
                value = uiModel.name,
                onValueChange = {},
                textStyle = TextStyle(fontSize = 20.sp),
            )
        }

        if (uiModel != null) {
            Text(
                text = stringResource(id = uiModel.letter),
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

