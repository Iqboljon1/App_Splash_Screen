package com.ir.appsplashscreen.AdapterPager

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ir.appsplashscreen.DataClassPager.DataClassPager
import com.ir.appsplashscreen.ItemFragment
import com.ir.appsplashscreen.SplashFragment

class AdapterPager(
    var context: Context,
    var arrayListPager: ArrayList<DataClassPager>,
    var fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = arrayListPager.size

    override fun createFragment(position: Int): Fragment {

        return ItemFragment.newInstance(arrayListPager[position].stringName,
            arrayListPager[position].stringDescription,
            arrayListPager[position].image.toString(),
            position.toString())
    }
}