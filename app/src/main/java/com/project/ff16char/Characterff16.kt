package com.project.ff16char

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characterff16(
    val imgChar: Int,
    val nameChar: String,
    val descChar: String
): Parcelable
