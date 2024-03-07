package com.example.numberfacts.presentation.first

import androidx.core.text.isDigitsOnly
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.numberfacts.common.PagingAdapter
import com.example.numberfacts.databinding.FragmentFirstBinding
import com.example.numberfacts.databinding.ItemNumberFactBinding
import com.example.numberfacts.domain.model.NumberFact
import com.example.numberfacts.ext.toast
import com.example.numberfacts.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment: BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate){

    private val viewModel: FirstViewModel by viewModels()

    private val numberFactsAdapter: PagingAdapter<NumberFact, ItemNumberFactBinding> by lazy {
        PagingAdapter(
            bindingInflater = ItemNumberFactBinding::inflate,
            onClickListener = ::navigateToDetailScreen
        )
    }

    override fun initViews() {
        super.initViews()
        binding.rvList.apply {
            adapter = numberFactsAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.fact.observe(viewLifecycleOwner){
            navigate(FirstFragmentDirections.showDetails(it))
        }
        viewModel.error.observe(viewLifecycleOwner){
            toast(it)
        }

        viewModel.localNumberFacts.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                numberFactsAdapter.submitData(it)
            }
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

    private fun navigateToDetailScreen(position: Int) {
        numberFactsAdapter.getItemByPosition(position)?.let {
            navigate(FirstFragmentDirections.showDetails(it.fact))
        }
    }

}