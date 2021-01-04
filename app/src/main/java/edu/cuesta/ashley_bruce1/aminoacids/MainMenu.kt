package edu.cuesta.ashley_bruce1.aminoacids

/*
MainMenu.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainMenu : AppCompatActivity() {

    private lateinit var aminoAcidButton : Button
    private lateinit var aboutButton : Button
    private lateinit var aboutAuthor : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        aminoAcidButton = findViewById(R.id.show_amino_acids)
        aboutButton = findViewById(R.id.about_button)
        aboutAuthor = findViewById(R.id.about_author)
        aboutAuthor.visibility = View.GONE


        aminoAcidButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        aboutButton.setOnClickListener {

            if (aboutAuthor.visibility == View.GONE)
                aboutAuthor.visibility = View.VISIBLE
            else
                aboutAuthor.visibility = View.GONE
        }

    }


}