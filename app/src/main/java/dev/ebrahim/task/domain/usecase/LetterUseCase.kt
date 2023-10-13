package dev.ebrahim.task.domain.usecase

import dev.ebrahim.task.domain.model.PhoneDM
import dev.ebrahim.task.domain.repo.PhoneRepository

class GetPhoneUseCase(private val phoneRepository: PhoneRepository) {
     suspend fun execute(): PhoneDM {
        return phoneRepository.getPhone()
    }
}
