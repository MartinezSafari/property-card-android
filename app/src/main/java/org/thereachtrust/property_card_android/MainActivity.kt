package org.thereachtrust.property_card_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener
{

    val titles : MutableList<String> = mutableListOf()
    val descriptions : MutableList<String> = mutableListOf()

    val beds = intArrayOf(5, 2, 2)
    val baths = intArrayOf(4, 1, 2)
    val years = intArrayOf(1997, 2016, 2002)

    fun populateDate(){
        descriptions.add("An opportunity to live in one of the" +
                " most sought-after areas of the Southern Suburbs in a " +
                "brand new development, perfectly located within a quiet, leafy pocket of Wynberg Upper. Not only is it just a 10 minute walk to Wolfe Street in Chelsea Village with its charming eateries, boutiques and art galleries; this location offers easy access to both the M3 and Main Road. One Malton is just a stone's throw away from some of Cape Town's top schools, convenient public transport and popular shopping centres.")
        descriptions.add("Be part of a brand that is going global.\n" +
                "Get pre-approved on a bond and join us for a 24 Hour Showday, with a complimentary stay at BlackBrick Cape Town Hotel to experience what life could be like for you or your tenants.\n" +
                "Situated at 8 St George’s Mall, BlackBrick Club - A Part Club A Part Hotel, is an Art Deco heritage building packed with facilities in the heart of the Historic CBD just 950m from The V&A Waterfront.\n" +
                "Get your hands on some of the last remaining units.\n")
        descriptions.add("Exclusively presenting this beautiful 2-bedroom home in the most sought after pocket of Observatory.\n" +
                "If you are looking for a more serene and peaceful part of Observatory, look no further, this fantastic 2-bedroom, 2-bathroom home is perfectly located away from the hustle and bustle of Lower Main and Main Road, but close enough to benefit from the Observatory lifestyle and it's amazing people.\n" +
                "Secure parking is available to rent for R300p/m two doors down.\n" +
                "Wooden floors flow though the home, creating a wonderfully classic Observatory home feel, which tie into the open-plan living/dining room & kitchen, complete with a breakfast bar, built in oven & hob in the old kitchen fireplace, wooden countertops & plumbing for 2 appliances.\n")

        titles.add("R 2 025 000")
        titles.add("R 1 345 000")
        titles.add("R 1 705 000")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateDate()

        card1_title_textView.text= titles[0]
        card2_title_textView.text= titles[1]
        card3_title_textView.text= titles[2]

        card_1.setOnClickListener(this)
        card_2.setOnClickListener(this)
        card_3.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent (this, DetailsActivity::class.java)


        var index = 0

        when(view!!.id){
            R.id.card_1 -> index=0
            R.id.card_2 -> index=1
            R.id.card_3 -> index=2
        }

        val extras = Bundle()
        extras.putInt("bedsKeyd", beds[index])
        extras.putInt("batsKeyd", baths[index])
        extras.putInt("yearsKeyd", years[index])
        extras.putString("titleKeyd", titles[index])
        extras.putString("descriptionKeyd", descriptions[index])

        intent.putExtras(extras)
        startActivity(intent)

    }
}