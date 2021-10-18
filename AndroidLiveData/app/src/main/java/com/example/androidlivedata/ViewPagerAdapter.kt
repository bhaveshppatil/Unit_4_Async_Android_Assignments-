package com.example.androidlivedata

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidlivedata.Fragments.FirstFragment
import com.example.androidlivedata.Fragments.SecondFragment

internal class ViewPagerAdapter(

    var context: Context,
    fragmentManager: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}