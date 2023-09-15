package com.tarantik.core.base.composable

fun noLocalProviderFor(name: String): Nothing {
    error("CompositionLocal $name not provided")
}
