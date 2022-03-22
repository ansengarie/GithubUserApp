package com.ansengarie.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: Int?,
    var name: String?,
    var username: String?,
    var follower: String?,
    var following: String?,
    var company: String?,
    var location: String?,
    var repository: String?,
) : Parcelable
