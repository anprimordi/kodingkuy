package um.informatika.kodingkuy.model

import android.os.Parcel
import android.os.Parcelable

data class Kategori (
    val id: Int,
    val nama: String? = "",
    val soal: Int,
    val jawabanKunci: String?,
    val jawabanA: Int,
    val jawabanB: Int,
    val jawabanC: Int,
    val jawabanD: Int,
    val jawabanE: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nama)
        parcel.writeInt(soal)
        parcel.writeString(jawabanKunci)
        parcel.writeInt(jawabanA)
        parcel.writeInt(jawabanB)
        parcel.writeInt(jawabanC)
        parcel.writeInt(jawabanD)
        parcel.writeInt(jawabanE)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Kategori> {
        override fun createFromParcel(parcel: Parcel): Kategori {
            return Kategori(parcel)
        }

        override fun newArray(size: Int): Array<Kategori?> {
            return arrayOfNulls(size)
        }
    }
}