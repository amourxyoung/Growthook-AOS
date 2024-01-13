package com.growthook.aos.domain.repository

import com.growthook.aos.domain.entity.ActionlistDetail
import com.growthook.aos.domain.entity.Actionplan

interface ActionplanRepository {
    suspend fun getActionplans(seedId: Int): Result<List<Actionplan>>

    suspend fun postActionplans(seedId: Int, contents: List<String>): Result<Unit>

    suspend fun getDoingActionplans(memberId: Int): Result<List<ActionlistDetail>>

    suspend fun getFinishedActionplans(memberId: Int): Result<List<ActionlistDetail>>

    suspend fun completeActionplan(actionplanId: Int): Result<Unit>

    suspend fun modifyActionplan(actionplanId: Int): Result<Unit>

    suspend fun deleteActionplan(actionplanId: Int): Result<Unit>
    suspend fun getActionplanPercent(memberId: Int): Result<Int>
}
