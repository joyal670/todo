package com.mytodo.mytodo.ui.main.home.activity

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mytodo.mytodo.R
import com.mytodo.mytodo.base.BaseActivity
import com.mytodo.mytodo.databinding.ActivityDashboardBinding
import com.mytodo.mytodo.listeners.ActivityListener
import com.mytodo.mytodo.ui.main.sidemenu.fragments.*
import com.mytodo.mytodo.utils.replaceFragment
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
import java.util.*
import kotlin.system.exitProcess


class DashboardActivity : BaseActivity<ActivityDashboardBinding>(), ActivityListener {
    var fragment: Fragment? = null
    var fragmentClass: Class<*>? = null
    private var doubleBackToExitPressedOnce = false

    override val layoutId: Int
        get() = R.layout.activity_dashboard
    override val setToolbar: Boolean
        get() = false
    override val hideStatusBar: Boolean
        get() = false

    override fun getViewBinging(): ActivityDashboardBinding = ActivityDashboardBinding.inflate(
        layoutInflater
    )

    override fun initData() {

    }

    override fun fragmentLaunch() {

    }

    override fun setupUI() {
        val menuItems = ArrayList<MenuItem>()
        menuItems.add(MenuItem("Dashboard", R.drawable.ic_dashboard))
        menuItems.add(MenuItem("My Task", R.drawable.ic_task))
        menuItems.add(MenuItem("Calender", R.drawable.ic_schedule))
        menuItems.add(MenuItem("Notifications", R.drawable.ic_chat))
        menuItems.add(MenuItem("About", R.drawable.ic_information))
        menuItems.add(MenuItem("Logout", R.drawable.ic_logout))
        binding.navigationDrawer.menuItemList = menuItems

        fragmentClass = fragment_dashboard::class.java

        binding.navigationDrawer.setAppbarTitleTV("Dashboard")
        binding.navigationDrawer.secondaryMenuItemTextSize = 1F
        binding.navigationDrawer.primaryMenuItemTextSize = 2F
        binding.navigationDrawer.menuIconSize = 0.5F

        try {
            fragment = (fragmentClass as Class<*>).newInstance() as Fragment
        } catch (ex: Exception) {
            Toast.makeText(this, "" + ex.message, Toast.LENGTH_SHORT).show()
        }

        if (fragment != null) {
            val fragmentManager: FragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.main_container, fragment!!).commit()
        }

        binding.navigationDrawer.drawerListener = object : SNavigationDrawer.DrawerListener {
            override fun onDrawerOpening() {
            }

            override fun onDrawerClosing() {
                try {
                    fragment = (fragmentClass as Class<*>).newInstance() as Fragment
                } catch (ex: Exception) {
                    Toast.makeText(this@DashboardActivity, "" + ex.message, Toast.LENGTH_SHORT)
                        .show()
                }
                if (fragment != null) {
                    val fragmentManager: FragmentManager = supportFragmentManager
                    fragmentManager.beginTransaction()
                        .setCustomAnimations(
                            android.R.animator.fade_in,
                            android.R.animator.fade_out
                        )
                        .replace(R.id.main_container, fragment!!).commit()
                }
            }

            override fun onDrawerOpened() {
            }

            override fun onDrawerClosed() {
            }

            override fun onDrawerStateChanged(newState: Int) {
            }
        }
        binding.navigationDrawer.onMenuItemClickListener = SNavigationDrawer.OnMenuItemClickListener { position ->
            when (position) {
                0 -> {
                    fragmentClass = fragment_dashboard::class.java
                }
                1 -> {
                    fragmentClass = fragment_mytask::class.java
                }
                2 -> {
                    fragmentClass = fragment_calender::class.java
                }
                3->{
                    fragmentClass = fragment_notification::class.java
                }
                4->{
                    fragmentClass = fragment_about::class.java
                }
                5->{

                }
            }
        }

    }


    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

    }

    override fun navigateToFragment(fragment: Fragment) {
        replaceFragment(fragment = fragment, addToBackStack = true)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        } else {

            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

            Timer().schedule(object : TimerTask() {
                override fun run() {
                    doubleBackToExitPressedOnce = false
                }
            }, 2000)

        }
    }

}