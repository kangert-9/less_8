package com.example.less_8.model

import android.os.Parcel
import android.os.Parcelable

data class Film(
    val id: Int?, val name: String?, val rating: Double?, val director: String?,
    val year: Int?, val isLike: Boolean?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeValue(rating)
        parcel.writeString(director)
        parcel.writeValue(year)
        parcel.writeValue(isLike)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}


fun getFilms() = listOf(
    Film(580489,"Venom 2",7.1, "Andy Serkis", 2021, false),
    Film(438631,"Dune", 8.0, "Denis Villeneuve", 2021, false),
    Film(577922,"Tenet",9.6, "Christopher Jonathan James Nolan", 2020, false),
    Film(497698,"Black Widow", 5.5, "Cate Shortland", 2021, false),
    Film(370172,"James Bond. No time to die", 9.0, "Cary Joji Fukunaga", 2021, false)
)