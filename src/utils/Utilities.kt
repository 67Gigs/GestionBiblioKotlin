package utils

// Function to validate if the date string matches the format YYYY, YYYY-MM, or YYYY-MM-DD
fun dateValidator(date: String): Boolean {
    val regex = """\d{4}(-\d{2}){0,2}""".toRegex()
    return regex.matches(date)
}

// Function to check if the date string is in the format YYYY (missing month and day)
fun moisManquant(date: String): Boolean {
    val regex = """\d{4}""".toRegex()
    return regex.matches(date)
}

// Function to check if the date string is in the format YYYY-MM (missing day)
fun jourManquant(date: String): Boolean {
    val regex = """\d{4}-\d{2}""".toRegex()
    return regex.matches(date)
}