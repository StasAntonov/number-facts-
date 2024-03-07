package com.example.numberfacts.ext

import androidx.core.text.isDigitsOnly

fun String.toLong(): Long {
    return this.split(' ').first {
        it.isDigitsOnly()
    }.toLongOrNull() ?: -1
}