package com.xdzl.golden.mango.application.utils

import android.app.Activity
 import android.view.View
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar

fun fixStatusBar(activity: Activity,view: View){
    //可以为任意view，如果是自定义xml实现标题栏的话，标题栏根节点不能为RelativeLayout或者ConstraintLayout，以及其子类
    ImmersionBar.with(activity)
        .titleBar(view).init()
}
fun fixStatusBar(activity: Fragment,view: View){
    //可以为任意view，如果是自定义xml实现标题栏的话，标题栏根节点不能为RelativeLayout或者ConstraintLayout，以及其子类
    ImmersionBar.with(activity)
        .titleBar(view).init()
}