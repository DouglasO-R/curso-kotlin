package br.com.douglasor.oliveiragames.model

import java.time.LocalDate
import java.time.Period

data class Period(
    val startDate: LocalDate,
    val endDate: LocalDate,
) {
    val inDays: Int = Period.between(startDate, endDate).days
}
