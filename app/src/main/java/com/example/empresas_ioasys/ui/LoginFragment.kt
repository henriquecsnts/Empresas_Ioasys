package com.example.empresas_ioasys.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.empresas_ioasys.R
import com.example.empresas_ioasys.presentation.LoginViewModel
import com.example.empresas_ioasys.presentation.ViewState.State.*
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    lateinit var button: AppCompatButton
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: TextInputEditText
    private val loginViewModel by viewModel<LoginViewModel>()
    private lateinit var loadingGroup: Group

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.btnLogin)
        edtEmail = view.findViewById(R.id.edtEmail)
        edtPassword = view.findViewById(R.id.edtPassword)
        loadingGroup = view.findViewById(R.id.loadingGroup)

        button.setOnClickListener{
            loginViewModel.login(edtEmail.text.toString(), edtPassword.text.toString())

        }
        setObservers()
        onLoading(false)
    }

    private fun setObservers() {
        loginViewModel.headersLiveData.observe(viewLifecycleOwner, {
            when(it.state) {

                SUCCESS -> onResultSuccess()
                ERROR -> onResultError(it.error)
                LOADING -> onLoading(it.isLoading)
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

    private fun onResultSuccess() {
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToMainFragment(                    )
        )
        loginViewModel.clearStatus()

    }

}