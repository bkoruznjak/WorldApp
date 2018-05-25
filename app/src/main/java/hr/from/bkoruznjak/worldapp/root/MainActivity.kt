package hr.from.bkoruznjak.worldapp.root

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.constants.AppConstants.DESTINATION_CALIFORNIA_ACADEMY_OF_SCIENCES
import hr.from.bkoruznjak.worldapp.constants.AppConstants.DESTINATION_GOLDEN_GATE_BRIDGE
import kotlinx.android.synthetic.main.card_view_cali_academy.*
import kotlinx.android.synthetic.main.layout_card_view_golden_gate.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiate()
    }

    private fun initiate() {
        Glide.with(this).load(R.drawable.img_california_academy_of_sciences).into(imageViewCaliAcademyOfSciences)
        Glide.with(this).load(R.drawable.img_golden_gate_bridge).into(imageViewGoldenGateBridge)
        cardViewAcademy.setOnClickListener(this)
        cardViewGoldenGate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it) {
                cardViewAcademy -> goToDestination(DESTINATION_CALIFORNIA_ACADEMY_OF_SCIENCES)
                cardViewGoldenGate -> goToDestination(DESTINATION_GOLDEN_GATE_BRIDGE)
                else -> throw IllegalArgumentException("Destination Unknown")
            }
        }
    }

    private fun goToDestination(destinatioN_GOLDEN_GATE_BRIDGE: Int) {

    }
}
