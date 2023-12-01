package com.growthook.aos.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.growthook.aos.domain.entity.Cave
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CaveSelectBottomSheetViewModel @Inject constructor() : ViewModel() {

    private val _caves = MutableLiveData<List<Cave>>()
    val caves: LiveData<List<Cave>> = _caves

    fun getCaves() {
        val dummyCave = listOf(
            Cave(1, "연습용"),
            Cave(2, "연습연습연습연습"),
            Cave(3, "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"),
            Cave(4, "동굴"),
            Cave(5, "연습용"),
            Cave(6, "연습연습연습연습"),
            Cave(7, "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"),
            Cave(8, "동굴"),
        )

        _caves.value = dummyCave
    }
}
