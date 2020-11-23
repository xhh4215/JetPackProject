package com.xdzl.golden.mango.application.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xdzl.golden.mango.application.bundles.MainBundle

fun launch(context: Context, clazz: Class<*>) {
    val intent = Intent(context, clazz)
    context.startActivity(intent)
}

fun launchWithString(
    context: Context,
    clazz: Class<*>,
    key: String,
    value: String
) {
    val intent = Intent(context, clazz)
    intent.putExtra(key, value)
    context.startActivity(intent)
}

fun launchWithInt(
    context: Context,
    clazz: Class<*>,
    key: String,
    value: Int
) {
    val intent = Intent(context, clazz)
    intent.putExtra(key, value)
    context.startActivity(intent)
}

fun launchWithBoolean(
    context: Context,
    clazz: Class<*>,
    key: String,
    value: Boolean
) {
    val intent = Intent(context, clazz)
    intent.putExtra(key, value)
    context.startActivity(intent)
}


fun launchWithData(
    context: Context,
    clazz: Class<*>,
    key: String,
    mainBundle: MainBundle
) {
    val intent = Intent(context, clazz)
    val bundle = Bundle()
    bundle.putSerializable(key, mainBundle)
    intent.putExtras(bundle)
    context.startActivity(intent)
}