package com.atomapgroup.baseproject.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.atomapgroup.baseproject.R;


/**
 * Created by User on 28-Sep-17.
 */

public class DialogUtil {

    public static void showDialog(final FragmentActivity context, String title, String message) {

        if (context == null || message == null) {
            return;
        }

        Log.i("Success-MSG:", " " + message);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvTitle = (TextView) dialogView.findViewById(R.id.tv_title);
        TextView tvShowError = (TextView) dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = (TextView) dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvTitle.setText(title + "");
        tvShowError.setText(message);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> {
//            UtilityFunctions.changeFragment(context, new LoginFragment(), false);
            errorDialog.dismiss();
        });
        errorDialog.show();

    }

    public static void showDialog(final FragmentActivity context, final Fragment fragment, String title, String message) {

        if (context == null || message == null || fragment == null) {
            return;
        }

        Log.i("Success-MSG:", " " + message);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvTitle = dialogView.findViewById(R.id.tv_title);
        TextView tvShowError = dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvTitle.setText(title + "");
        tvShowError.setText(message);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> {
            UtilityFunctions.changeFragment(context, fragment, false);
            errorDialog.dismiss();
        });
        errorDialog.show();

    }



    public static AlertDialog.Builder getAlertDialogBuilder(Context context, String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        return builder;
    }

    public static void showErrorDialog(final FragmentActivity context, String title, String message) {

        if (context == null || message == null) {
            return;
        }

        Log.i("Success-MSG:", " " + message);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvTitle = (TextView) dialogView.findViewById(R.id.tv_title);
        TextView tvShowError = (TextView) dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = (TextView) dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvTitle.setText(title + "");
        tvShowError.setText(message);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> errorDialog.dismiss());
        errorDialog.show();

    }


    public static android.app.AlertDialog.Builder getAlertDialogBuilderNoInternet(Context context, String title, String message) {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(context);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        return builder;
    }

}
