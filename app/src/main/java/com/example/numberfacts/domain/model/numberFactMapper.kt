package com.example.numberfacts.domain.model

import com.example.numberfacts.data.datasource.local.entities.NumberEntity

fun NumberFact.toNumberEntity() = NumberEntity(
    fact = fact,
    number = number
)

fun NumberEntity.toNumberFact(): NumberFact {
    return NumberFact(this.fact, this.number)
}