package com.example.androidlivedata.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.androidlivedata.Database.DataSource
import com.example.androidlivedata.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val dataSource = DataSource()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSecondInc.setOnClickListener {
            dataSource.incSecondFrag()
        }

        dataSource.getMediatorLiveData().observe(viewLifecycleOwner, Observer {
            tvSecond.text = it
        })

    }
}