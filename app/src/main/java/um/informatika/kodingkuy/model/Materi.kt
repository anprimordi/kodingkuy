package um.informatika.kodingkuy.model

import android.os.Parcel
import android.os.Parcelable

data class Materi(
        val title: String? = "",
        val subtitle: String? = "",
        val imageSource: Int = 0,
        val fileSource: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(subtitle)
        parcel.writeInt(imageSource)
        parcel.writeString(fileSource)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Materi> {
        override fun createFromParcel(parcel: Parcel): Materi {
            return Materi(parcel)
        }

        override fun newArray(size: Int): Array<Materi?> {
            return arrayOfNulls(size)
        }
    }
}