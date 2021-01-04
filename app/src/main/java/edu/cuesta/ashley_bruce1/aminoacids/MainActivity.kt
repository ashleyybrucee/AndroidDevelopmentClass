package edu.cuesta.ashley_bruce1.aminoacids

/*
MainActivity.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), AminoAcidListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = AminoAcidListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }

    }

    override fun onAminoAcidSelected(aminoAcidId: Int) {
        val fragment = AminoAcidFragment.newInstance(aminoAcidId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }

}