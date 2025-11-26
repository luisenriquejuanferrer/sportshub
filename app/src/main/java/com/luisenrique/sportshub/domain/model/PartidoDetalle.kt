package com.luisenrique.sportshub.domain.model

data class PartidoDetalle(
    val fecha: String,
    val local: String,
    val visitante: String,
    val resultado: String,
    val estadio: String,
    val ciudad: String,
    val posesionLocal: Int,
    val posesionVisitante: Int,
    val tirosLocal: Int,
    val tirosVisitante: Int
)