package com.example.lugares_j.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName ="Lugar")
data class Lugar(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombre")
    val nombre:String,
    @ColumnInfo(name="correo")
    val correo:String?,
    @ColumnInfo(name="telefono")
    val telefono:String?,
    @ColumnInfo(name="web")
    val web:String,
    @ColumnInfo(name="latitud")
    val latitud:Double?,
    @ColumnInfo(name="longitud")
    val longitud:Double?,
    @ColumnInfo(name="altura")
    val altura:Double?,
    @ColumnInfo(name="ruta-audio")
    val rutaAudio:String?,
    @ColumnInfo(name="ruta-imagen")
    val rutaImagen:String?
    ): Parcelable
