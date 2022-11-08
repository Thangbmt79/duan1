package com.example.duan1.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.duan1.Model.CategoryModel;
import com.example.duan1.Reponsitory.CategoryReponsive;

public class HomeViewModel extends ViewModel {
    private CategoryReponsive categoryReponsive;

    public HomeViewModel() {
        categoryReponsive = new CategoryReponsive();
    }
    public MutableLiveData<CategoryModel> categoryModelMutableLiveData(){
        return categoryReponsive.getCategory();
    }
}
