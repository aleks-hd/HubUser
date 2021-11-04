package com.hfad.hubuser.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @Expose val login: String? = null
): Parcelable