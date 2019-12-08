package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {

    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("Invalid units")
    }

    this.time = time
    
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val currentDate = time

    val diff = (date.time - currentDate) / 1000

    var res =  when {
        diff < 1 -> "только что"
        diff < 45 -> "несколько секунд назад"
        diff < 75 -> "минуту назад"
        (diff / 60) < 45 -> "${diff / 60} минут назад"
        (diff / 60) < 75 -> "час назад"
        (diff / 60 / 60) < 22 -> "${diff / 60 / 60} часов назад"
        (diff / 60 / 60) < 26 -> "день назад"
        (diff / 60 / 60 / 24) < 360 -> "год назад"
        else -> "более года назад"
    }

    return res
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}