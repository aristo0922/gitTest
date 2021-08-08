package kr.ac.jetpack.showpeep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.ac.jetpack.showpeep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var homeFragment: HomeFragment
    private lateinit var findFragment : FindFragment
    private lateinit var calendarFragment: CalendarFragment

    private var activityMainBinding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Activity Main Binding
        // 자동 완성 된 액티비티 메인 바인딩 클래스 가져옴.
        val binding = ActivityMainBinding.inflate(layoutInflater)

        activityMainBinding = binding
        //바인딩과 연결
        setContentView(activityMainBinding!!.root)

//        bottom_nav_view.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        activityMainBinding?.bottomNavView?.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, homeFragment).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)

        return true
    }

    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.nav_calendar ->{
                calendarFragment = CalendarFragment.newInstance()

                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, calendarFragment).commit()
            }
            R.id.nav_home ->{
                homeFragment = HomeFragment.newInstance()

                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, homeFragment).commit()
            }
            R.id.nav_finding ->{
                findFragment = FindFragment.newInstance()

                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, findFragment).commit()
            }
        }
        true
    }
}