package dev.ebrahim.task.data.repo

import dev.ebrahim.task.data.local.LetterDataSource
import dev.ebrahim.task.data.mapper.toPhoneDomainModel
import dev.ebrahim.task.domain.model.PhoneDM
import dev.ebrahim.task.domain.repo.IPhoneRepository

class PhoneRepository(
    private val letterDataSource: LetterDataSource = LetterDataSource()
) : IPhoneRepository {
    override suspend fun getPhone(): PhoneDM {
        val letter = letterDataSource.getLetter()
        return PhoneDM("Phone", letter).toPhoneDomainModel()
    }
}

