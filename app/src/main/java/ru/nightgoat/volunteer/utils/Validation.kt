package ru.nightgoat.volunteer.utils

import android.util.Patterns
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
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W\\S])(?=\\S+\$).{8,}\$"
        )
        return pattern.matcher(target).matches()
    }
}