package com.luisenrique.sportshub.ui.navigation

object Routes {
    const val LoginRegister = "login_register";
    const val Register = "register";
    const val Dashboard = "dashboard";
    const val Leagues = "leagues";
    const val Teams = "teams";
    const val TeamDetail = "teamDetail";
    const val PlayerDetail = "playerDetail"
    const val Matches = "matches";
    const val Bets = "bets"
    const val Profile = "profile";

    // Rutas con argumentos
    const val LeagueDetailBase = "league_detail"
    const val LeagueDetailArg = "leagueId"
    const val LeagueDetail = "$LeagueDetailBase/{$LeagueDetailArg}"

    const val ClasificationBase = "clasification"
    const val ClasificationArg = "leagueId"
    const val Clasification = "$ClasificationBase?$ClasificationArg={$ClasificationArg}"

    const val MatchDetailBase = "match_detail"
    const val MatchDetailArg = "matchId"
    const val MatchDetail = "$MatchDetailBase/{$MatchDetailArg}"

    // Funciones helper para navegar
    fun createLeagueDetailRoute(leagueId: String): String {
        return "$LeagueDetailBase/$leagueId"
    }

    fun createClasificationRoute(leagueId: String): String {
        return "$ClasificationBase?$ClasificationArg=$leagueId"
    }

    fun createMatchDetailRoute(matchId: String): String {
        return "$MatchDetailBase/$matchId"
    }
}
