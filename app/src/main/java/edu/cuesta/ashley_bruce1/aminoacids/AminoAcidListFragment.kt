package edu.cuesta.ashley_bruce1.aminoacids

/*
AminoAcidListFragment.kt
Final Project | CIS 207
Cuesta College | R. Scovil
Ashley Bruce | ashley_bruce1@my.cuesta.edu
 */

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import android.util.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "AAListFragment"

class AminoAcidListFragment : Fragment() {

    interface Callbacks {
        fun onAminoAcidSelected (aminoAcidId: Int)
    }

    private var callbacks : Callbacks? = null

    private lateinit var aaRecyclerView: RecyclerView
    private var adapter : AAAdapter? = null

    val aminoAcidListViewModel : AminoAcidListViewModel by lazy {
        ViewModelProviders.of(this).get(AminoAcidListViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Amino Acids")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aa_list, container, false)
        aaRecyclerView = view.findViewById(R.id.aa_recycler_view) as RecyclerView
        aaRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    private inner class AAHolder (view : View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var aminoAcid: AminoAcid

        private val titleTextView : TextView = itemView.findViewById(R.id.list_aa_name)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind (aminoAcid : AminoAcid) {
            this.aminoAcid = aminoAcid
            titleTextView.text = this.aminoAcid.name

        }

        override fun onClick (v : View) {
            callbacks?.onAminoAcidSelected(aminoAcid.id)
        }
    }

    private inner class AAAdapter (var aminoAcids : List<AminoAcid>)
        : RecyclerView.Adapter<AAHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AAHolder {
            val view = layoutInflater.inflate(R.layout.list_item_aa, parent, false)
            return AAHolder(view)
        }

        override fun getItemCount() = aminoAcids.size

        override fun onBindViewHolder(holder: AAHolder, position: Int) {
            val aminoAcid = aminoAcids[position]
            holder.bind(aminoAcid)
        }
    }

    private fun updateUI() {
        val aminoAcids = aminoAcidListViewModel.aminoAcids
        adapter = AAAdapter(aminoAcids)
        aaRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance () : AminoAcidListFragment {
            return AminoAcidListFragment()
        }
    }

}