package com.cpo.landing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fitur(
    var title :String,
    var ic: Int
):Parcelable
