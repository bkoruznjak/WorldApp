package hr.from.bkoruznjak.worldapp.academy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hr.from.bkoruznjak.worldapp.R
import hr.from.bkoruznjak.worldapp.root.BaseMapActivity

class AcademyActivity : AppCompatActivity(), BaseMapActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        supportActionBar?.let {
            it.title = getString(getTitleResource())
        }
    }

    override fun getTitleResource(): Int = R.string.title_academy

    override fun getLayout(): Int = R.layout.activity_academy
}
