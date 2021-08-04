package kr.ac.jetpack.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), View.OnClickListener{
    companion object {
        const val TAG:String = "로그"
    }

    lateinit var myNumberViewModel: NumberModelView

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel= ViewModelProvider(this).get(NumberModelView::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - MyNumberViewModel - crrentValue 라이브데이터 값 변경 : $it")
            number_textview.text = it.toString()
        })

        plusbtn.setOnClickListener(this)
        minus_button.setOnClickListener(this)
    }

    override fun onClick(view: View?){
        val userInput = userinput_editText.text.toString().toInt()

        when(view){
            plusbtn->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, userInput)
            minus_button->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}