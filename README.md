# Android-
Android 自定义view 水波纹效果 
 

一：MPAndroidChart图表库 
GitHub：https://github.com/PhilJay/MPAndroidChart

1，线图LineChart ：

在布局文件中添加：
 <com.bonc.acl.chartcomponent.charts.LineChart
     android:id="@+id/line"
     android:layout_width="match_parent"
     android:layout_height="match_parent">
 </com.bonc.acl.chartcomponent.charts.LineChart>

java 中：
        LineChart lineChart = (LineChart) findViewById(R.id.line);
        // 设置描述是否显示
        lineChart.getDescription().setEnabled(true);
        // 设置描述内容和属性
        Description d = new Description();
        d.setText("linechart-Description");
        d.setTextSize(20f);
        lineChart.setDescription(d);

        // 设置可以手势点击
        lineChart.setTouchEnabled(true);

        // 设置拖拽
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        // 设置放大缩小
        lineChart.setPinchZoom(true);

        // 设置背景色
        lineChart.setBackgroundColor(Color.GRAY);

        // 折线图 数据data
        LineData lineData = new LineData();

        // 线图数据集合
        List<Entry> ylist = new ArrayList<>();
        for (int i = 0; i<10;i++){
            float val = (float) (Math.random() * 10) + 3;
            ylist.add(new Entry(i, val));
        }

        // 线图 数据内容类
        LineDataSet dataSet = new LineDataSet(ylist,"DataSet");

        // 数据属性设置
        dataSet.enableDashedLine(10f, 5f, 10f);
        dataSet.enableDashedHighlightLine(10f, 5f, 0f);
        dataSet.setColor(Color.BLACK);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setLineWidth(4f);
        dataSet.setCircleRadius(3f);
//        dataSet.setDrawCircleHole(false);
        dataSet.setValueTextSize(9f);

        // 线下是否填充
//        dataSet.setDrawFilled(true);
        dataSet.setFormLineWidth(1f);
        dataSet.setFormSize(15.f);

        // 将线图动态添加到集合中
        lineData.addDataSet(dataSet);

        // 设置线图数据
        lineChart.setData(lineData);


2，柱状图barchart：

       <com.bonc.acl.chartcomponent.charts.BarChart
        android:id="@+id/barchart"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

       BarChart barChart = (BarChart) findViewById(R.id.barchart);
        List<IBarDataSet> sets = new ArrayList<>();

        // 柱状图数据集合
        ArrayList<BarEntry> yVals = new ArrayList<>();
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < 10; i++) {
            float val = (float) (Math.random() * 6);
            yVals.add(new BarEntry(i, val));
            yVals1.add(new BarEntry(i, val+40));
        }

        BarDataSet set1= new BarDataSet(yVals,"bar1");
        BarDataSet set2= new BarDataSet(yVals1,"bar2");
        set1.setColor(Color.GRAY);
        set2.setColor(Color.BLUE);
        sets.add(set1);
        sets.add(set2);

        BarData barData = new BarData(set1,set2);
        BarData barData2 = new BarData(sets);

        barChart.setData(barData);

