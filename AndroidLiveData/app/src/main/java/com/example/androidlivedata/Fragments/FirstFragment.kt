package com.example.androidlivedata.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.androidlivedata.Database.DataSource
import com.example.androidlivedata.R
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val dataSource = DataSource()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFirstInc.setOnClickListener {
            dataSource.incFirstFrag()
        }

        dataSource.getMediatorLiveData().observe(viewLifecycleOwner, Observer {
            tvFirst.text = it
        })

    }
}