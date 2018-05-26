package hr.from.bkoruznjak.worldapp.bridge

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eegeo.mapapi.EegeoMap
import com.eegeo.mapapi.geometry.LatLng
import com.eegeo.mapapi.markers.Marker
import com.eegeo.mapapi.markers.MarkerOptions
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.root.AppConstants
import hr.from.bkoruznjak.worldapp.root.AppConstants.BRIDGE_ANIMATION_DURATION_IN_MILLIS
import hr.from.bkoruznjak.worldapp.root.BaseMapActivity
import kotlinx.android.synthetic.main.activity_bridge.*

class BridgeActivity : AppCompatActivity(), BaseMapActivity {

    private var carMarker: Marker? = null

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
        mapViewBridge.getMapAsync { map ->
            startMarkerAnimation(map)
        }
    }

    private fun startMarkerAnimation(map: EegeoMap) {
        val latValueHolder = PropertyValuesHolder.ofFloat("LAT", AppConstants.BRIDGE_MARKER_START_LAT.toFloat(), AppConstants.BRIDGE_MARKER_END_LAT.toFloat())
        val longValueHolder = PropertyValuesHolder.ofFloat("LONG", AppConstants.BRIDGE_MARKER_START_LONG.toFloat(), AppConstants.BRIDGE_MARKER_END_LONG.toFloat())
        val animator = ObjectAnimator.ofPropertyValuesHolder(latValueHolder, longValueHolder)
        animator.duration = BRIDGE_ANIMATION_DURATION_IN_MILLIS
        animator.addUpdateListener { animation ->
            carMarker?.let {
                map.removeMarker(it)
            }
            carMarker = map.addMarker(MarkerOptions()
                    .position(LatLng((
                            (animation.getAnimatedValue("LAT") as Float).toDouble()),
                            (animation.getAnimatedValue("LONG") as Float).toDouble()))
                    .elevation(AppConstants.BRIDGE_MARKER_ELEVATION)
                    .iconKey(AppConstants.BRIDGE_MARKER_ICON)
                    .labelText(AppConstants.BRIDGE_MARKER_TEXT))
        }
        animator.start()
    }

    override fun getTitleResource(): Int = R.string.title_bridge

    override fun getLayout(): Int = R.layout.activity_bridge
}
