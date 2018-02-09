package com.atomapgroup.baseproject.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.VolleyError;
import com.atomapgroup.baseproject.R;
import com.atomapgroup.baseproject.data.network.JsonUtil;

import org.json.JSONObject;

/**
 * Created by Mobarak on 27-Sep-17.
 * <p>
 * Updated by Moontasirul on 12-26-2017
 */

public class ErrorHandler {

    public static String getErrorMessage(Context context, VolleyError aError) {
        String errorMessage = "";
        if (isNetworkProblem(aError)) {
            errorMessage = "Need to error message";//context.getString(R.string.error_code_40011);
        } else {

            try {
                if (aError != null && aError.networkResponse != null) {
                    int statusCode = aError.networkResponse.statusCode;
                    Log.i("StatusCode: ", "" + statusCode);
                    JSONObject aErrorBody = new JSONObject(new String(aError.networkResponse.data));
                    String errorDescription = "";
                    if (aErrorBody != null && aErrorBody.has(Constants.ERROR_DESCRIPTION)) {
                        errorDescription = aErrorBody.getString(Constants.ERROR_DESCRIPTION);
                    } else {
                        errorDescription = "Need to error message";//context.getString(R.string.error_message_unknown_error);
                    }
                    Log.i("Description: ", "" + errorDescription);

                    String errorCode = "";
                    if (aErrorBody != null && aErrorBody.has(Constants.ERROR_CODE)) {
                        errorCode = aErrorBody.getString(Constants.ERROR_CODE);
                    }
                    Log.i("ErrorCode: ", "" + errorCode);
                    if (errorCode.isEmpty() || errorCode == null) {
//                        errorMessage = errorMessage.concat(getErrorMessage(context, statusCode, errorDescription));
                    } else {
//                        errorMessage = errorMessage.concat(getErrorMessage(context, statusCode, errorCode, errorDescription));
                    }

                } else {
                    errorMessage = "Need to error message";//context.getString(R.string.error_message_unknown_error);
                }
            } catch (Exception ex) {
                Log.e("ErrorMessage", ex.getMessage());
                if (aError != null && aError.networkResponse != null) {
//                    errorMessage = errorMessage.concat(getErrorMessage(context, aError.networkResponse.statusCode, ""));
                } else
                    errorMessage = "Need to error message";//context.getString(R.string.error_message_unknown_error);
            }
        }
        Log.e("ErrorMessage", errorMessage);
        return errorMessage;

    }

