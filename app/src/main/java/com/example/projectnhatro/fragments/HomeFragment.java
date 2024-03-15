package com.example.projectnhatro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectnhatro.Product;
import com.example.projectnhatro.ProductAdapter;
import com.example.projectnhatro.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    Button btn_Contact;
    private RecyclerView rcv_Product;
    private ProductAdapter productAdapter;

private ViewPager ViewPagerImg;
private CircleIndicator CircleIndicator;
private List<Photo> ListPhoto;

private Handler handler = new Handler();
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
        if (ViewPagerImg.getCurrentItem() == ListPhoto.size()-1){
            ViewPagerImg.setCurrentItem(0);
        }
        else {
            ViewPagerImg.setCurrentItem(ViewPagerImg.getCurrentItem()+1);
        }
    }
};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



// recycle list item

        rcv_Product = view.findViewById(R.id.Recycle_View);
        productAdapter = new ProductAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        rcv_Product.setLayoutManager(gridLayoutManager);

        // set dữ liệu = data dòng này
        productAdapter.setData(getListProduct());
        rcv_Product.setAdapter(productAdapter);


// side img
        ViewPagerImg =view.findViewById(R.id.View_Pager_Slide_Img);

        CircleIndicator =view.findViewById(R.id.Circle_Indicator);

        ListPhoto = getListPhoto();
        PhotoViewPagerAdapter adapter = new PhotoViewPagerAdapter(ListPhoto);

        ViewPagerImg.setAdapter(adapter);

        CircleIndicator.setViewPager(ViewPagerImg);

        handler.postDelayed(runnable, 3000);

        ViewPagerImg.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }
    // list product

     private List<Product> getListProduct(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.product1, "Ki-Ốt 1"));
         list.add(new Product(R.drawable.product2, "Ki-Ốt 2"));
         list.add(new Product(R.drawable.product3, "Ki-Ốt 3"));

         return list;
     }

 // slide img
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();

        list.add(new Photo(R.drawable.slide_img1));
        list.add(new Photo(R.drawable.slide_img2));
        list.add(new Photo(R.drawable.slide_img3));

        return list;
 }


}