package dev.ebrahim.task.presentation.mapper

import dev.ebrahim.task.R
import dev.ebrahim.task.data.local.PhoneOption
import dev.ebrahim.task.domain.model.PhoneDM
import dev.ebrahim.task.presentation.models.UiModel

fun PhoneDM.toPhoneUiModel(): UiModel =
    UiModel(
        name = this.name,
        letter =
        when (this.letter) {
            PhoneOption.IPHONE.value -> R.string.iphone
            PhoneOption.SAMSUNG.value -> R.string.samsung
            else -> R.string.unknown
        }
    )