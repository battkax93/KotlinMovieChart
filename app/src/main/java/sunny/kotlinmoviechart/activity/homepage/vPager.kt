package sunny.kotlinmoviechart.activity.homepage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import sunny.kotlinmoviechart.fragment.first_fragment.FirstFragment
import sunny.kotlinmoviechart.fragment.second_fragment.SecondFragment


class vPager(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            else -> SecondFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "First Tab"
            else -> "Second Tab"
        }
    }
}




