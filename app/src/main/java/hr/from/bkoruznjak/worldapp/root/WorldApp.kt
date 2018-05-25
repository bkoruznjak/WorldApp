package hr.from.bkoruznjak.worldapp.root

import android.app.Application
import com.eegeo.mapapi.EegeoApi

class WorldApp : Application() {

    override fun onCreate() {
        super.onCreate()

        EegeoApi.init(this, AppConstants.WRLD_API_KEY)
    }
}