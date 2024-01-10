package com.growthook.aos.domain.usecase.cavedetail

import com.growthook.aos.domain.repository.CaveRepository
import javax.inject.Inject

class GetCaveSeedsUseCase @Inject constructor(private val repository: CaveRepository) {

    suspend operator fun invoke(caveId: Int) = repository.getCaveSeeds(caveId)
}
