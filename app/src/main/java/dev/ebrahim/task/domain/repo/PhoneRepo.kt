package dev.ebrahim.task.domain.repo

import dev.ebrahim.task.domain.model.PhoneDM

interface IPhoneRepository {
    suspend fun getPhone(): PhoneDM
}
