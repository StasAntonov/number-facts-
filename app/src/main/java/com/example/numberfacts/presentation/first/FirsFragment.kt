package com.example.numberfacts.presentation.first

import androidx.core.text.isDigitsOnly
import androidx.fragment.app.viewModels
import com.example.numberfacts.databinding.FragmentFirstBinding
import com.example.numberfacts.ext.toast
import com.example.numberfacts.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirsFragment: BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate){

    private val viewModel: FirstViewModel by viewModels()

    override fun initObservers() {
        super.initObservers()
        viewModel.fact.observe(viewLifecycleOwner){
            navigate(FirsFragmentDirections.showDetails(it))
        }
        viewModel.error.observe(viewLifecycleOwner){
            toast(it)
        }
    }

    override fun initListeners() {
        super.initListeners()
        binding.btFact.setOnClickListener {
            val number = binding.etNumber.text.toString()
            if (number.isNotEmpty() && number.isDigitsOnly()){
                viewModel.getFact(number.toLong())
            } else {
                toast("Enter number")
            }
        }

        binding.btRandomFact.setOnClickListener {
            viewModel.getRandomFact()
        }
    }

}