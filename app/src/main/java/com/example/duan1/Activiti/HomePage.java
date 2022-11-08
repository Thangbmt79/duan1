package com.example.duan1.Activiti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.duan1.Adapter.ViewPagerAdapter;
import com.example.duan1.Model.CategoryModel;
import com.example.duan1.R;
import com.example.duan1.ViewModel.HomeViewModel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    //    ArrayList<Product> lstDaxem;
//    public ArrayList<Product> lstNoibat, lstDienthoai, lstQuanao, lstNhacua, lstSach, lstLamdep;
//    List<Category> lstBtnNoibat, lstBtnTimkiem;
//    List<Category2> lstDanhmuc;
    LinearLayout layoutDoraemon;
    Button search, dienThoai, quanAo, nhaCua, sach, lamDep;
    ImageButton danhmuc;
    ViewPager viewPager;
    ProgressBar loadingView, loadingViewNoibat;
    //    SwipeRefreshLayout swipeRefreshLayout;
//    public DatabaseReference reference, refDaxem;
//    public Query refDienthoai, refQuanao, refNhacua, refLamdep, refSach;
    TextView xemthemYeuThich, xemthemNoiBat, xemthemDanhmuc;
    //    FirebaseAuth mAuth;
    Random rd;
    Intent intent;
    //jdbsvkhsdvdskvskdvnkdsvnksd



    //View Model
    HomeViewModel homeViewModel;
    CategoryModel categoryModel;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 2500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 4000; // time in milliseconds between successive task executions.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        xemthemYeuThich = root.findViewById(R.id.home_daxem_xemthem);
//        xemthemNoiBat = root.findViewById(R.id.home_noibat_xemthem);
        xemthemDanhmuc = findViewById(R.id.home_danhmuc_xemthem);
        search = findViewById(R.id.home_search);
//        swipeRefreshLayout = root.findViewById(R.id.refreshLayout);
        dienThoai = findViewById(R.id.btn_dienthoai);
        quanAo = findViewById(R.id.btn_thoitrang);
        nhaCua = findViewById(R.id.btn_nhacua);
        sach = findViewById(R.id.btn_sach);
        lamDep = findViewById(R.id.btn_lamdep);
        danhmuc = findViewById(R.id.home_btn_danhmuc);
        viewPager = findViewById(R.id.viewPager);
//        loadingView = root.findViewById(R.id.loading_view);
//        loadingViewNoibat = root.findViewById(R.id.loading_noibat);
//        layoutDoraemon = root.findViewById(R.id.layout_doraemon);

        initData();
//        =====================================================================================================================


        setViewPager();

        search.setOnClickListener(this);
        dienThoai.setOnClickListener(this);
        nhaCua.setOnClickListener(this);
        lamDep.setOnClickListener(this);
        quanAo.setOnClickListener(this);
        sach.setOnClickListener(this);
//        xemthemYeuThich.setOnClickListener(this);
//        xemthemNoiBat.setOnClickListener(this);
        xemthemDanhmuc.setOnClickListener(this);
        danhmuc.setOnClickListener(this);

//        setDanhmuc();
//        setLstBtnNoibat();
//        setLstBtnTimkiem();
//        loadData();
//        setLoadMoreAction();

    }

    private void initData() {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this,categoryModel -> {
            if (categoryModel.isSuccess()){
                Log.i("TEST", categoryModel.getResult().get(0).getCategory());
            }
        });
    }


    private void setViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 6) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    public void onClick(View view) {

    }
}