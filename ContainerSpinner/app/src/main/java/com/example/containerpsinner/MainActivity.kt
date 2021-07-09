package com.example.containerpsinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spdata = listOf("- 선택하세요 -","1월","2월","3월","4월","5월","6월","7월")

        var spadapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, spdata)

        spinner.adapter = spadapter
        spinner.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tv_result.text = spdata.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val rcdata : MutableList<Memo> = loadData()

        var rcadapter = CustomAdapter()
        rcadapter.listData = rcdata

        recyclerview.adapter = rcadapter
        recyclerview.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
    }


    fun loadData(): MutableList<Memo> {
        val data : MutableList<Memo> = mutableListOf()
        for (no in 1..100){
            val title = "엄준식은 살아있다 ${no+1}"
            val date = System.currentTimeMillis()
            var memo = Memo(no,title,date)
            data.add(memo)
        }
        return  data
    }
}