package edu.cuesta.ashley_bruce1.aminoacids

/*
AADetailViewModel.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*


class AADetailViewModel () : ViewModel() {

    private val aminoAcids = AminoAcidListViewModel()
    lateinit var currentAminoAcid : AminoAcid



    fun loadAminoAcid (theID : Int) {
        currentAminoAcid = aminoAcids.get(theID)
    }

}