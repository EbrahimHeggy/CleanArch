package dev.ebrahim.task.presentation.models

import androidx.annotation.StringRes

data class UiModel(
    val name: String,
    @StringRes
    val letter: Int
)