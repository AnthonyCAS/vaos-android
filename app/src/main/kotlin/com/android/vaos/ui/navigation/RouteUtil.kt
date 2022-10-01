package com.android.vaos.ui.navigation

import java.net.URLEncoder

@Suppress("MemberVisibilityCanBePrivate")
object RouteUtil {

    fun defineArg(argName: String): String {
        return "{$argName}"
    }

    fun defineOptionalArgs(vararg argNames: String): String {
        return argNames.joinToString("&") { argName -> "$argName={$argName}" }
    }

    fun optionalArgs(argNameValues: Map<String, Any?>): String {
        return argNameValues.filterValues { it != null }.entries.joinToString("&") {
            val value = when (val v = it.value) {
                is String -> encodeArg(v)
                else -> v
            }

            "${it.key}=$value"
        }
    }

    fun optionalArgs(argNameValues: List<Pair<String, Any?>>): String {
        return optionalArgs(argNameValues.associate { it })
    }

    fun optionalArgs(vararg argNameValues: Pair<String, Any?>): String {
        return optionalArgs(argNameValues.toList())
    }

    fun encodeArg(value: String?): String? = value?.let { URLEncoder.encode(it, "utf-8") }
}