    public static String getErrorMessage(Context context, String jsonString) {
        String errorMessage = "";
        try {
            if (jsonString != null) {
                JSONObject object = new JSONObject(jsonString);
                String status = JsonUtil.getParseString(object, Constants.STATUS);
                Log.i("StatusCode: ", "" + status);
                String errorDescription = JsonUtil.getParseString(object, Constants.ERROR_DESCRIPTION);
                Log.i("Description: ", "" + errorDescription);
                String errorCode = JsonUtil.getParseString(object, Constants.ERROR_CODE);
                Log.i("ErrorCode: ", "" + errorCode);
//                errorMessage = getErrorMessage(context, 0, errorCode, errorDescription);
            } else {
                errorMessage = "Need to error message";//context.getString(R.string.error_message_unknown_error);
            }
        } catch (Exception ex) {
            Log.e("ErrorMessage", ex.getMessage());
            errorMessage = "Need to error message";//context.getString(R.string.error_message_unknown_error);
        }
        Log.e("ErrorMessage", errorMessage);
        return errorMessage;

    }

//    /**
//     * Invoke to get error message besd on the status code and error code
//     *
//     * @param context
//     * @param statusCode
//     * @return
//     */
//    public static String getErrorMessage(Context context, int statusCode, String errorDescription) {
//        String errorMsg = "";
//        switch (statusCode) {
//            case 400:
//                errorMsg = context.getString(R.string.error_code_40001);
//                break;
//            case 401:
//                errorMsg = context.getString(R.string.error_code_40008);
//                break;
//            case 403:
//                errorMsg = context.getString(R.string.error_code_40003);
//                break;
//            case 404:
//                errorMsg = context.getString(R.string.error_code_40007);
//                break;
//            case 408:
//                errorMsg = context.getString(R.string.error_code_40003);
//                break;
//            case 500:
//                errorMsg = context.getString(R.string.error_code_40001);
//                break;
//            case 503:
//                errorMsg = context.getString(R.string.error_code_40002);
//                break;
//            default:
//                errorMsg = errorDescription;
//        }
//        return errorMsg;
//    }

//    /**
//     * Invoke to get error message besd on the error code
//     *
//     * @param context
//     * @param errorCode
//     * @return
//     */
//    public static String getErrorMessage(Context context, int statusCode, String errorCode, String errorDescription) {
//        String errorMsg = "";
//        switch (errorCode) {
//            case ErrorCode.ERROR_CODE_10001:
//                errorMsg = context.getString(R.string.error_code_10001);
//                break;
//            case ErrorCode.ERROR_CODE_10002:
//                errorMsg = context.getString(R.string.error_code_10002);
//                break;
//            case ErrorCode.ERROR_CODE_10003:
//                errorMsg = context.getString(R.string.error_code_10003);
//                break;
//            case ErrorCode.ERROR_CODE_10004:
//                errorMsg = context.getString(R.string.error_code_10004);
//                break;
//            case ErrorCode.ERROR_CODE_10005:
//                errorMsg = context.getString(R.string.error_code_10005);
//                break;
//            case ErrorCode.ERROR_CODE_10006:
//                errorMsg = context.getString(R.string.error_code_10006);
//                break;
//            case ErrorCode.ERROR_CODE_10007:
//                errorMsg = context.getString(R.string.error_code_10007);
//                break;
//            case ErrorCode.ERROR_CODE_10008:
//                errorMsg = context.getString(R.string.error_code_10008);
//                break;
//            case ErrorCode.ERROR_CODE_10009:
//                errorMsg = context.getString(R.string.error_code_10009);
//                break;
//            case ErrorCode.ERROR_CODE_10010:
//                errorMsg = context.getString(R.string.error_code_10010);
//                break;
//            case ErrorCode.ERROR_CODE_10011:
//                errorMsg = context.getString(R.string.error_code_10011);
//                break;
//            case ErrorCode.ERROR_CODE_10012:
//                errorMsg = context.getString(R.string.error_code_10012);
//                break;
//            case ErrorCode.ERROR_CODE_10013:
//                errorMsg = context.getString(R.string.error_code_10013);
//                break;
//            case ErrorCode.ERROR_CODE_10014:
//                errorMsg = context.getString(R.string.error_code_10014);
//            case ErrorCode.ERROR_CODE_10015:
//                errorMsg = context.getString(R.string.error_code_10015);
//                break;
//            case ErrorCode.ERROR_CODE_10016:
//                errorMsg = context.getString(R.string.error_code_10016);
//                break;
//            case ErrorCode.ERROR_CODE_10017:
//                errorMsg = context.getString(R.string.error_code_10017);
//                break;
//            case ErrorCode.ERROR_CODE_10018:
//                errorMsg = context.getString(R.string.error_code_10018);
//                break;
//            case ErrorCode.ERROR_CODE_20001:
//                errorMsg = context.getString(R.string.error_code_20001);
//                break;
//            case ErrorCode.ERROR_CODE_20002:
//                errorMsg = context.getString(R.string.error_code_20002);
//                break;
//            case ErrorCode.ERROR_CODE_20003:
//                errorMsg = context.getString(R.string.error_code_20003);
//                break;
//            case ErrorCode.ERROR_CODE_20004:
//                errorMsg = context.getString(R.string.error_code_20004);
//                break;
//            case ErrorCode.ERROR_CODE_20005:
//                errorMsg = context.getString(R.string.error_code_20005);
//                break;
//            case ErrorCode.ERROR_CODE_20006:
//                errorMsg = context.getString(R.string.error_code_20006);
//                break;
//            case ErrorCode.ERROR_CODE_20007:
//                errorMsg = context.getString(R.string.error_code_20007);
//                break;
//            case ErrorCode.ERROR_CODE_20008:
//                errorMsg = context.getString(R.string.error_code_20008);
//                break;
//            case ErrorCode.ERROR_CODE_20009:
//                errorMsg = context.getString(R.string.error_code_20009);
//                break;
//            case ErrorCode.ERROR_CODE_20010:
//                errorMsg = context.getString(R.string.error_code_20010);
//                break;
//            case ErrorCode.ERROR_CODE_20011:
//                errorMsg = context.getString(R.string.error_code_20011);
//                break;
//            case ErrorCode.ERROR_CODE_20012:
//                errorMsg = context.getString(R.string.error_code_20012);
//                break;
//            case ErrorCode.ERROR_CODE_20013:
//                errorMsg = context.getString(R.string.error_code_20013);
//                break;
//            case ErrorCode.ERROR_CODE_20015:
//                errorMsg = context.getString(R.string.error_code_20015);
//                break;
//            case ErrorCode.ERROR_CODE_20016:
//                errorMsg = context.getString(R.string.error_code_20016);
//                break;
//            case ErrorCode.ERROR_CODE_20017:
//                errorMsg = context.getString(R.string.error_code_20017);
//                break;
//            case ErrorCode.ERROR_CODE_20018:
//                errorMsg = context.getString(R.string.error_code_20018);
//                break;
//            case ErrorCode.ERROR_CODE_20019:
//                errorMsg = context.getString(R.string.error_code_20019);
//                break;
//            case ErrorCode.ERROR_CODE_20020:
//                errorMsg = context.getString(R.string.error_code_20020);
//                break;
//            case ErrorCode.ERROR_CODE_30012:
//                errorMsg = context.getString(R.string.error_code_30012);
//                ;
//                break;
//            case ErrorCode.ERROR_CODE_40001:
//                errorMsg = context.getString(R.string.error_code_40001);
//                break;
//            case ErrorCode.ERROR_CODE_40002:
//                errorMsg = context.getString(R.string.error_code_40002);
//                break;
//            case ErrorCode.ERROR_CODE_40003:
//                errorMsg = context.getString(R.string.error_code_40003);
//                break;
//            case ErrorCode.ERROR_CODE_40004:
//                errorMsg = context.getString(R.string.error_code_40004);
//                break;
//            case ErrorCode.ERROR_CODE_40005:
//                errorMsg = context.getString(R.string.error_code_40005);
//                break;
//            case ErrorCode.ERROR_CODE_40006:
//                errorMsg = context.getString(R.string.error_code_40006);
//                break;
//            case ErrorCode.ERROR_CODE_40007:
//                errorMsg = context.getString(R.string.error_code_40007);
//                break;
//            case ErrorCode.ERROR_CODE_40008:
//                errorMsg = context.getString(R.string.error_code_40008);
//                break;
//            case ErrorCode.ERROR_CODE_50001:
//                errorMsg = context.getString(R.string.error_code_50001);
//                break;
//            case ErrorCode.ERROR_CODE_50002:
//                errorMsg = context.getString(R.string.error_code_50002);
//                break;
//            case ErrorCode.ERROR_CODE_50003:
//                errorMsg = context.getString(R.string.error_code_50003);
//                break;
//            case ErrorCode.ERROR_CODE_50004:
//                errorMsg = context.getString(R.string.error_code_50004);
//                break;
//            case ErrorCode.ERROR_CODE_50005:
//                errorMsg = context.getString(R.string.error_code_50005);
//                break;
//            case ErrorCode.ERROR_CODE_50007:
//                errorMsg = context.getString(R.string.error_code_50007);
//                break;
//            case ErrorCode.ERROR_CODE_50008:
//                errorMsg = context.getString(R.string.error_code_50008);
//                break;
//            case ErrorCode.ERROR_CODE_50009:
//                errorMsg = context.getString(R.string.error_code_50009);
//                break;
//            case ErrorCode.ERROR_CODE_50010:
//                errorMsg = context.getString(R.string.error_code_50010);
//                break;
//            case ErrorCode.ERROR_CODE_50011:
//                errorMsg = context.getString(R.string.error_code_50011);
//                break;
//            case ErrorCode.ERROR_CODE_50012:
//                errorMsg = context.getString(R.string.error_code_50012);
//                break;
//            case ErrorCode.ERROR_CODE_70001:
//                errorMsg = context.getString(R.string.error_code_70001);
//                break;
//            case ErrorCode.ERROR_CODE_70002:
//                errorMsg = context.getString(R.string.error_code_70002);
//                break;
//            case ErrorCode.ERROR_CODE_70003:
//                errorMsg = context.getString(R.string.error_code_70003);
//                break;
//            case ErrorCode.ERROR_CODE_70004:
//                errorMsg = context.getString(R.string.error_code_70004);
//                break;
//            case ErrorCode.ERROR_CODE_70005:
//                errorMsg = context.getString(R.string.error_code_70005);
//                break;
//            case ErrorCode.ERROR_CODE_70006:
//                errorMsg = context.getString(R.string.error_code_70006);
//                break;
//            default:
//                errorMsg = errorDescription;
//        }
//        return errorMsg;
//    }

