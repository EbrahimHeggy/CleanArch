package dev.ebrahim.task.presentation.mapper

import dev.ebrahim.task.R
import dev.ebrahim.task.domain.model.PhoneDM
import dev.ebrahim.task.presentation.models.UiModel
import dev.ebrahim.task.util.PhoneOption


fun PhoneDM.toPhoneUiModel(): UiModel =
    UiModel(
        name = this.name,
        letter =
        when (this.letter) {
            PhoneOption.IPHONE.name -> R.string.iphone
            PhoneOption.SAMSUNG.name -> R.string.samsung
            else -> R.string.unknown
        }
    )