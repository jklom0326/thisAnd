package com.example.containerpsinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat

class CustomAdapter : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { // 한 화면에 그려지는 아이템 개수만큼 레이아웃 생성
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return  Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) { // 생성된 아이템 레이아웃에 값 입력 후 목록에출력
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int { // 목록에 보여줄 아이템의 개수
        return listData.size
    }
}
class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun setMemo(memo : Memo){
        itemView.textNo.text = "${memo.no}"
        itemView.Title.text = memo.title
        val sdf = SimpleDateFormat("yyyy/MM/dd")
        val formattedDate = sdf.format(memo.timestamp)
        itemView.textDate.text = formattedDate
    }
    init {
        itemView.setOnClickListener {
            Toast.makeText(itemView.context,"클릭된 아이템 = ${itemView.Title.text}",
            Toast.LENGTH_LONG).show()
        }
    }
}