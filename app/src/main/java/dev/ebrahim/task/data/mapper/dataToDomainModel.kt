package dev.ebrahim.task.data.mapper

import dev.ebrahim.task.domain.model.PhoneDM

fun PhoneDM.toPhoneDomainModel(): PhoneDM = PhoneDM(
    name = this.name ,
    letter = this.letter
)