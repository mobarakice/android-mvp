package com.atomapgroup.baseproject.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Mobarak on 28-Sep-17.
 */

public class PermissionUtil {


    /**
     * Location permission array
     */
    private static String[] LOCATION_PERMISSION = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    private static String[] STORAGE_PERMISSION = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static String[] CAMERA_PERMISSION = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * Invoke to check read phone state permission.
     * If permission is grant
     *
     * @param activity
     * @return
     */
    public static boolean requestReadPhoneState(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(activity, READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            activity.requestPermissions(new String[]{READ_PHONE_STATE}, Constants.REQUEST_READ_PHONE_STATE);
        }
        return false;
    }

    /**
     * Invoke to check read phone state permission.
     * If permission is grant
     *
     * @param activity
     * @return
     */
    public static boolean requestForAccessDeviceLocation(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            activity.requestPermissions(LOCATION_PERMISSION, Constants.REQUEST_LOCATION_ACCESS);
        }
        return false;
    }

    /**
     * Invoke to check device storage access permission.
     * If permission is grant
     *
     * @param activity
     * @return
     */
    public static boolean requestForAccessStorage(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            activity.requestPermissions(STORAGE_PERMISSION, Constants.REQUEST_STORAGE_ACCESS);
        }
        return false;
    }

    /**
     * Invoke to check device storage access permission.
     * If permission is grant
     *
     * @param activity
     * @return
     */
    public static boolean requestForAccessCamera(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, CAMERA) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            activity.requestPermissions(CAMERA_PERMISSION, Constants.REQUEST_CAMERA_ACCESS);
        }
        return false;
    }

    /**
     * Invoke to check permissions for Phone call
     *
     * @return true|false
     */
    public static boolean requestPhoneCallPermissions(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(activity, CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            activity.requestPermissions(new String[]{CALL_PHONE}, Constants.REQUEST_PHONE_CALL);
        }
        return false;
    }
}
