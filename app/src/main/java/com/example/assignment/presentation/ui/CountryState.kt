package com.example.assignment.presentation.ui

import com.example.assignment.domain.model.Countries

data class CountryState (
      val data: List<Countries>?=null,
      val error: String="",
      val isLoading: Boolean=false
        )
