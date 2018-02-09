package com.atomapgroup.baseproject.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.atomapgroup.baseproject.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by user123 on 9/18/2017.
 */

public class UtilityFunctions {

    private static ProgressDialog progressDialog;


    /**
     * invoke to change fragment
     *
     * @param activity
     * @param fragment
     * @param isAddToBackStack
     * @param isHideSoftKeyboard
     */
    public static void changeFragment(FragmentActivity activity, Fragment fragment, boolean isAddToBackStack, boolean isHideSoftKeyboard) {

        if (activity == null || fragment == null) {
            return;
        }
        if (isHideSoftKeyboard) {
            hideVirtualKeyboard(activity);
        }

        FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(R.id.container, fragment, Constants.CURRENT_FRAGMENT);

        transaction.commitAllowingStateLoss();
        activity.getSupportFragmentManager().executePendingTransactions();
    }

    /**
     * invoke to hide keyboard
     *
     * @param activity
     */
    public static void hideVirtualKeyboard(FragmentActivity activity) {
        if (activity == null) {
            return;
        }

        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(null == activity
                .getCurrentFocus() ? null : activity.getCurrentFocus()
                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public static void showSoftKeyboard(FragmentActivity activity, View view) {
        if (activity == null || view == null) {
            return;
        }

        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }


    public static String getFormatedDate(Date date, String format) {
        if (date == null) {
            date = new Date();
        }

        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * Invoke to get date
     *
     * @param isToday true|false
     * @return if true then return today otherwise return one month before to current date
     */
    public static String getDate(boolean isToday) {
        SimpleDateFormat df = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        if (isToday) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
        } else {
            calendar.add(Calendar.MONTH, Constants.DEFAULT_DATE_RANGE);
        }
        Date date = calendar.getTime();
        return df.format(date);
    }


    /**
     * This method will check the is valid or invalid.
     *
     * @param email (It will get string)
     * @return true or false
     */
    public static boolean isEmailValid(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * This method will check the phone number is valid or invalid.
     *
     * @param phoneNo (It will get string)
     * @return true or false
     */
    public static boolean isPhoneNumberValid(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        String phoneMatcher = "\\d{5,15}";
        return phoneNo.matches(phoneMatcher);
        //return Patterns.PHONE.matcher(phoneNo).matches();
    }

    /**
     * Invoke to validate vendor delivery with in time
     *
     * @param time(vendor delivery time)
     * @return true|false
     */
    public static boolean isDeliveryTimeValid(String time) {
        return isAlphaNumeric(time) && (time.length() < 2);
    }


    /**
     * Invoke to validate vendor password
     *
     * @param password(vendor password)
     * @return true|false
     */
    public static boolean isPasswordValid(String password) {
        return isAlphaNumeric(password)
                && (password.length() > 5 && password.length() < 13);
    }

    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        if (context == null) {
            return "";
        }

        boolean isTelephonyService = false;
        PackageManager packageManager = context.getPackageManager();
        // Check the Package Manager isn't exists
        if (packageManager != null) {
            isTelephonyService = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
        }
        // Check it has Telephony Service
        if (isTelephonyService) {
            // Get the IMEI number
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return "IMEI is :" + telephonyManager.getImei();
            } else {
                return "IMEI is :" + telephonyManager.getDeviceId();
            }
        } else {
            // Get the MAC Address
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            return "MAC Address: " + wifiManager.getConnectionInfo().getMacAddress();
        }

    }


    /**
     * 文字種をチェック
     *
     * @param aString
     * @return true|false
     */
    public static boolean isContainDoubleByteCharacter(String aString) {
        try {

            //  for (int i=0; i<aString.length(); i++) {
            if (aString.getBytes("SJIS").length > aString.length()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return true;
        }
    }


    /**
     * This method convert dp to pixel
     *
     * @param dp
     * @param context
     * @return
     */
    public static float dpToPixel(float dp, Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static boolean isAlphaNumeric(String aString) {
        String reges = "[A-Za-z0-9]+";
        return aString.matches(reges);
    }

    public static boolean isVendorNameValid(String aString) {
        String reges = "[A-Za-z0-9 ]+";
        return aString.matches(reges);
    }

    public static boolean isNumeric(String aString) {
        String reges = "[0-9]+";
        return aString.matches(reges);
    }

    /**
     * Invoke to validate user name
     *
     * @param userName
     * @return
     */
    public static boolean isUserNameValid(String userName) {
        return isAlphaNumeric(userName) && userName.length() <= 20;
    }

    /**
     * Invoke to validate user name
     *
     * @param emailOrPhone
     * @return
     */
    public static boolean isUserIdValid(String emailOrPhone) {
        return isEmailValid(emailOrPhone) || isPhoneNumberValid(emailOrPhone);
    }

    public static void showProgressBar(final FragmentActivity aActivity) {

        try {
            if (progressDialog != null || aActivity == null) {
                return;
            }

            progressDialog = new ProgressDialog(aActivity);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Connecting");
            progressDialog.setCancelable(false);
            progressDialog.show();


        } catch (Exception ex) {

        }

    }

    public static void stopProgressBar(final FragmentActivity aActivity) {
        try {

            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception ex) {

        }
    }

    /**
     * This method is checked internet availability's
     *
     * @param context
     * @return true|false
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


    public static void setPlaceHolder(final View view, final String hintText) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (view instanceof AutoCompleteTextView) {

                        ((AutoCompleteTextView) view).setHint(hintText);
                    } else {
                        ((EditText) view).setHint(hintText);
                    }
                } else {
                    if (view instanceof AutoCompleteTextView) {
                        ((AutoCompleteTextView) view).setHint(null);
                    } else {
                        ((EditText) view).setHint(null);
                    }
                }
            }
        });
    }


    public static void changeFragment(FragmentActivity activity, Fragment fragment, boolean isAddToBackStack) {
        if (activity == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
            Log.i("changeFragment", "Granted");
        }
        transaction.replace(R.id.container, fragment, Constants.CURRENT_FRAGMENT);
        transaction.commitAllowingStateLoss();
        activity.getSupportFragmentManager().executePendingTransactions();
    }


    public static void setStatusBarTransparent(FragmentActivity activity, boolean isTransparent) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (isTransparent) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {

            window.setStatusBarColor(activity.getResources().getColor(R.color.primaryDarkColor));
        }


//        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.setStatusBarColor(ContextCompat.getColor(activity, R.color.red_text_color));

    }

    public static void setStatusBarColor(FragmentActivity activity, int color) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.setStatusBarColor(color);
    }

    /**
     * Invoke to enable and disable view
     *
     * @param view
     * @param isEnable true|false
     */
    public static void enableDisableView(View view, final boolean isEnable) {
        view.setEnabled(isEnable);
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                enableDisableView(group.getChildAt(i), isEnable);
            }
        }
    }

//    public static void loadImage(Context context, String imagePath, int resId, ImageView imageView) {
//        if (context == null || imagePath == null || imageView == null) return;
//        Glide.with(context).load(imagePath)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
//                .placeholder(resId)
//                .into(imageView);
//    }

    /**
     * Invoke to convert time 12 hours to 24 hours format
     *
     * @param dateTime
     * @return
     */
    public static String getDateWithTimeIn12HoursFormat(String dateTime) {
        if (dateTime == null) {
            return "";
        }
        String for12 = "";
        SimpleDateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format12 = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        try {
            for12 = format12.format(format24.parse(dateTime));
            Log.i("Format12", "" + for12);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return for12;
    }

    /**
     * Invoke to convert time 24 hours to 12 houre format
     *
     * @param dateTime string
     * @return
     */
    public static String getDateWithTimeIn24HoursFormat(String dateTime) {
        if (dateTime == null) {
            return "";
        }
        String for24 = "";
        SimpleDateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format12 = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        try {
            for24 = format24.format(format12.parse(dateTime));
            Log.i("Format24", "" + for24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return for24;
    }


    /**
     * Invoke to validate date range
     *
     * @param startDate
     * @param endDate
     * @return true|false
     */
    public static boolean isStartAndEndDateValid(String startDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (df.parse(startDate).before(df.parse(endDate))) {
                return true;
            } else if (df.parse(startDate).equals(df.parse(endDate))) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            Log.e("DateError: ", "" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Invoke to validate date time
     *
     * @param dateTime
     * @return true|false
     */
    public static boolean isDateTimeValid(String dateTime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String currentTime = df.format(date);
            Log.i("CurrentTime", "" + currentTime);
            if (df.parse(dateTime).after(df.parse(currentTime))) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            Log.e("DateError: ", "" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Invoke get device width
     *
     * @param context
     * @return
     */
    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * Invoke to get device height
     *
     * @param context
     * @return
     */
    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * Invoke to convert dp to pixels
     *
     * @param dp
     * @param context
     * @return
     */
    public static int dpToPx(float dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    /**
     * Invoke to make phone call
     *
     * @param number telephone or cell phone number
     */
    public static void makeCall(FragmentActivity activity, String number) {
        if (activity == null || number == null || TextUtils.isEmpty(number)) {
            return;
        }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(Constants.TEL + number.trim()));
        activity.startActivity(Intent.createChooser(callIntent, ""));
    }


}
