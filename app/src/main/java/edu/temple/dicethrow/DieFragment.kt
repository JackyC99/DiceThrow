package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {


    val DIESIDE = "sidenumber"

    val PREV = "previousroll"

    var Current = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    lateinit var ViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }

        ViewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModel.getCurrentRoll().observe(viewLifecycleOwner) {
            dieTextView.text = it.toString()
        }

        if (ViewModel.getCurrentRoll().value == null) {
            ViewModel.rollDie()
        }
    }

}


