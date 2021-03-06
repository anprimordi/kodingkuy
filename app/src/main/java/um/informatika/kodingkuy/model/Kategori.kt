package um.informatika.kodingkuy.model

import android.os.Parcel
import android.os.Parcelable

data class Kategori(
        val id: Int,
        val title: String? = "",
        val image: Int,
        val soal: Int,
        val jawabanKunci: Int,
        val jawabanA: Int,
        val jawabanB: Int,
        val jawabanC: Int,
        val jawabanD: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeInt(image)
        parcel.writeInt(soal)
        parcel.writeInt(jawabanKunci)
        parcel.writeInt(jawabanA)
        parcel.writeInt(jawabanB)
        parcel.writeInt(jawabanC)
        parcel.writeInt(jawabanD)
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