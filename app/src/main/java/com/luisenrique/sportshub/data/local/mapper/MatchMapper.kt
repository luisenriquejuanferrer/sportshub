package com.luisenrique.sportshub.data.local.mapper

import com.luisenrique.sportshub.data.local.entities.MatchEntity
import com.luisenrique.sportshub.data.local.entities.MatchWithTeams
import com.luisenrique.sportshub.domain.model.Match

fun MatchWithTeams.toDomain(): Match =
    Match(
        id = match.id,
        leagueId = match.leagueId,
        dateUtc = match.dateUtc,
        homeTeamId = match.homeTeamId,
        awayTeamId = match.awayTeamId,
        homeScore = match.homeScore,
        awayScore = match.awayScore,
        status = match.status,
        homeTeam = homeTeam.toDomain(),
        awayTeam = awayTeam.toDomain(),
        homeTeamPosession = match.homeTeamPosession,
        awayTeamPosession = match.awayTeamPosession,
        homeTeamKicks = match.homeTeamKicks,
        awayTeamKicks = match.awayTeamKicks
    )

fun Match.toEntity(): MatchEntity =
    MatchEntity(
        id = id,
        leagueId = leagueId,
        dateUtc = dateUtc,
        homeTeamId = homeTeamId,
        awayTeamId = awayTeamId,
        homeScore = homeScore,
        awayScore = awayScore,
        status = status,
        homeTeamPosession = homeTeamPosession,
        awayTeamPosession = awayTeamPosession,
        homeTeamKicks = homeTeamKicks,
        awayTeamKicks = awayTeamKicks
    )