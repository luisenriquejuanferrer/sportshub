package com.luisenrique.sportshub.ui.navigation

object Routes {
    const val LoginRegister = "login_register";
    const val Register = "register";
    const val Dashboard = "dashboard";
    const val Leagues = "leagues";
    const val LeagueDetail = "leagueDetail";
    const val Teams = "teams";
    const val TeamDetail = "teamDetail";
    const val PlayerDetail = "playerDetail"
    const val Matches = "matches";
    // Rutas con argumentos
    const val MatchDetailBase = "match_detail"
    const val MatchDetailArg = "matchId"

    // La ruta completa para el NavHost: "match_detail/{matchId}"
    const val MatchDetail = "$MatchDetailBase/{$MatchDetailArg}"

    // Función helper para navegar: "match_detail/m_laliga_1"
    fun createMatchDetailRoute(matchId: String): String {
        return "$MatchDetailBase/$matchId"
    }

    //const val MatchDetail = "matchDetail";
    const val Clasification = "clasification";
    const val Bets = "bets"
    const val Profile = "profile";
}