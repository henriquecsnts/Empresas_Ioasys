package com.example.empresas_ioasys.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.empresas_ioasys.Company
import com.example.empresas_ioasys.presentation.ViewState
import com.example.empresas_ioasys.R
import com.example.empresas_ioasys.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val adapter by lazy { CompanyAdapter(::clickItem) }
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private val mainViewModel by viewModel<MainViewModel>()
    private lateinit var loadingGroup: Group

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.adapter = adapter
        loadingGroup = view.findViewById(R.id.loadingGroupMain)
        mainViewModel.getCompanies()

        setupToolbar()
        setObservers()

    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).run {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setObservers() {
        mainViewModel.companyListLiveData.observe(viewLifecycleOwner, {
            when(it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<Company>())
                ViewState.State.ERROR -> onResultError(it.error)
                ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onLoading(loading: Boolean) {
        if(loading)
            loadingGroup.visibility = View.VISIBLE
        else
            loadingGroup.visibility = View.GONE

    }

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message?: "", Toast.LENGTH_LONG).show()
    }

    private fun onSuccess(list: List<Company>){
        adapter.setItems(list)

    }

    private fun clickItem(company: Company){
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(
                name = company.companyName,
                imageUrl = company.pathImage,
                description = company.description
        ))
    }
}

