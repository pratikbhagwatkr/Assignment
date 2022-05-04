package com.example.domain


import com.example.data.data.entity.CountriesDTO
import com.example.data.data.entity.Flags
import com.example.data.data.entity.Name
import com.example.domain.domain.model.Countries

val mockCountriesModel = Countries(
    "India",
     "India",
            "India",

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
    Flags("India",""),
    true,
    true,
    listOf(0.0,0.0),
    Name("India","India",),
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

