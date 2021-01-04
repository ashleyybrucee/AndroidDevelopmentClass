package edu.cuesta.ashley_bruce1.aminoacids

/*
AminoAcid.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

data class AminoAcid(
    val id: Int = 0,
    var name: String = "",
    var letter: String = "",
    var abbrev: String = "",
    var sideChain: String = "",
    var pKa: Double = 0.0,
    var image : Int = 0
)