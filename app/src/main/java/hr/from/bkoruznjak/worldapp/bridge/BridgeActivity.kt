package hr.from.bkoruznjak.worldapp.bridge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.root.BaseMapActivity
import kotlinx.android.synthetic.main.activity_bridge.*

class BridgeActivity : AppCompatActivity(), BaseMapActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mapViewBridge.onCreate(savedInstanceState)
        supportActionBar?.let {
            it.title = getString(getTitleResource())
        }
        setupMap()
    }

    override fun onResume() {
        super.onResume()
        mapViewBridge.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapViewBridge.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapViewBridge.onDestroy()
    }

    override fun setupMap() {
        mapViewBridge.getMapAsync { map -> println("bridge map is loaded") }
    }

    override fun getTitleResource(): Int = R.string.title_bridge

    override fun getLayout(): Int = R.layout.activity_bridge
}
