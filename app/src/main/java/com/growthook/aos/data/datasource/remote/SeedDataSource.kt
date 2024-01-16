package com.growthook.aos.data.datasource.remote

import com.growthook.aos.data.model.request.RequestSeedMoveDto
import com.growthook.aos.data.model.request.RequestSeedPostDto
import com.growthook.aos.data.model.response.ResponseAlarmDto
import com.growthook.aos.data.model.response.ResponseDataDto
import com.growthook.aos.data.model.response.ResponseDto
import com.growthook.aos.data.model.response.ResponseGetCaveSeedsDto
import com.growthook.aos.data.model.response.ResponseGetSeedDto
import com.growthook.aos.data.model.response.ResponseGetSeedsDto
import com.growthook.aos.data.model.response.ResponseMoveSeedDto

interface SeedDataSource {

    suspend fun getSeed(seedId: Int): ResponseGetSeedDto
    suspend fun deleteSeed(seedId: Int): ResponseDto

    suspend fun moveSeed(seedId: Int, request: RequestSeedMoveDto): ResponseMoveSeedDto

    suspend fun postSeed(caveId: Int, request: RequestSeedPostDto): ResponseDataDto

    suspend fun getCaveSeeds(caveId: Int): ResponseGetCaveSeedsDto

    suspend fun getSeedAlarm(memberId: Int): ResponseAlarmDto

    suspend fun getSeeds(memberId: Int): ResponseGetSeedsDto

    suspend fun unLockSeed(seedId: Int): ResponseDto

    suspend fun scrapSeed(seedId: Int): ResponseDto

    suspend fun modifySeed(seedId: Int): ResponseDto
}
