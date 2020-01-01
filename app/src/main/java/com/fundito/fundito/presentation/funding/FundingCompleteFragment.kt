package com.fundito.fundito.presentation.funding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fundito.fundito.R
import com.fundito.fundito.data.service.NetworkClient
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_funding_complete.*
import kotlinx.android.synthetic.main.fragment_funding_progress.*
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by mj on 26, December, 2019
 */
class FundingCompleteFragment : DaggerFragment() {

    private val mViewModel: FundingViewModel by lazy{ ViewModelProvider(requireActivity())[FundingViewModel::class.java]}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_funding_complete,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

}