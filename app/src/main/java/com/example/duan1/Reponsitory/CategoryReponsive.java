package com.example.duan1.Reponsitory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.duan1.Model.CategoryModel;
import com.example.duan1.retrofit.ApiBanHang;
import com.example.duan1.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryReponsive {
    private ApiBanHang apiBanHang;

    public CategoryReponsive() {
        apiBanHang = RetrofitClient.getRetrofit().create(ApiBanHang.class);
    }
    public MutableLiveData<CategoryModel> getCategory(){
        MutableLiveData<CategoryModel> data = new MutableLiveData<>();
        apiBanHang.getCategory().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Log.i("TEST", t.getMessage());
                data.setValue(null);

            }
        });
        return data;
    }
}
