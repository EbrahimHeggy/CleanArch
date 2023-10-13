package dev.ebrahim.task.domain.repo

import dev.ebrahim.task.domain.model.PhoneDM

interface PhoneRepository {
    suspend fun getPhone(): PhoneDM
}
