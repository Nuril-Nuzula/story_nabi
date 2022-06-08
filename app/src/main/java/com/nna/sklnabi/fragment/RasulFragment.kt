package com.nna.sklnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nna.sklnabi.R
import com.nna.sklnabi.adapter.AdapterNabi
import com.nna.sklnabi.adapter.AdapterRasul
import com.nna.sklnabi.databinding.FragmentRasulBinding

import com.nna.sklnabi.model.ResponseItem
import com.nna.sklnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    lateinit var adapters: AdapterRasul

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRasulBinding.inflate(inflater,container,false)

        adapters = AdapterRasul()
        binding.rvRasul.apply {
            adapter = adapters
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        val call = RetrofitService.getService().getDataRasul()

        call.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                val list = response.body()!!
                list.let { it.let { it1 -> adapters.addData(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return binding.root
    }

}