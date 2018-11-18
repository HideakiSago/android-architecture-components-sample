package sago.aac_sample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*
import sago.aac_sample.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button.setOnClickListener {
            fragmentManager!!.beginTransaction()
                    .replace(R.id.container, InputFragment.newInstance())
                    .commitNow()
        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getValue().observe({ lifecycle }) {
            message.text = it
        }
    }

}
