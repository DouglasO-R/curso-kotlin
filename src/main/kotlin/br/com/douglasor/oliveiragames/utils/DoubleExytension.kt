package br.com.douglasor.oliveiragames.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.formatter():Double {
    val formatter = DecimalFormat("#0.00", DecimalFormatSymbols(Locale.US))
    return formatter.format(this).toDouble()
}