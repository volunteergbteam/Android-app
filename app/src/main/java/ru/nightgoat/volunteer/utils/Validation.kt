package ru.nightgoat.volunteer.utils

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

fun isValidEmail(target: String?): Boolean {
    return if (target == null) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}

fun isValidPassword(target: String?): Boolean {
    return if (target == null) {
        false
    } else {
        val pattern = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
        )
        return pattern.matcher(target).matches()
    }
}

fun isNameValid(target: String?): Boolean {
    return if (target == null) {
        false
    } else {
        val pattern = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
        )
        return pattern.matcher(target).matches()
    }
}