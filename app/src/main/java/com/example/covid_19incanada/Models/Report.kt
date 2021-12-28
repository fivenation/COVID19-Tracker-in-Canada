package com.example.covid_19incanada.Models

data class ReportModel(
        var data : List<ReportData>,
        var latest_update : String?
)

data class ReportData(
        var province : String?,
        var date : String?,
        var change_cases : String?,
        var change_fatalities : String?,
        var change_tests : String?,
        var change_hospitalizations : String?,
        var change_criticals : String?,
        var change_recoveries : String?,
        var change_vaccinations : String?,
        var change_vaccinated : String?,
        var change_vaccines_distributed : String?,
        var total_cases : String?,
        var total_fatalities : String?,
        var total_tests : String?,
        var total_hospitalizations : String?,
        var total_criticals : String?,
        var total_recoveries : String?,
        var total_vaccinations : String?,
        var total_vaccinated : String?,
        var total_vaccines_distributed : String?
)