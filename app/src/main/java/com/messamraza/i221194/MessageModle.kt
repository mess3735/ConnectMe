package com.messamraza.i221194

import android.os.Parcel
import android.os.Parcelable

data class MessageModle(
    val messageText: String,
    val isSent: Boolean,  // true = sent, false = received
    val timestamp: String // Message timestamp
) : Parcelable {
    private constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(messageText)
        parcel.writeByte(if (isSent) 1 else 0)
        parcel.writeString(timestamp)
    }
    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<MessageModle> {
        override fun createFromParcel(parcel: Parcel): MessageModle = MessageModle(parcel)

        override fun newArray(size: Int): Array<MessageModle?> = arrayOfNulls(size)
    }
}
