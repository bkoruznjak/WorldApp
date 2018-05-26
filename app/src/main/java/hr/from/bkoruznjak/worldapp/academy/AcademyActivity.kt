package hr.from.bkoruznjak.worldapp.academy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import com.eegeo.indoors.IndoorMapView
import com.eegeo.mapapi.EegeoMap
import com.eegeo.mapapi.geometry.LatLng
import com.eegeo.mapapi.markers.MarkerOptions
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_INDOOR_ID
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_MARKER_FLOOR
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_MARKER_ICON
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_MARKER_LAT
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_MARKER_LONG
import hr.from.bkoruznjak.worldapp.root.AppConstants.ACADEMY_MARKER_TEXT
import hr.from.bkoruznjak.worldapp.root.BaseMapActivity
import kotlinx.android.synthetic.main.activity_academy.*

class AcademyActivity : AppCompatActivity(), BaseMapActivity {
    lateinit var map: EegeoMap
    lateinit var academyIndoorMap: IndoorMapView

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
        mapViewAcademy.getMapAsync { map ->
            this.map = map
            val uiContainer = findViewById<RelativeLayout>(R.id.eegeo_ui_container)
            academyIndoorMap = IndoorMapView(mapViewAcademy, uiContainer, map)
            map.addOnIndoorEnteredListener { userEnteredLocation(map.activeIndoorMap.id) }
        }
    }

    private fun userEnteredLocation(id: String?) {
        id?.let {
            when (it) {
                ACADEMY_INDOOR_ID -> addIndoorMarker(it,
                        ACADEMY_MARKER_LAT,
                        ACADEMY_MARKER_LONG,
                        ACADEMY_MARKER_FLOOR,
                        ACADEMY_MARKER_TEXT,
                        ACADEMY_MARKER_ICON)
            }
        }
    }

    private fun addIndoorMarker(indoorId: String, lat: Double, long: Double, floorId: Int, text: String, iconKey: String) {
        map.addMarker(MarkerOptions().position(LatLng(lat, long))
                .indoor(indoorId, floorId)
                .iconKey(iconKey)
                .labelText(text))
    }

    override fun getTitleResource(): Int = R.string.title_academy

    override fun getLayout(): Int = R.layout.activity_academy
}
