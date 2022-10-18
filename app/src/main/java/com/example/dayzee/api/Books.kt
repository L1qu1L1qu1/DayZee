package com.example.dayzee.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Books(
    val id: Int,
    val author: String,
    val description: String,
    val published: Int,
    val title: String
):Parcelable