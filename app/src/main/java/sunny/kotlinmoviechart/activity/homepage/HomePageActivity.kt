package sunny.kotlinmoviechart.activity.homepage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab.*
import sunny.kotlinmoviechart.R

class HomePageActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        init()
        trySetup()
    }

    private fun init() {
        val fragmentadapter = vPager(supportFragmentManager)
        viewpager.offscreenPageLimit = 2
        viewpager.adapter = fragmentadapter
        tablayout.setupWithViewPager(viewpager)
        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                viewpager.setCurrentItem(position, true)
            }

        })
    }

    private fun prepareTabView(pos: Int): View {
        val tabTitle = resources.getStringArray(R.array.tabTitle)
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        tv_title.text = (tabTitle[pos]).toString()
        return view
    }

    private fun setupViewPager() {
        val tabTitle = resources.getStringArray(R.array.tabTitle)
        for (i in 0 until tabTitle.size) {
            tablayout.getTabAt(i)!!.customView = prepareTabView(i)
        }
    }

    private fun trySetup() {
        try {
            setupViewPager()
        } catch (e: Exception) {
            Log.e("Error",e.toString())
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