3，饼图PieChart：

 <com.bonc.acl.chartcomponent.charts.PieChart
        android:id="@+id/chart1"
        android:layout_width="match_parent"
        android:layout_height=“match_parent"/>
        
    PieChart mChart = (PieChart) findViewById(R.id.chart1);

        // 设置饼图描述信息
        Description d =  new Description();
        d.setText("description");
        mChart.setDescription(d);
        mChart.getDescription().setEnabled(true);

        // 设置饼图中心描述信息
        mChart.setCenterText("Pie -- CenterText");
        mChart.setDrawCenterText(true);

        // 设置百分比显示
        mChart.setUsePercentValues(true);

        // 设置上下左右 间距
        mChart.setExtraOffsets(5, 10, 5, 5);

        // 阻力减速摩擦系数
        mChart.setDragDecelerationFrictionCoef(0.95f);

        // 设置饼图内部中心颜色并显示
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        // 设置透明度 透明颜色
        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        // 设置中间空心半径
        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        // 设置旋转角度
        mChart.setRotationAngle(0);
        // 设置饼图可旋转
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        PieDataSet dataSet = new PieDataSet(entries, "Election Results”);

        PieData data = new PieData(dataSet);
	// 设置百分比格式化
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
        
4，散点图BubbleChart：
  <com.bonc.acl.chartcomponent.charts.BubbleChart
        android:id="@+id/chart1"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.bonc.acl.chartcomponent.charts.BubbleChart>

        mChart = (BubbleChart) findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);

        // 设置背景网格是否显示
        mChart.setDrawGridBackground(true);

        // 设置可以获取点击焦点
        mChart.setTouchEnabled(true);

        // 设置缩放 拖拽
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        // 设置显示最大数量
        mChart.setMaxVisibleValueCount(200);

        //设置 挤压 缩放
        mChart.setPinchZoom(true);

        // 图例样式配置
        Legend l = mChart.getLegend();
        // 图例 在上方 靠右 纵向排列， 在图表内部
        l.setForm(Legend.LegendForm.CIRCLE);//正方形、圆形、线条
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);

        // Y轴属性设置
        YAxis yl = mChart.getAxisLeft();
        //        yl.setSpaceTop(30f);
        //        yl.setSpaceBottom(30f);
        //        yl.setDrawZeroLine(false);

        // 是否显示右侧Y轴
        mChart.getAxisRight().setEnabled(true);

        // X轴属性设置
        XAxis xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);

        ArrayList<BubbleEntry> yVals1 = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals2 = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals3 = new ArrayList<BubbleEntry>();

        int count = 5,
            range = 6;
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            float size = (float) (Math.random() * range);
            yVals1.add(new BubbleEntry(i, val, size));
        }

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            float size = (float) (Math.random() * range);

            yVals2.add(new BubbleEntry(i, val, size));
        }

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            float size = (float) (Math.random() * range);

            yVals3.add(new BubbleEntry(i, val, size));
        }

        // create a dataset and give it a type
        BubbleDataSet set1 = new BubbleDataSet(yVals1, "DS 1");
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0], 130);
        //  显示值
        set1.setDrawValues(false);
        BubbleDataSet set2 = new BubbleDataSet(yVals2, "DS 2");
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1], 130);
        set2.setDrawValues(true);
        BubbleDataSet set3 = new BubbleDataSet(yVals3, "DS 3");
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2], 130);
        set3.setDrawValues(true);

        ArrayList<IBubbleDataSet> dataSets = new ArrayList<IBubbleDataSet>();
        dataSets.add(set1); // add the datasets
        dataSets.add(set2);
        dataSets.add(set3);
        BubbleData data = new BubbleData(dataSets);
        // 值的大小
        data.setValueTextSize(8f);
        // 值的颜色
        data.setValueTextColor(Color.WHITE);
        data.setHighlightCircleWidth(1.5f);

        mChart.setData(data);


5，雷达图 RadarChart：

        RadarChart mChart = (RadarChart) findViewById(R.id.chart1);
        mChart.setBackgroundColor(Color.rgb(60, 65, 82));

        mChart.getDescription().setEnabled(false);

        // 设置 内部线条宽度，外面的环状线条
        mChart.setWebLineWidth(5f);
        mChart.setWebLineWidthInner(1f);

        // 设置 网格 内外 颜色
        mChart.setWebColor(Color.LTGRAY);
        mChart.setWebColorInner(Color.BLACK);
        // 所有线条WebLine透明度
        mChart.setWebAlpha(100);
        float mult = 500;
        float min = 200;
        int cnt = 5;

        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();
        ArrayList<RadarEntry> entries2 = new ArrayList<RadarEntry>();
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mult) + min;
            entries1.add(new RadarEntry(val1));

            float val2 = (float) (Math.random() * mult) + min;
            entries2.add(new RadarEntry(val2));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "Last Week");

        set1.setColor(Color.rgb(103, 110, 129));
        // 设置填充的颜色
        set1.setFillColor(Color.rgb(103, 110, 129));
        // 设置图形是否填充颜色
        set1.setDrawFilled(true);
        // 直至填充色的 透明度
        set1.setFillAlpha(180);
        // 设置线的宽度
        set1.setLineWidth(2f);
        // 设置示是否高亮显示
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(true);

        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);
        mChart.invalidate();





