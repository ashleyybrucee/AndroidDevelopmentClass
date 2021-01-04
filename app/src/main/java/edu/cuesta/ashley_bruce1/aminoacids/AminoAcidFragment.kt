package edu.cuesta.ashley_bruce1.aminoacids

/*
AminoAcidFragment.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import java.util.*

private const val TAG = "AminoAcidFragment"
private const val ARG_AA_ID = "amino_acid_id"

class AminoAcidFragment : Fragment () {

    private lateinit var aminoAcid : AminoAcid

    private lateinit var aaName : TextView
    private lateinit var aaAbbrev : TextView
    private lateinit var aaSideChain : TextView
    private lateinit var aapKa : TextView
    private lateinit var structurePicture : ImageView

    private val aaDetailViewModel: AADetailViewModel by lazy {
        ViewModelProviders.of(this).get(AADetailViewModel::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aminoAcid = AminoAcid()
        val aminoAcidId : Int = arguments?.getSerializable(ARG_AA_ID) as Int
        aaDetailViewModel.loadAminoAcid(aminoAcidId)
        aminoAcid = aaDetailViewModel.currentAminoAcid
    }

    companion object {
        fun newInstance (aminoAcidId: Int) : AminoAcidFragment {
            val args = Bundle().apply {
                putSerializable(ARG_AA_ID, aminoAcidId)
            }
            return AminoAcidFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aminoacid, container, false)

        aaName = view.findViewById(R.id.amino_acid_name)
        aaAbbrev = view.findViewById(R.id.abbreviation)
        aaSideChain = view.findViewById(R.id.side_chain)
        aapKa = view.findViewById(R.id.pKa)
        structurePicture = view.findViewById(R.id.aa_picture)

        updateUI()

        return view
    }


    private fun updateUI() {
        aaName.text = aminoAcid.name
        aaAbbrev.text = "Abbreviations: " + aminoAcid.letter + " || " + aminoAcid.abbrev
        aaSideChain.text = "Side Chain: " + aminoAcid.sideChain

        if (aminoAcid.pKa == 0.0) {
            aapKa.text = "No pKa data available for this amino acid"
        }
        else {
            aapKa.text = "pKa: " + aminoAcid.pKa.toString()
        }
        structurePicture.setImageResource(aminoAcid.image)

    }


}