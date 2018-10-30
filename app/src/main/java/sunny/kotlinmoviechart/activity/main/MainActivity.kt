package sunny.kotlinmoviechart.activity.main

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.kotlinmoviechart.R
import sunny.kotlinmoviechart.network.api.GithubApi
import sunny.kotlinmoviechart.network.model.Github
import kotlin.coroutines.experimental.coroutineContext

class MainActivity : AppCompatActivity(), MainContract.mainView {

    private lateinit var ui: MainUI
    private lateinit var present: MainContract.mainPresent
    private lateinit var api: GithubApi
    private lateinit var user: Github

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVar()
        ui.setContentView(this)
        action()
    }

    private fun initVar() {
        present = MainPresent(this)
        api = GithubApi()
        ui = MainUI()
        user = Github()
    }

    private fun action() {
        with(ui) {
            bId.text = "check"
            bId.backgroundColor = Color.CYAN
            bId.onClick {
                toast("${etUsername.text}")
                run("${etUsername.text}", applicationContext)
            }
        }
    }

    override fun run(un: String, ctx: Context) {
        with(ui) {
            present = MainPresent(this@MainActivity)
            api = GithubApi()
            Log.d("cek", un)
            Log.d("FLOW", "MainAct.run")
            present.getData(api, un, ctx)
        }
    }

    override fun updateUi(user: Github) {
        with(ui) {
            Glide.with(this@MainActivity).load(user?.avatarUrl).into(iv)
            un.text = user?.name
            cp.text = user?.company
        }
    }

}
