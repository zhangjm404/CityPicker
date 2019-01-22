

# CityPicker

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-9%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=9)

现在使用比较多的类似美团等APP的城市选择界面.

2步即可实现，就是这么简单粗暴！

# Gif

![image](https://github.com/zaaach/CityPicker/raw/master/art/screen.gif)


# Install

Gradle:

```groovy
compile 'com.github.zhangjm404:CityPicker:1.0.1'
```

or 下载library手动导入.

# Usage

`CityPicker`本身已经引入了高德地图定位sdk.

### step1:

还需要添加`CityPickerActivity`

```xml
<activity
            android:name="com.zaaach.citypicker.CityPickerActivity"
            android:theme="@style/CityPicker.NoActionBar"
            android:screenOrientation="portrait"
            android:windowSoftInputMode="stateHidden|adjustPan"/>
```

### Step2

写法1： 用ActivityForResult 接收返回的值
```java
private static final int REQUEST_CODE_PICK_CITY = 0;
//启动
startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);

//重写onActivityResult方法
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
        if (data != null){
            String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            resultTV.setText("当前选择：" + city);
        }
    }
}
```
写法2： 用ActivityForResult 接收返回的值
```java
//启动
Intent intent = new Intent(MainActivity.this, CityPickerActivity.class);
intent.putExtra(CityPickerActivity.KEY_EVENTBUS_TAG, TAG_MAIN);
intent.putExtra(CityPickerActivity.KEY_LOCATE_CITY, "广州");
startActivity(intent);

//接收
@Subscriber(tag = TAG_MAIN, mode = ThreadMode.MAIN)
private void getCity(MsgEventBus msgEventBus) {
    resultTV.setText("当前选择：" + msgEventBus.getCity());
}
```

### Step3:

enjoy it.

# Proguard

注意混淆

```java
//定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}
```

# Ad
我的[动漫周边淘宝店]( https://shop238932691.taobao.com/) ，希望亲可以关注下(dan)：

![二维码](https://img.alicdn.com/imgextra/i1/769720206/TB2AnBVar0kpuFjy0FjXXcBbVXa_!!769720206.png)