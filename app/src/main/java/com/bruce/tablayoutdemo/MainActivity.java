package com.bruce.tablayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //
        ArrayList<Fragment> arrayList = getFragmentListData();
        ArrayList<String> stringArrayList = getTitleListData();

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), arrayList, stringArrayList);
        viewPager.setAdapter(adapter);
        //一定要在 setAdapter之后使用
        tabLayout.setupWithViewPager(viewPager);
        //配置
        configTabLayout();
    }

    private void configTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //
        //设置选中标签下方导航条的颜色
//        tl.setSelectedTabIndicatorColor(Color.GREEN);
        //设置选中标签下方导航条的高度
//        tl.setSelectedTabIndicatorHeight(30);
        /*
        * 设置标签的字体颜色
        * 1.非选中标签的字体颜色
        * 2. 选中标签的字体颜色
        * */
//        tl.setTabTextColors(Color.BLUE,Color.GREEN);

        /*
        * 设置Tab的模式
        * 可选：
        * MODE_FIXED   宽度始终是tl控件指定的宽度，如果标签过多，那么就无限挤压控件
        * MODE_SCROLLABLE  每个标签都保持自身宽度，一旦标签过多，给标题栏提供支持横向滑动的功能
        * */
//        tl.setTabMode(TabLayout.MODE_SCROLLABLE);


        //设置Tab标签的对其方式
        //注意：此条属性必须配合MODE_FIXED进行使用
        /*
        * 可选择的参数值：
        * GRAVITY_FILL   让每个标签平分TabLayout的全部宽度
        * GRAVITY_CENTER   让每个标签显示自身宽度，然后所有标签居中显示
        * */

        //
        tabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        // public void setTabTextColors(int normalColor, int selectedColor)
        tabLayout.setTabTextColors(Color.parseColor("#236f28"), Color.parseColor("#bc6e1c"));
        //
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            //当标签被选中时运行的方法
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int position = tab.getPosition();
//            }
//
//            //当标签被取消选中时运行的方法
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            //当标签被重复选中时运行的方法
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    private ArrayList<String> getTitleListData() {
        //
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("教师1");
        stringArrayList.add("教师2");
        stringArrayList.add("教师3");
        return stringArrayList;
    }

    private ArrayList<Fragment> getFragmentListData() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        FragmentTwo FragmentTwo = new FragmentTwo();
        FragmentOne FragmentOne = new FragmentOne();
        Fragment3 Fragment3 = new Fragment3();
        arrayList.add(FragmentOne);
        arrayList.add(FragmentTwo);
        arrayList.add(Fragment3);
        return arrayList;
    }
}
