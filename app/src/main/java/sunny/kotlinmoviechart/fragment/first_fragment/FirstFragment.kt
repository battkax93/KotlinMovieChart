package sunny.kotlinmoviechart.fragment.first_fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import sunny.kotlinmoviechart.R
import sunny.kotlinmoviechart.activity.main.MainActivity
import sunny.kotlinmoviechart.base.BaseContract

class FirstFragment : Fragment(), BaseContract.baseFragmentView {

    lateinit var bTes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val firstFragment = inflater.inflate(R.layout.fragment_first, container, false)
        init(firstFragment)
        return firstFragment
    }

    override fun init(v: View) {
        bTes = v.findViewById(R.id.b_tes)
        bTes.setOnClickListener {
            val i = Intent(context, MainActivity::class.java)
            startActivity(i)
        }
    }

    override fun initVar() {
    }

    override fun action() {
    }

    override fun run() {
    }

}