    private static boolean isNetworkProblem(VolleyError error) {
        return (error instanceof NetworkError || error instanceof NoConnectionError);
    }

    /**
     * Invoke to showing dialog for showing error message
     *
     * @param context
     * @param error
     */
    public static void showDialog(final Context context, VolleyError error) {

        if (context == null) {
            return;
        }
        final String errorMsg = getErrorMessage(context, error);
        Log.i("Error-MSG:", " " + errorMsg);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvShowError = (TextView) dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = (TextView) dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvShowError.setText(errorMsg);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> {
            errorDialog.dismiss();
        });

        errorDialog.show();

    }

//    /**
//     * Invoke to showing dialog for showing error message
//     *
//     * @param context
//     * @param jsonString
//     */
//    public static void showDialog(final Context context, String jsonString) {
//
//        if (context == null) {
//            return;
//        }
//        final String errorMsg = getErrorMessage(context, jsonString);
//        Log.i("Error-MSG:", " " + errorMsg);
//
//        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
//        TextView tvShowError = (TextView) dialogView.findViewById(R.id.tv_show_error);
//        TextView btnOk = (TextView) dialogView.findViewById(R.id.btn_error_ok);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        final Dialog errorDialog = builder.setView(dialogView).create();
//
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.copyFrom(errorDialog.getWindow().getAttributes());
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.MATCH_PARENT;
//        tvShowError.setText(errorMsg);
//        errorDialog.setCancelable(false);
//        errorDialog.getWindow().setAttributes(params);
//        btnOk.setOnClickListener(v -> {
//            if (errorMsg.contains(context.getString(R.string.error_code_10007))
//                    || errorMsg.contains(context.getString(R.string.error_code_40002))
//                    || errorMsg.contains(context.getString(R.string.error_code_40014))) {
//                DataManager.getInstance().removeTokenAndInfo();
//                Fragment fragment = new LoginFragment();
//                UtilityFunctions.changeFragment((FragmentActivity) context, fragment, false, false);
//            }
//            errorDialog.dismiss();
//        });
//
//        errorDialog.show();
//
//    }
}
