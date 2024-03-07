package com.example.numberfacts.presentation.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import androidx.paging.map
import com.example.numberfacts.data.base.ApiResponse
import com.example.numberfacts.domain.SingleLiveEvent
import com.example.numberfacts.domain.model.toNumberFact
import com.example.numberfacts.domain.repository.INumberRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val numberRepository: INumberRepository
): ViewModel() {

    private var _fact = SingleLiveEvent<String>()
    val fact: LiveData<String> = _fact

    private var _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    val localNumberFacts = Pager(
        PagingConfig(pageSize = PAGE_SIZE)) {
        numberRepository.getAllLocalFacts()
    }.liveData.map { it.map {
            data -> data.toNumberFact()
    } }.cachedIn(viewModelScope)

    fun getFact(number:Long) {
        viewModelScope.launch {
            numberRepository.getNumberFact(number).handleFactResponse()
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            numberRepository.getRandomNumberFact().handleFactResponse()
        }
    }

    private fun ApiResponse<String>.handleFactResponse() {
        when(this){
            is ApiResponse.Success ->
                _fact.postValue(this.data.orEmpty())
            is ApiResponse.Error ->
                _error.postValue(this.toString())
        }
    }

    companion object {
        const val PAGE_SIZE = 10
    }
}