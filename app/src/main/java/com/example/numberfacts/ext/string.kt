package com.example.numberfacts.ext

import androidx.core.text.isDigitsOnly

fun String.toLong(): Long {
    return this.split(' ').firstOrNull {
        it.isDigitsOnly()
    }?.toLongOrNull() ?: -1
}