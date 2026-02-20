package com.example.ordinariluisandroid.model

import java.io.Serializable


data class Launch (
    val id: String?= null,
    val Title: String?= null,
    val body: String?= null,
    val reactions: String?= null,

) : Serializable