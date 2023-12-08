package com.growthook.aos.presentation.insight.actionplan

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.growthook.aos.databinding.ActivityAddActionplanBinding
import com.growthook.aos.util.base.BaseActivity

class AddActionplanActivity :
    BaseActivity<ActivityAddActionplanBinding>({ ActivityAddActionplanBinding.inflate(it) }) {
    private var _editTextAdapter: AddActionplanAdapter? = null
    private val viewModel by viewModels<AddActionplanViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foldInsightContent()
        initEditTextAdapter()
        observeActionplanList()
        observeButtonEnabled()
        clickPlusBtn()
    }

    private fun foldInsightContent() {
        binding.clAddActionplanCollapse.setOnClickListener {
            binding.clAddActionplanCollapse.visibility = View.GONE
            binding.clAddActionplanExpanded.visibility = View.VISIBLE
        }
        binding.clAddActionplanExpanded.setOnClickListener {
            binding.clAddActionplanExpanded.visibility = View.GONE
            binding.clAddActionplanCollapse.visibility = View.VISIBLE
        }
    }

    private fun initEditTextAdapter() {
        _editTextAdapter = AddActionplanAdapter(
            list = viewModel.actionplanList.value ?: mutableListOf(""),
            onAddItem = { viewModel.addItem("") },
            onEditTextChanged = { position, text -> viewModel.updateItem(position, text) },
        )
        binding.rcvAddActionplanEdittext.adapter = _editTextAdapter
    }

    private fun clickPlusBtn() {
        binding.ivAddActionplanPlus.setOnClickListener {
            _editTextAdapter?.addItem("")
        }
    }

    private fun observeActionplanList() {
        viewModel.actionplanList.observe(this) {
            if (it.isNotEmpty()) {
                viewModel.isButtonEnabled.value = true
            }
        }
    }

    private fun observeButtonEnabled() {
        viewModel.isButtonEnabled.observe(this) { isEnabled ->
            if (isEnabled == true) {
                binding.tvAddActionplanComplete.setTextColor(Color.parseColor("#23B877"))
            } else {
                binding.tvAddActionplanComplete.setTextColor(Color.parseColor("#6B6E82"))
            }
        }
    }
}
