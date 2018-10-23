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

class MainActivity : AppCompatActivity() {

    private lateinit var present: MainContract.mainPresent
    private lateinit var api: GithubApi
    lateinit var ctx: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        MovieUI().setContentView(this)
    }

    /*  override fun run() {
          present = MainPresent(this)
          api = GithubApi()
          b_test.setOnClickListener {
              val username = et_test.text.toString()
              Log.d("cek", username)
              Log.d("FLOW", "MainAct.run")
              present.getData(api, username)
          }
      }

      override fun init(user: Github) {
          Glide.with(this).load(user.avatarUrl).into(image)
          username.text = user.name.toString()
          company.text = user.company.toString()
      }*/


    class MovieUI : AnkoComponent<MainActivity>, MainContract.mainView {

        lateinit var etUsername: EditText
        lateinit var bId: Button
        lateinit var iv: ImageView
        lateinit var un: TextView
        lateinit var cp: TextView
        lateinit var present: MainContract.mainPresent
        lateinit var api: GithubApi

        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER_VERTICAL
                lparams(matchParent, wrapContent)
                padding = dip(16)

                etUsername = editText {
                    hint = "input your username"
                }.lparams(matchParent, wrapContent)

                bId = button {
                    text = "haloo"
                    onClick {
                        toast("${etUsername.text}")
                        run("${etUsername.text}")
                    }
                }.lparams(matchParent, wrapContent)

                verticalLayout {
                    lparams(matchParent, wrapContent)
                    padding = dip(10)

                    iv = imageView().lparams(matchParent, wrapContent)
                    un = textView().lparams(matchParent, wrapContent)
                    cp = textView().lparams(matchParent, wrapContent)
                }
            }
        }
        
        override fun run(un: String) {
            present = MainPresent(this)
            api = GithubApi()
            Log.d("cek", un)
            Log.d("FLOW", "MainAct.run")
            present.getData(api, un)
        }

        override fun init(user: Github) {
            Picasso.get().load(user.avatarUrl).into(iv)
            un.text = user.name.toString()
            cp.text = user.company.toString()
        }
    }
}




