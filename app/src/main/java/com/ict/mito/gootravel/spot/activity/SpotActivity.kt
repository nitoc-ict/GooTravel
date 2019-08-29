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

class SpotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot)
        bottom_appbar.replaceMenu(R.menu.radar_bottomappbar_menu)

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
