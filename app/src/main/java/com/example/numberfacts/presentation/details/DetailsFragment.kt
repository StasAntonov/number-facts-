package com.example.numberfacts.presentation.details

import com.example.numberfacts.databinding.FragmentDetailsBinding
import com.example.numberfacts.presentation.base.BaseFragment

class DetailsFragment: BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate){
    override fun initViews() {
        super.initViews()
        binding.tvText.text = arguments?.getString(ARGUMENT_KEY)
    }

    override fun initListeners() {
        super.initListeners()
        binding.ibBack.setOnClickListener{
            goBack()
        }
    }
    companion object {
        const val ARGUMENT_KEY = "text"
    }
}