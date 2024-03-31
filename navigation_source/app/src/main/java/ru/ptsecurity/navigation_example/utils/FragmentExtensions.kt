package ru.ptsecurity.navigation_example.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Fragment.isKeyboardVisible(): Boolean {
    return activity?.isKeyboardVisible() ?: false
}

fun FragmentActivity.isKeyboardVisible(): Boolean {
    return ViewCompat
        .getRootWindowInsets(window.decorView)
        ?.isVisible(WindowInsetsCompat.Type.ime()) ?: false
}

inline fun <reified T> Fragment.getParentAsListener(): T? {
    val parentFragment = parentFragment
    val activity = activity
    return when {
        T::class.java.isInstance(parentFragment) -> T::class.java.cast(parentFragment)
        T::class.java.isInstance(activity) -> T::class.java.cast(activity)
        else -> null
    }
}

inline fun <reified T> Fragment.extra(key: String, default: T): Lazy<T> {
    return lazy { arguments?.get(key) as? T ?: default }
}

inline fun <reified T> Fragment.requireExtra(key: String): Lazy<T> {
    return lazy { requireArguments().get(key) as T }
}

inline fun <reified T> AppCompatActivity.requireExtra(key: String): Lazy<T> {
    return lazy { intent?.extras?.get(key) as T }
}

inline fun <reified T> AppCompatActivity.extra(key: String, default: T): Lazy<T> {
    return lazy { intent?.extras?.get(key) as? T ?: default }
}

inline fun <reified T> Fragment.extra(key: String): Lazy<T?> {
    return lazy { arguments?.get(key) as? T }
}

inline fun <reified T> Fragment.getParentAsListenerOrThrow(): T {
    val parentFragment = parentFragment
    val activity = activity
    return when {
        T::class.java.isInstance(parentFragment) -> T::class.java.cast(parentFragment)
        T::class.java.isInstance(activity) -> T::class.java.cast(activity)
        else -> null
    } ?: throw Exception("You should provide listener: " + T::class.java.simpleName)
}