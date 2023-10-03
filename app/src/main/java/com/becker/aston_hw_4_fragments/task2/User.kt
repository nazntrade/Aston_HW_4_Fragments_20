package com.becker.aston_hw_4_fragments.task2

import android.os.Parcel
import android.os.Parcelable

class User(
    val id: Int = 0,
    var photoLink: String? = "",
    var name: String? = "",
    var secondName: String? = "",
    var phoneNumber: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(photoLink)
        parcel.writeString(name)
        parcel.writeString(secondName)
        parcel.writeString(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}