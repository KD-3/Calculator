package com.example.kaustubh.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.graphics.Rect
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recycler_view.addItemDecoration(LinearLayoutSpaceItemDecoration(16))

        val value = intent.getStringExtra("key")
        Log.d("suthar", value)

        val list = ArrayList<Contact>()
        initList(list)

        val adapter = MyContactListAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

    }

    class LinearLayoutSpaceItemDecoration(var spacing: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
            if (outRect != null &amp;&amp; parent != null) {
                var position = parent.getChildAdapterPosition(view)
                outRect.left = spacing
                outRect.right = spacing
                outRect.bottom = spacing
                if (position &lt; 1) outRect.top = spacing
            }
        }
    }



    private fun initList(list: ArrayList<Contact>) {
        list.add(Contact("Abhinav Suthar", "+917240505099"))
        list.add(Contact("Kaustubh Dixit", "+919919837374"))
        list.add(Contact("Sahil Patel", "+917240505078"))
        list.add(Contact("Divya Singh", "+9172454605099"))
        list.add(Contact("Ajat Prabha", "+917289505099"))
        list.add(Contact("Anshul Ahuja", "+917240505099"))
        list.add(Contact("Saksham Banga", "+978240505099"))
        list.add(Contact("Saksham Gupta", "+917265905099"))
        list.add(Contact("Amol Arora", "+918440505099"))
        list.add(Contact("Mayank Raj", "+918140505099"))
        list.add(Contact("Abhishek Sharma", "+916640505099"))
        list.add(Contact("manul Goyal", "+918740505099"))
        list.add(Contact("Manan Shah", "+919940505099"))
        list.add(Contact("Aditya Singh", "+9132240505099"))
        list.add(Contact("Nanda Kumar", "+915540505099"))
    }
}

class MyContactListAdapter(private val list: ArrayList<Contact>) : RecyclerView.Adapter<MyContactListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.contact_view, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {

        holder.name.text = list[pos].name
        holder.number.text = list[pos].number

        holder.card.setOnClickListener {
            Toast.makeText(holder.card.context, "Number $pos clicked!", Toast.LENGTH_SHORT).show()
        }
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.textView2)
        val number: TextView = view.findViewById(R.id.textView3)
        val icon: ImageView = view.findViewById(R.id.textView)
        val delete: ImageView = view.findViewById(R.id.textView4)
        val card: ConstraintLayout = view.findViewById(R.id.card)
    }
}

data class Contact(val name: String, val number: String)
