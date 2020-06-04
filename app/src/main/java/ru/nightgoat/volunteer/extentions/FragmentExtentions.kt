package ru.nightgoat.volunteer.extentions

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.popBackStack() {
    findNavController().popBackStack()
}

fun Fragment.navigateTo(action: Int) {
    findNavController().navigate(action)
}

fun Fragment.navigateTo(action: Int, bundle: Bundle) {
    findNavController().navigate(action, bundle)
}

fun Fragment.showShortToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showLongToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
}