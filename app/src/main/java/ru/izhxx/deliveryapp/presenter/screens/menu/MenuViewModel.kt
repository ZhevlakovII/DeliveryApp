package ru.izhxx.deliveryapp.presenter.screens.menu

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.domain.usecase.banners.GetLocalBannersUseCase
import ru.izhxx.deliveryapp.domain.usecase.categories.GetLocalFoodCategoriesUseCase
import ru.izhxx.deliveryapp.domain.usecase.fooditem.GetLocalFoodItemsUseCase
import ru.izhxx.deliveryapp.presenter.common.StateHandler
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getLocalBannersUseCase: GetLocalBannersUseCase,
    private val getLocalFoodCategoriesUseCase: GetLocalFoodCategoriesUseCase,
    private val getLocalFoodItemsUseCase: GetLocalFoodItemsUseCase
) : ViewModel(), StateHandler<MenuState> {
    private val _state: MutableLiveData<MenuState> = MutableLiveData(MenuState.Loading)
    val state: LiveData<MenuState> = _state

    private val _selectedCategory = MutableLiveData<Int>()

    private val _banners: LiveData<List<Banner>> = getLocalBannersUseCase.invoke().asLiveData()
    private val _categories: LiveData<List<FoodCategory>> = getLocalFoodCategoriesUseCase.invoke().asLiveData()
    private val _foodItems: LiveData<List<FoodItem>> = getLocalFoodItemsUseCase.invoke().asLiveData()

    override fun obtainState(event: MenuEvent) {
        when (_state.value) {
            is MenuState.Display -> reduce(event)
            else -> throw NotImplementedError("Unknown state")
        }
    }

    override fun obtainState() {
        when(_state.value) {
            is MenuState.Loading -> loadItems()
            is MenuState.Error -> loadItems()
            else -> throw NotImplementedError("Unknown state")
        }
    }

    private fun reduce(event: MenuEvent) {
        when (event) {
            is MenuEvent.EnterScreen -> loadItems()
            is MenuEvent.ChangeCategory -> changeCategory(event.categoryId)
        }
    }

    private fun changeCategory(categoryId: Int) {
        _state.postValue(MenuState.Loading)

        _selectedCategory.postValue(
            _categories.value?.find { it.categoryId == categoryId }?.categoryId
                ?: _categories.value!![0].categoryId)

        val selectedFoods = arrayListOf<FoodItem>()

        _foodItems.value!!.forEach { foodItem ->
            if (foodItem.selectedCategoryId == categoryId)
                selectedFoods.add(foodItem)
        }

        _state.postValue(MenuState.Display(
            banners = _banners.value!!,
            categories = _categories.value!!,
            selectedCategoryId = _selectedCategory.value!!,
            food = selectedFoods
        ))
    }

    private fun loadItems() {
        viewModelScope.launch {
            _state.postValue(MenuState.Loading)
            if (
                _banners.value.isNullOrEmpty() ||
                _categories.value.isNullOrEmpty() ||
                _foodItems.value.isNullOrEmpty()
            ) {
                _state.postValue(MenuState.Error)
            } else {
                if (_selectedCategory.value == 0 || _selectedCategory.value == null) {
                    _selectedCategory.value = _categories.value!![0].categoryId
                }

                val selectedFoods = arrayListOf<FoodItem>()

                _foodItems.value!!.forEach { foodItem ->
                    if (foodItem.selectedCategoryId == _selectedCategory.value)
                        selectedFoods.add(foodItem)
                }

                _state.postValue(MenuState.Display(
                    banners = _banners.value!!,
                    categories = _categories.value!!,
                    selectedCategoryId = _selectedCategory.value!!,
                    food = selectedFoods
                ))
            }
        }
    }

    fun changeState(state: MenuState) {
        _state.postValue(state)
    }
}