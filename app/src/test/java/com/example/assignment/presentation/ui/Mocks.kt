package com.example.assignment.presentation.ui

import com.example.assignment.data.model.CountriesDTO
import com.example.assignment.data.model.Flags
import com.example.assignment.data.model.Name
import com.example.assignment.domain.model.Countries

val mockCountriesModel = Countries(
    "India",
     "India",
            "India"

)


val mockCountriesModelList= listOf<Countries>(mockCountriesModel)

val mockCountryDTO = CountriesDTO(
    0.0,
    listOf("0","0"),
    listOf("A","B"),
    "q",
    "a",
    "z",
    "w",
    "d",
    Flags("",""),
    true,
    true,
    listOf(0.0,0.0),
    Name("India","India"),
    90,
    "h",
    "l",
    "g",
    "f",
    listOf(""),
    listOf(""),
    true
)

val mockCountriesDTOList= listOf<CountriesDTO>(mockCountryDTO)

