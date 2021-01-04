package edu.cuesta.ashley_bruce1.aminoacids

/*
AminoAcidListViewModel.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import androidx.lifecycle.ViewModel
import java.util.*

class AminoAcidListViewModel : ViewModel() {

     val aminoAcids = mutableListOf<AminoAcid>(
        AminoAcid(1,"Alanine", "A", "Ala", "Hydrophobic", 0.0,
           R.drawable.alanine),
        AminoAcid(2,"Arginine", "R", "Arg", "Positive", 12.0,
           R.drawable.arginine),
        AminoAcid(3,"Asparagine", "N", "Asn", "Polar", 0.0,
           R.drawable.asparagine),
        AminoAcid(4,"Aspartate", "D", "Asp", "Negative", 4.4,
           R.drawable.aspartate),
        AminoAcid(5,"Cysteine", "C", "Cys", "Hydrophobic", 8.5,
           R.drawable.cysteine),
        AminoAcid(6,"Glutamate", "E", "Glu", "Negative", 4.4,
           R.drawable.glutamate),
        AminoAcid(7,"Glutamine", "Q", "Gln", "Polar", 0.0,
           R.drawable.glutamine),
        AminoAcid(8,"Glycine", "G", "Gly", "Hydrophobic", 0.0,
           R.drawable.glycine),
        AminoAcid(9,"Histidine", "H", "His", "Positive", 6.0,
           R.drawable.histidine),
        AminoAcid(10,"Isoleucine", "I", "Ile", "Hydrophobic", 0.0,
           R.drawable.isoleucine),
        AminoAcid(11,"Leucine", "L", "Leu", "Hydrophobic", 0.0,
           R.drawable.leucine),
        AminoAcid(12,"Lysine", "K", "Lys", "Positive", 10.0,
           R.drawable.lysine),
        AminoAcid(13,"Methionine", "M", "Met", "Hydrophobic", 0.0,
           R.drawable.methionine),
        AminoAcid(14,"Phenylalanine", "F", "Phe", "Hydrophobic", 0.0,
           R.drawable.phenylalanine),
        AminoAcid(15,"Proline", "P", "Pro", "Hydrophobic", 0.0,
           R.drawable.proline),
        AminoAcid(16,"Serine", "S", "Ser", "Polar", 0.0,
           R.drawable.serine),
        AminoAcid(17,"Threonine", "T", "Thr", "Polar", 0.0,
           R.drawable.threonine),
        AminoAcid(18,"Tryptophan", "W", "Trp", "Hydrophobic", 0.0,
           R.drawable.tryptophan),
        AminoAcid(19,"Tyrosine", "Y", "Tyr", "Polar", 10.0,
           R.drawable.tyrosine),
        AminoAcid(20,"Valine", "V", "Val", "Hydrophobic", 0.0,
           R.drawable.valine)

    )
   private fun random (): UUID {
      return UUID.randomUUID()
   }

   fun get (theID : Int): AminoAcid {
      for (aa in aminoAcids) {
         if (theID == aa.id)
            return aa
      }
      return AminoAcid()
   }



}