6，曲线图LineChart：
     LineDataSet set1= new LineDataSet(yVals, "DataSet 1”);
    // 设置线图属性为曲线模式
    set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

7，混合图CombinedChart：
 <com.bonc.acl.chartcomponent.charts.CombinedChart
        android:id="@+id/chart1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

        CombinedData data = new CombinedData();
        //data 可以设置不同类型图标的数据，起到制作混合的作用
        data.setData(generateLineData());
        data.setData(generateBarData());
        data.setData(generateBubbleData());
        data.setData(generateScatterData());
        data.setData(generateCandleData());

二 ：设置工具包：

1，版本检测：
/**
     * 设置 版本更新检测,返回true 则需要更新；反之 false 不需要更新
     * @param context：上下文
     * @param version： 通过调用接口返回的版本号
     * @return 
     */
    public static boolean ifupdate(Context context,int version)

     // 检测版本更新，true 需要更新，false 不需要更新
    boolean update = SettingUtils.ifupdate(context,1);

2，水印
   /**
     * 添加水印
     * @param context
     * @param bgView 需要添加水印的布局
     * @param mark 水印的文字
     */
    public static void addMark(Context context, View bgView, String mark ) ；

    // 使用方法 ：
    WaterMark.addMark(context, findViewById(R.id.main),”mark");


3，缓存 处理
        // 1.讲数据存入缓存
        BoncCache cache = BoncCache.get(context);
        cache.put("",""); // 可以存 基本数据类型  对象 bitmap ，json串
        cache.put("test_key1", "test value");
        cache.put("test_key2", "test value", 10);//保存10秒，如果超过10秒去获取这个key，将为null
        cache.put("test_key3", "test value", 2 * BoncCache.TIME_DAY);//保存两天，如果超过两天去获取这个key，将为null

        // cache.getXXX(""); // 通过键 获得值
        // 2.清除缓存
        cache.remove("xxx"); // 清除xxx 的缓存
        // 清除全部缓存
        cache.clear();

4，注销登录（就是清楚登录时缓存的信息）

/**
     * 注销应用登陆，清除登陆缓存
     * @param context
     * @param spId 保存登陆时用户信息的SharedPreferences ID
     */
    public static  void exit(final Context context , final String SharedPreferencesid)

5，修改密码（弹出框）
 /**
     * 修改密码 
     *
     * @param context
     * @param url 修改密码的请求地址
     */
    public static void changePassword(final Context context, final String url)

6，切换主题（需要给应用添加对sd卡的可读可写权限）
https://github.com/fengjundev/Android-Skin-Loader

1. 在Application中进行初始化

public class SkinApplication extends Application {
    public void onCreate() {
        super.onCreate();
        // Must call init first 
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().load();
    }
}
2. 在布局文件中标识需要换肤的View

...
xmlns:skin="http://schemas.android.com/android/skin"
...
  <TextView
     ...
     skin:enable="true" 
     ... />
3. 继承BaseActivity或者BaseFragmentActivity作为BaseActivity进行开发

4. 从.skin文件中设置皮肤

String SKIN_NAME = "BlackFantacy.skin";
String SKIN_DIR = Environment.getExternalStorageDirectory() + File.separator + SKIN_NAME;
File skin = new File(SKIN_DIR);
SkinManager.getInstance().load(skin.getAbsolutePath(),
                new ILoaderListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onFailed() {
                    }
                });
5. 重设默认皮肤

SkinManager.getInstance().restoreDefaultTheme();

6. 对代码中创建的View的换肤支持

主要由IDynamicNewView接口实现该功能，在BaseActivity，BaseFragmentActivity和BaseFragment中已经实现该接口.

public interface IDynamicNewView {
    void dynamicAddView(View view, List<DynamicAttr> pDAttrs);
}
用法：动态创建View后，调用dynamicAddView方法注册该View至皮肤映射表即可(如下).详见sample工程

    private void dynamicAddTitleView() {
        TextView textView = new TextView(getActivity());
        textView.setText("Small Article (动态new的View)");
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(param);
        textView.setTextColor(getActivity().getResources().getColor(R.color.color_title_bar_text));
        textView.setTextSize(20);
        titleBarLayout.addView(textView);

        List<DynamicAttr> mDynamicAttr = new ArrayList<DynamicAttr>();
        mDynamicAttr.add(new DynamicAttr(AttrFactory.TEXT_COLOR, R.color.color_title_bar_text));
        dynamicAddView(textView, mDynamicAttr);
    }

7. 皮肤包是什么？如何生成？
皮肤包（后缀名为.skin）的本质是一个apk文件，该apk文件不包含代码，只包含资源文件
在皮肤包工程中（示例工程为skin/BlackFantacy）添加需要换肤的同名的资源文件，直接编译生成apk文件，再更改后缀名为.skinj即可（防止用户点击安装）
使用gradle，buildandroid-skin-loader-skin工程后即可在skin-package目录下取皮肤包（修改脚本中def skinName = “BlackFantacy.skin"换成自己想要的皮肤名）


——————————————————————————————————————————

三：日志操作库
https://github.com/orhanobut/logger


       Logger.init(YOUR_TAG);

        // 打印各种类型的日志信息
        Logger.d("hello");
        Logger.d("hello %s %d", "world", 5);   // String.format

        Logger.d("hello");
        Logger.e("hello");
        Logger.w("hello");
        Logger.v("hello");
        Logger.wtf("hello");
        
        // 格式化json 并打印
//        Logger.json(JSON_CONTENT);
        // 格式化xml 并打印
//        Logger.xml(XML_CONTENT);
//        Logger.log(DEBUG, "tag", "message", throwable);

        // 打印数组 集合
//        Logger.d(list);
//        Logger.d(map);
//        Logger.d(set);
//        Logger.d(new String[]);

        // 修改日志操作默认设置
        Logger
            .init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
            .methodCount(3)                 // default 2 ：默认打印 方法数
//            .hideThreadInfo()            // default shown：默认显示当前线程
            .logLevel(LogLevel.FULL)        // default LogLevel.FULL ：是否显示log（）
            .methodOffset(2)                // default 0 方法显示层级
            .logAdapter(null)//default AndroidLogAdapter
        ;

        // 恢复日志默认操作
        Logger.resetSettings();


四，view库（listview  gridview）

1，下拉刷新PtrFrameLayout
https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh

支持所有的View下拉刷新ListView, GridView, ScrollView, FrameLayout, 甚至 TextView.

有6个参数可配置:
阻尼系数 ： 默认: 1.7f，越大，感觉下拉时越吃力。
触发刷新时移动的位置比例：默认，1.2f，移动达到头部高度1.2倍时可触发刷新操作。
回弹延时：默认 200ms，回弹到刷新高度所用时间
头部回弹时间：默认1000ms
刷新是保持头部：默认值 true.
下拉刷新 / 释放刷新：默认为释放刷新

xml中配置示例：
<in.srain.cube.views.ptr.PtrFrameLayout
    android:id="@+id/store_house_ptr_frame"
    xmlns:cube_ptr="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    cube_ptr:ptr_resistance="1.7"
    cube_ptr:ptr_ratio_of_header_height_to_refresh="1.2"
    cube_ptr:ptr_duration_to_close="300"
    cube_ptr:ptr_duration_to_close_header="2000"
    cube_ptr:ptr_keep_header_when_refresh="true"
    cube_ptr:ptr_pull_to_fresh="false" >

    <LinearLayout
        android:id="@+id/store_house_ptr_image_content"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/cube_mints_333333"
        android:clickable="true"
        android:padding="10dp">

        <in.srain.cube.image.CubeImageView
            android:id="@+id/store_house_ptr_image"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </LinearLayout>
</in.srain.cube.views.ptr.PtrFrameLayout>

也可以在java代码中配置：
mPtrFrame.setResistance(1.7f);
mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
mPtrFrame.setDurationToClose(200);
mPtrFrame.setDurationToCloseHeader(1000);
// 默认是 false
mPtrFrame.setPullToRefresh(false);
// 默认是 true
mPtrFrame.setKeepHeaderWhenRefresh(true);

处理刷新：
ptrFrame.setPtrHandler(new PtrHandler() {
    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        frame.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrFrame.refreshComplete();
            }
        }, 1800);
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        // 默认实现，根据实际情况做改动
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }
});



