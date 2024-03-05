package com.example.numberfacts.presentation

import com.example.numberfacts.databinding.ActivityMainBinding
import com.example.numberfacts.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate)