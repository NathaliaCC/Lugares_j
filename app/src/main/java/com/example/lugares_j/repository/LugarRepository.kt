package com.example.lugares_j.repository

import androidx.lifecycle.LiveData
import com.example.lugares_j.data.LugarDao
import com.example.lugares_j.model.Lugar

class LugarRepository(private val lugarDao: LugarDao) {

    suspend fun saveLugar(lugar: Lugar){
        if(lugar.id==0){ // Es un lugar nuevo
            lugarDao.addLugar(lugar)
        } else{ // Es un lugar ya registrado
            lugarDao.updateLugar(lugar)
        }
    }

    suspend fun deleteLugar(lugar: Lugar) {
        if (lugar.id!=0) { // Si el ID tiene un valor... lo intento eliminar
            lugarDao.deleteLugar(lugar)
        }
    }
    val getLugares : LiveData<List<Lugar>> = lugarDao.getLugares()
}
