package com.luisenrique.sportshub.ui.navigation

object Routes {
    const val LoginRegister = "login_register";
    const val Register = "register";
    const val Dashboard = "dashboard";
    const val Leagues = "leagues";
    const val Teams = "teams";
    const val TeamDetailBase = "team_detail";
    const val TeamDetailArg = "teamId";
    const val TeamDetail = "$TeamDetailBase/{$TeamDetailArg}"
    const val PlayerDetailBase = "player_detail"
    const val PlayerDetailArg = "playerId"
    const val PlayerDetail = "$PlayerDetailBase/{$PlayerDetailArg}"
    const val Bets = "bets"
    const val Profile = "profile";
    const val MatchesBase = "matches";
    const val MatchesArg = "leagueId"
    const val Matches = "$MatchesBase?$MatchesArg={$MatchesArg}"
    const val LeagueDetailBase = "league_detail"
    const val LeagueDetailArg = "leagueId"
    const val LeagueDetail = "$LeagueDetailBase/{$LeagueDetailArg}"
    const val ClasificationBase = "clasification"
    const val ClasificationArg = "leagueId"
    const val Clasification = "$ClasificationBase?$ClasificationArg={$ClasificationArg}"
    const val MatchDetailBase = "match_detail"
    const val MatchDetailArg = "matchId"
    const val MatchDetail = "$MatchDetailBase/{$MatchDetailArg}"

    fun createLeagueDetailRoute(leagueId: String): String {
        return "$LeagueDetailBase/$leagueId"
    }

    fun createClasificationRoute(leagueId: String): String {
        return "$ClasificationBase?$ClasificationArg=$leagueId"
    }

    fun createMatchDetailRoute(matchId: String): String {
        return "$MatchDetailBase/$matchId"
    }

    fun createMatchesRoute(leagueId: String): String {
        return "$MatchesBase?$MatchesArg=$leagueId"
    }

    fun createTeamDetailRoute(teamId: String): String {
        return "$TeamDetailBase/$teamId"
    }

    fun createPlayerDetailRoute(playerId: String): String {
        return "$PlayerDetailBase/$playerId"
    }
}
