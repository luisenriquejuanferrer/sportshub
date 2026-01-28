package com.luisenrique.sportshub.domain.model

data class Match(
    val id: String,
    val leagueId: String,
    val dateUtc: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val homeScore: Int?,
    val awayScore: Int?,
    val status: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val homeTeamPosession: Int?,
    val awayTeamPosession: Int?,
    val homeTeamKicks: Int?,
    val awayTeamKicks: Int?
)
