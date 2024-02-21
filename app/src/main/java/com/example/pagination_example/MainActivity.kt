package com.example.pagination_example

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.AbsListView
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var isscrolling =false
    var currentitems =0
    var scrolleditems=0
    var totalitems=0
    val arrnumber= ArrayList<Model>()
    val recyclerAdapter = Adapter(this, arrnumber)
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
         progressBar = findViewById<ProgressBar>(R.id.progressbar1)


        arrnumber.add(Model(0))
        arrnumber.add(Model(10))
        arrnumber.add(Model(42))
        arrnumber.add(Model(5))
        arrnumber.add(Model(50))
        arrnumber.add(Model(77))
        arrnumber.add(Model(60))
        arrnumber.add(Model(20))
        arrnumber.add(Model(76))
        arrnumber.add(Model(86))
        arrnumber.add(Model(76))
        arrnumber.add(Model(76))
        arrnumber.add(Model(7))

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager


        recyclerview.adapter=recyclerAdapter

        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                currentitems= layoutManager.childCount
                totalitems= layoutManager.itemCount
                scrolleditems= layoutManager.findFirstVisibleItemPosition()

                if(isscrolling && (currentitems+scrolleditems==totalitems)){
                    isscrolling=false
                    fetchdata()
                }

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isscrolling = true
                }
            }
        })

    }

    private fun fetchdata() {
        progressBar.visibility = ProgressBar.VISIBLE
        Handler().postDelayed({
                              for(i in 0..4){
                                  var num =Math.floor(Math.random()*100)
                                  arrnumber.add(Model(num.toInt()))
                                  recyclerAdapter.notifyDataSetChanged()
                                  progressBar.visibility = ProgressBar.GONE
                              }
        },2000)
    }
}