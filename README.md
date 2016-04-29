##GradualRadioBar
拿RadioGroup和RadioButton开刀，实现微信底部导航栏图标颜色渐变效果
##使用
###gradle
```
compile 'io.github.leibnik:gradualradiobar:1.0.1'
```
###xml
GradualRadioGroup和GradualRadioButton必须配合使用
```xml
<io.github.leibnik.gradualradiobar.GradualRadioGroup
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <io.github.leibnik.gradualradiobar.GradualRadioButton
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:checked="true"
            android:drawablePadding="3dp"
            android:drawableTop="@mipmap/home"
            android:gravity="center_horizontal"
            android:paddingBottom="5dp"
            android:paddingTop="3dp"
            android:text="AAA"
            android:textColor="#555"
            app:gradual_color="#f75151"/>

        <io.github.leibnik.gradualradiobar.GradualRadioButton
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:drawablePadding="3dp"
            android:gravity="center_horizontal"
            android:paddingBottom="5dp"
            android:paddingTop="3dp"
            android:text="BBB"
            android:textColor="#555"
            app:gradual_icon="@mipmap/order"
            app:gradual_color="#f75151"/>

    </io.github.leibnik.gradualradiobar.GradualRadioGroup>
```
* `app:gradual_color`:渐变的颜色
* `app:gradual_icon`:图标，可以使用`android:drawableTop`来设置图标

###Java
```java
gradualRadioGroup = (GradualRadioGroup) findViewById(R.id.radiobar);
viewPager.setAdapter(adapter);
// GradualRadioGroup实现了ViewPager.OnPageChangeListener接口
viewPager.addOnPageChangeListener(gradualRadioGroup);
// 通过单击GradualRadioButton切换ViewPager页面时需给GradualRadioGroup设置OnRadioButtonClickListener
gradualRadioGroup.setOnRadioButtonClickListener(new GradualRadioGroup.OnRadioButtonClickListener() {
    @Override
    public void updateViewPager(int position) {
        viewPager.setCurrentItem(position,false);
    }
});
```
##效果
![](http://ww1.sinaimg.cn/mw690/b5405c76gw1f3dokvtqpyg20bb0gh4fa.gif)
![](http://ww3.sinaimg.cn/mw690/b5405c76gw1f3dokt0ag3g20b508tnb2.gif)
## License
[Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0)