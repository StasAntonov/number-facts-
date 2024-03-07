package com.example.numberfacts.domain.model

import com.example.numberfacts.common.PagingData

data class NumberFact(
    val fact: String,
    val number: Long
): PagingData()
