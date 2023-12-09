package com.growthook.aos.presentation.insight.noactionplan

import android.os.Bundle
import com.growthook.aos.databinding.ActivityNoActionplanInsightBinding
import com.growthook.aos.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NoActionplanInsightActivity :
    BaseActivity<ActivityNoActionplanInsightBinding>({ ActivityNoActionplanInsightBinding.inflate(it) }) {
    private lateinit var insightId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getIntentInsightId()
        setClickListeners()
    }

    private fun setClickListeners() {
        clickMenu()
        clickBackBtn()
    }

    private fun getIntentInsightId() {
        insightId = intent.getIntExtra("insightId", 0).toString()
        Timber.d("인사이트 id $insightId")
    }

    private fun clickMenu() {
        binding.ivNoactionInsightToolbarMenu.setOnClickListener {
            val bottomSheetDialog = InsightMenuBottomsheet()
            bottomSheetDialog.show(supportFragmentManager, "show")
        }
    }

    private fun clickBackBtn() {
        binding.ivNoactionInsightBack.setOnClickListener {
            finish()
        }
    }
}
