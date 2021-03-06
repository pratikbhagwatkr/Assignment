package com.example.assignment.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.MainApplication
import com.example.assignment.R
import com.example.assignment.databinding.ActivityMainBinding

import com.example.assignment.presentation.adapter.CountryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : CountryViewModel
    @Inject
    lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(CountryViewModel::class.java)

        binding.recyclerView.adapter=adapter
        getCountries()

        lifecycleScope.launchWhenCreated {

            viewModel.countryState.collect{
                if (it.isLoading){
                    showProgress()
                }
                if (it.error.isNotBlank()){
                    hideProgress()
                    Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                }

                it.data?.let {  list->
                    if (list.isEmpty()){
                        Toast.makeText(this@MainActivity,  "No Record Found..", Toast.LENGTH_LONG).show()
                    }
                    hideProgress()
                    adapter.setCountryList(list)
                }
            }
        }

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