2， 可动态添加头布局，脚布局的gridview
https://github.com/liaohuqiu/android-GridViewWithHeaderAndFooter

使用说明：

xml中配置示例：
<com.bonc.acl.viewcomponent.gridviewwithhf.GridViewWithHeaderAndFooter
        android:id="@+id/gridview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:numColumns="3">
</com.bonc.acl.viewcomponent.gridviewwithhf.GridViewWithHeaderAndFooter>

GridViewWithHeaderAndFooter gridView = (GridViewWithHeaderAndFooter) v.findViewById(R.id.ly_image_list_grid);

LayoutInflater layoutInflater = LayoutInflater.from(this);
View headerView = layoutInflater.inflate(R.layout.test_header_view, null);
View footerView = layoutInflater.inflate(R.layout.test_footer_view, null);
gridView.addHeaderView(headerView);
gridView.addFooterView(footerView);

3，listview 下拉刷新，上拉加载（xlistview）
https://github.com/Maxwin-z/XListView-Android

XListView使用示例

设置XListView相关属性
mListView = (XListView) findViewById(R.id.list_view);
mListView.setPullRefreshEnable(true);
mListView.setPullLoadEnable(true);
mListView.setAutoLoadEnable(true);
mListView.setXListViewListener(this);
mListView.setRefreshTime(getTime());

