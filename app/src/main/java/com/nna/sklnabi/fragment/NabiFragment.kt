package com.nna.sklnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nna.sklnabi.R
import com.nna.sklnabi.adapter.AdapterNabi
import com.nna.sklnabi.databinding.ActivityMainBinding
import com.nna.sklnabi.databinding.FragmentNabiBinding
import com.nna.sklnabi.model.ResponseItem
import com.nna.sklnabi.network.RetrofitInterface
import com.nna.sklnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NabiFragment : Fragment() {

    private lateinit var binding : FragmentNabiBinding
    private lateinit var nabiAdapter: AdapterNabi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNabiBinding.inflate(inflater,container,false)

        nabiAdapter = AdapterNabi()
        binding.rvMain.adapter = nabiAdapter
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.layoutManager = GridLayoutManager(context, 2)

        val call = RetrofitService.getService().getDataNabi()
        call.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> nabiAdapter.addData(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return binding.root
    }

}