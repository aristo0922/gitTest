package kr.ac.jetpack.tutorial

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS, MINUS
}

class NumberModelView : ViewModel() {
    companion object{
        const val TAG: String ="로그"
    }
    // mutable live dta - 수정 가능
    //live data - 값 변동 x
    private val _currentValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
        get() = _currentValue




    init { // 초기값
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.PLUS->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}