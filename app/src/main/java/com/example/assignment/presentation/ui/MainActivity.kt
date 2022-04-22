package com.example.assignment.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.MainApplication
import com.example.assignment.R
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.domain.model.Countries
import com.example.assignment.domain.use_case.GetCountryListUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : CountryViewModel
    private lateinit var adapter: CountryAdapter

    @Inject
    lateinit var viewModelFactory: CountryViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as MainApplication).appComponent.inject(this)

        viewModel=ViewModelProvider(this, viewModelFactory).get(CountryViewModel::class.java)
        adapter= CountryAdapter()
        binding.recyclerView.adapter=adapter
        getCountries()

        viewModel.loading.observe(this, Observer {
            if (it) {
                showProgress()
            } else {
                hideProgress()
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it + "", Toast.LENGTH_LONG).show()
        })

        viewModel.countryList.observe(this, Observer {
            it?.let {
                if (it.isEmpty()){
                    Toast.makeText(this,  "No Record Found..", Toast.LENGTH_LONG).show()
                }
                adapter.setCountryList(it)
            }
        })

    }

    private fun getCountries(){
        viewModel.getCountryList()
    }

    private fun showProgress(){
        binding.progressBar.visibility=View.VISIBLE
    }

    private fun hideProgress() {
        binding.progressBar.visibility=View.GONE
    }


}