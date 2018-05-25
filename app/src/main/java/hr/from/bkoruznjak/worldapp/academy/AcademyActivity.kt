package hr.from.bkoruznjak.worldapp.academy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.root.BaseMapActivity
import kotlinx.android.synthetic.main.activity_academy.*

class AcademyActivity : AppCompatActivity(), BaseMapActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mapViewAcademy.onCreate(savedInstanceState)
        supportActionBar?.let {
            it.title = getString(getTitleResource())
        }
        setupMap()
    }

    override fun onResume() {
        super.onResume()
        mapViewAcademy.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapViewAcademy.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapViewAcademy.onDestroy()
    }

    override fun setupMap() {
        mapViewAcademy.getMapAsync { _ -> println("academy map is loaded") }
    }

    override fun getTitleResource(): Int = R.string.title_academy

    override fun getLayout(): Int = R.layout.activity_academy
}
