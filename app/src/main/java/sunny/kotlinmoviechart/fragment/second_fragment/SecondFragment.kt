package sunny.kotlinmoviechart.fragment.second_fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.jetbrains.anko.support.v4.toast

import sunny.kotlinmoviechart.R
import sunny.kotlinmoviechart.network.api.StackExchangeApi
import sunny.kotlinmoviechart.network.model.Stck
import java.util.ArrayList


class SecondFragment : Fragment() {

    lateinit var stackList: List<Stck.Item>
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var xAdapter: xAdapter
    lateinit var present: SecondFragmenContract.secondFragPresent
    lateinit var api: StackExchangeApi
    lateinit var recycleView: RecyclerView
    lateinit var b1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val secondFragment = inflater.inflate(R.layout.fragment_second, container, false)
        initVar(secondFragment)
        init(secondFragment)
        return secondFragment
    }

    private fun initVar(v: View){
        Log.d("FLOW", "secondFrag.initVar")
        present = SecondFragmentPresent()
        api = StackExchangeApi()
        stackList = listOf()

//        xAdapter = sunny.kotlinmoviechart.fragment.second_fragment.xAdapter(context,stackList)
        xAdapter = xAdapter(activity!!.applicationContext  , ArrayList(0))

        linearLayoutManager = LinearLayoutManager(context)
        recycleView = v.findViewById(R.id.rv_answers)
        b1 = v.findViewById(R.id.btn_1)
    }

    private fun init(v: View) {
        Log.d("FLOW", "secondFrag.init")
        val itemDecoration: RecyclerView.ItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        recycleView.layoutManager = linearLayoutManager
        recycleView.adapter = xAdapter
        recycleView.setHasFixedSize(true)
        recycleView.addItemDecoration(itemDecoration)

        b1.setOnClickListener {
            toast("click")
            run()
        }
    }

    private fun run(){
        Log.d("FLOW", "secondFrag.run")
        present.getlist(api, "desc", "activity", "stackoverflow",activity!!.applicationContext)
    }
}
