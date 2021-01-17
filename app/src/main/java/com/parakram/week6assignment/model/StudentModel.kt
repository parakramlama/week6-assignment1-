package com.parakram.week6assignment.model

import android.os.Parcel
import android.os.Parcelable

data class StudentModel (
    val fullName: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val address: String? = null,
    val profileLink: String? = null,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeValue(age)
        parcel.writeString(gender)
        parcel.writeString(address)
        parcel.writeString(profileLink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentModel> {
        override fun createFromParcel(parcel: Parcel): StudentModel {
            return StudentModel(parcel)
        }

        override fun newArray(size: Int): Array<StudentModel?> {
            return arrayOfNulls(size)
        }
    }
}

