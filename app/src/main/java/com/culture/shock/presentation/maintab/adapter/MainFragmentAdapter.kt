package com.culture.shock.presentation.maintab.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.culture.shock.presentation.home.Home
import com.culture.shock.presentation.myinfo.MyInfo
import com.culture.shock.presentation.performance.Performance

class MainFragmentAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    private val fragmentList by lazy {
        listOf(Home(), Performance(), MyInfo())
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
