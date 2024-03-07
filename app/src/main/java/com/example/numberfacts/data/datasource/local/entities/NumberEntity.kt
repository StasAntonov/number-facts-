package com.example.numberfacts.data.datasource.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facts")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo (name = "fact")
    val fact: String,
    @ColumnInfo (name = "number")
    val number: Long
)
