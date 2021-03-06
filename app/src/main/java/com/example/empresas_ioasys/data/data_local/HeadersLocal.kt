package com.example.empresas_ioasys.data.data_local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "headers_table")
data class HeadersLocal (
        @PrimaryKey(autoGenerate = true) var id : Int = -1,
        val token : String,
        val client : String,
        val uid : String
)