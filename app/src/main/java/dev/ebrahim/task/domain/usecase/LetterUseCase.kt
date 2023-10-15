package dev.ebrahim.task.domain.usecase

import dev.ebrahim.task.data.repo.PhoneRepository
import dev.ebrahim.task.domain.model.PhoneDM

class GetPhoneUseCase(private val phoneRepository: PhoneRepository) {
     suspend fun execute(): PhoneDM {
        return phoneRepository.getPhone()
    }
}
