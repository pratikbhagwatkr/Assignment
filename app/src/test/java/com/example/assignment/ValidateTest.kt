package com.example.assignment


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidateTest{

    @Test
    fun whenInputIsValid(){
        val res=Validate.sum(5,9)
        assertThat(res).isEqualTo(14)
    }





}