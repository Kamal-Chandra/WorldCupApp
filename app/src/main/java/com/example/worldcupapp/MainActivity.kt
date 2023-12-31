package com.example.worldcupapp

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Adapter View: List View (in this Case)
        var listview=findViewById<ListView>(R.id.listView)

        //  Adapter
        var adapter=MyAdapter(this,generatData())
        listview?.adapter=adapter
        adapter?.notifyDataSetChanged()

        listview.setOnItemClickListener { parent, view, position, id ->
            val selectedCountry = adapter.getItem(position)
            toggleDisplay(selectedCountry)
        }
    }

    //  Data Source
    fun generatData():ArrayList<CountryModel>
    {
        var CountryList=ArrayList<CountryModel>()
        var country1:CountryModel=CountryModel("Brazil","5",R.drawable.brazil)
        var country2:CountryModel=CountryModel("Argentina","3",R.drawable.argentina)
        var country3:CountryModel=CountryModel("Germany","4",R.drawable.germany)
        var country4:CountryModel=CountryModel("India","2",R.drawable.india)
        var country5:CountryModel= CountryModel("USA","1",R.drawable.usa)
        var country6:CountryModel=CountryModel("China","0",R.drawable.china)
        var country7:CountryModel= CountryModel("Chile","0",R.drawable.chile)
        CountryList.add(country1)
        CountryList.add(country3)
        CountryList.add(country2)
        CountryList.add(country4)
        CountryList.add(country5)
        CountryList.add(country6)
        CountryList.add(country7)
        return CountryList
    }

    //  Modifies Toast Background and Text Color, color scheme defined in custom_toast_layout.xml

    private fun toggleDisplay(country: CountryModel) {
        val message = "Country: ${country.name} \n Wins: ${country.cupsWins}"

        val inflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_container))

        val toastText: TextView = layout.findViewById(R.id.toast_text)
        toastText.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }

}