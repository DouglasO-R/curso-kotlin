import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.ageFormat(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var age:Int = 0
    val dataNascimento = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    age = Period.between(dataNascimento, today).years

    return age
}