mAdapter = new ArrayAdapter<String>(this, R.layout.vw_list_item, items);
mListView.setAdapter(mAdapter);

下拉刷新，下拉加载更多使用示例
@Override
public void onRefresh() {
    mHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            mIndex = ++mRefreshIndex;
            items.clear();
            geneItems();
            mAdapter = new ArrayAdapter<String>(XListViewActivity.this, R.layout.vw_list_item,
                    items);
            mListView.setAdapter(mAdapter);
            onLoad();
        }
    }, 2500);
}

@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {
        mListView.autoRefresh();
    }
}

@Override
public void onLoadMore() {
    mHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            geneItems();
            mAdapter.notifyDataSetChanged();
            onLoad();
        }
    }, 2500);}
    
    
4，SwipeMenuListView : item滑动
使用说明：
xml中配置示例：
<com.bonc.acl.viewcomponent.swipemenulistview.SwipeMenuListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </com.bonc.acl.viewcomponent.swipemenulistview.SwipeMenuListView>

java 代码中相关配置：

        // step 1.创建 滑动菜单 容器
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // 创建菜单1 （delete）
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                // 设置菜单背景色
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                // 设置菜单宽度
                deleteItem.setWidth(dp2px(90));
                // 设置菜单icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // 添加入菜单容器
                menu.addMenuItem(deleteItem);

                SwipeMenuItem changeItem = new SwipeMenuItem(getApplicationContext());
                changeItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
                changeItem.setWidth(dp2px(90));
                // 设置菜单标题 文字大小 颜色
                changeItem.setTitle("修改");
                changeItem.setTitleSize(18);
                changeItem.setTitleColor(Color.WHITE);

                menu.addMenuItem(changeItem);
            }
        };
        // 将菜单容器添加到listview
        mListView.setMenuCreator(creator);

        // step 2.监听菜单 item 的点击事件
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() 	{
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
               
                }
                return false;
            } });

        // 设置 滑动监听
        mListView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {
            @Override
            public void onSwipeStart(int position) {
                // 滑动开始
            }

            @Override
            public void onSwipeEnd(int position) {
                // 滑动结束
            }
        });

        // 设置item 菜单打开 关闭监听
        mListView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
            }
            @Override
            public void onMenuClose(int position) {
            }
        });
 // 设置 菜单 滑动方向（右／ 左）
 mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
（SwipeMenuListView.DIRECTION_RIGHT）

5，DynamicGridView  拖动  item 可移动得gridview
使用说明：
xml中配置示例：
    <com.bonc.acl.viewcomponent.dynamicgrid.DynamicGridView
        android:id="@+id/dynamicgrid"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:numColumns="3">
    </com.bonc.acl.viewcomponent.dynamicgrid.DynamicGridView>

java 代码中相关配置：
// 实例化DynamicGridView
gridView = (DynamicGridView) findViewById(R.id.dynamicgrid);
// 设置适配器
gridView.setAdapter(new CheeseDynamicAdapter(this,new ArrayList<String>(Arrays.asList(sCheeseStrings)),3));

//  获取当前是否是可拖拽的状态
boolean isEdit = gridView.isEditMode()；

// 设置当前状态 是否可拖拽
gridView.startEditMode(position);
gridView.stopEditMode();
// 设置拖拽监听
        gridView.setOnDragListener(new DynamicGridView.OnDragListener() {
            @Override
            public void onDragStarted(int position) {
                Log.d(TAG, "drag started at position " + position);
            }

            @Override
            public void onDragPositionsChanged(int oldPosition, int newPosition) {
                Log.d(TAG, String.format("drag item position changed from %d to %d", oldPosition, newPosition));
            }
        });
