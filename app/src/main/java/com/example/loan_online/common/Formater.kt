package com.example.loan_online.common

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: String): String {

    val patternIn = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    val patternOut = "EEE, d MMM yyyy HH:mm:ss"
    val simpleDateFormatIn = SimpleDateFormat(patternIn, Locale.getDefault())
    val simpleDateFormatOut = SimpleDateFormat(patternOut, Locale.getDefault())

    val parsedDate: Date = simpleDateFormatIn.parse(date)

    return simpleDateFormatOut.format(parsedDate)


}

fun Double.format(digits: Int) = "%.${digits}f".format(this)
