package com.compose.utils

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun String.hmacSha256(): String {
    if (this.isBlank())
        return ""
    val secretKey = SecretKeySpec(this.toByteArray(Charsets.UTF_8), "HmacSHA256")
    val mac = Mac.getInstance("HmacSHA256")
    mac.init(secretKey)
    val hash = mac.doFinal(this.toByteArray(Charsets.UTF_8))
    return hash.joinToString("") { "%02x".format(it) }
}