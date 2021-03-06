package com.example.empresas_ioasys.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.empresas_ioasys.R

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var toolbar: Toolbar
    private lateinit var imageDetailCompany: AppCompatImageView
    private lateinit var companyName: AppCompatTextView
    private lateinit var descriptionCompany: AppCompatTextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        imageDetailCompany = view.findViewById(R.id.imageDetailCompany)
        companyName = view.findViewById(R.id.companyName)
        descriptionCompany = view.findViewById(R.id.descriptionCompany)
        setupToolbar()
        configureView()
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity)?.run {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun configureView() {
        companyName.text = args.name
        descriptionCompany.text = args.description
        descriptionCompany.movementMethod = ScrollingMovementMethod()
        setImageContent()
    }

    private fun setImageContent() {
        Glide
            .with(this)
            .load("https://thispersondoesnotexist.com/image")
            .placeholder(R.drawable.img_logo)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(imageDetailCompany)
    }
}