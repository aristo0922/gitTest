package kr.ac.jetpack.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.ac.jetpack.tutorial.databinding.ActivityMainBinding
import kr.ac.jetpack.tutorial.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    //
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment

    companion object {

        const val TAG: String = "로그"

    }

    private var activityMainBinding : ActivityMainBinding? = null

    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Activity Main Binding
        // 자동 완성 된 액티비티 메인 바인딩 클래스 가져옴.
        val binding = ActivityMainBinding.inflate(layoutInflater)

        activityMainBinding = binding
        //바인딩과 연결
        setContentView(activityMainBinding!!.root)


        // 레이아웃과 연결
        //setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

//        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        activityMainBinding?.bottomNav?.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()

    }


    // 바텀네비게이션 아이템 클릭 리스너 설정
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.menu_home -> {

                activityMainBinding?.mainActivityTextView?.text= "홈버튼 클릭되었다!"

                Log.d(TAG, "MainActivity - 홈버튼 클릭!")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                activityMainBinding?.mainActivityTextView?.text= "랭킹버튼 클릭되었다!"

                Log.d(TAG, "MainActivity - 랭킹버튼 클릭!")
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                activityMainBinding?.mainActivityTextView?.text= "랭킹버튼 클릭되었다!"

                Log.d(TAG, "MainActivity - 프로필버튼 클릭!")
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }

        true
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationItemSelected() called ")
//
//        when(item.itemId){
//            R.id.menu_home -> {
//                Log.d(TAG, "MainActivity - 홈버튼 클릭!")
//            }
//            R.id.menu_ranking -> {
//                Log.d(TAG, "MainActivity - 랭킹버튼 클릭!")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필버튼 클릭!")
//            }
//        }
//
//        return true
//    }


}
