package ru.izhxx.deliveryapp.presenter.screens.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.izhxx.deliveryapp.presenter.common.StateHandler
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(

) : ViewModel(), StateHandler<MenuState> {
    private val _state: MutableLiveData<MenuState> = MutableLiveData(MenuState.Loading)
    val state: LiveData<MenuState> = _state

    private val _content = arrayListOf<Any>()

    override fun obtainState() {
        when (_state.value) {
            is MenuState.Loading -> loadItems()
            is MenuState.Error -> {}
            is MenuState.Display -> {}
            else -> throw NotImplementedError("Unknown state")
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            _state.postValue(MenuState.Loading)
        }
    }

    fun changeState(state: MenuState) {
        _state.postValue(state)
    }
}