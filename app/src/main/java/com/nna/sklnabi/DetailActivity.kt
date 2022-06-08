package com.nna.sklnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.nna.sklnabi.databinding.ActivityDetilBinding
import com.nna.sklnabi.databinding.FragmentNabiBinding
import com.nna.sklnabi.model.ResponseItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetilBinding

    companion object {
        const val DATA = "n"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseItem>(DATA)

//        binding.btnBack.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }

        binding.tvNamanabi.text = data?.nama
        binding.tvTinggal.text = data?.tempat
        binding.tvKelahiran.text = data?.tpKelahiran
        binding.tvUmur.text = data?.usia
        binding.tvDeskripsi.text = data?.deskripsi
        binding.imgNabii.load(data?.avatar)
    }
}