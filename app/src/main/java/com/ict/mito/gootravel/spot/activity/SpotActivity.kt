package com.ict.mito.gootravel.spot.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PermissionChecker
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpotActivity : AppCompatActivity(R.layout.activity_spot) {
    private val viewmodel: SpotViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottom_appbar.replaceMenu(R.menu.radar_bottomappbar_menu)
        setSupportActionBar(toolbar)

        val resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        val requestCode = 10001
        if (resultCode != ConnectionResult.SUCCESS) {
            GoogleApiAvailability.getInstance().getErrorDialog(
                this,
                resultCode,
                requestCode
            ).show()
        }

        // API 23 or more?
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermission()
        }

        viewmodel.syncSpotData()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkPermission() {
        if (
            PermissionChecker.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                0
            )
        }
    }
}
