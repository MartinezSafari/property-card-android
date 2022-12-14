package org.thereachtrust.property_card_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        backButton.setOnClickListener {
            finish()
        }

        val intent= intent
        val extras= intent.extras


        val title= extras!!.getString("titleKey")
        titleTextView.text= title

        val description= extras.getString("descriptionKey")
        descriptionTextView.text= description

        val beds= extras.getInt("bedsKey")
        bedTextView.text= beds.toString()

        val bats= extras.getInt("batsKey")
        bathTextView.text= bats.toString()

        val years= extras.getInt("yearsKey")
        yearTextView.text= years.toString()

        val images= extras.getIntegerArrayList("imagesKey")

        var index = 0
        myImageView.setImageResource(images!![index])

        myImageView.setOnClickListener{
            index ++
            if(index == images.size){
                index = 0
                myImageView.setImageResource(images[index])
            }

        }





    }
}