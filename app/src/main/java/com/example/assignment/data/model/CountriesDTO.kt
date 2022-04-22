package com.example.assignment.data.model

import com.example.assignment.domain.model.Countries

data class CountriesDTO (
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val independent: Boolean,
    val landlocked: Boolean,
    val latlng: List<Double>,
    val name: Name,
    val population: Int,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val unMember: Boolean
    )


fun CountriesDTO.toDomainCountries():Countries{
    return Countries(
        commonName = this.name.common ?: "",
        officialName = this.name.official ?: "",
        url = this.flags.png ?: ""
    )
}


