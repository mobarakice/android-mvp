//package com.atomapgroup.baseproject.utils;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//
//import java.text.DateFormat;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.TimeZone;
//
///**
// * Created by Mobarak on 18-Jan-18.
// */
//
//public class DateTimePickerDialog extends DialogFragment {
//    // Date & Time formatter used for formatting
//    // text on the switcher button
//    DateFormat mDateFormatter, mTimeFormatter;
//
//    // Picker
//    SublimePicker mSublimePicker;
//
//    // IDateTimePickerCallback to activity
//    IDateTimePickerCallback mIDateTimePickerCallback;
//
//    SublimeListenerAdapter mListener = new SublimeListenerAdapter() {
//        @Override
//        public void onCancelled() {
////            if (mIDateTimePickerCallback != null) {
////                mIDateTimePickerCallback.onCancelled();
////            }
//            // Should actually be called by activity inside `IDateTimePickerCallback.onCancelled()`
//            dismiss();
//        }
//
//        @Override
//        public void onDateTimeRecurrenceSet(SublimePicker sublimeMaterialPicker,
//                                            SelectedDate selectedDate,
//                                            int hourOfDay, int minute,
//                                            SublimeRecurrencePicker.RecurrenceOption recurrenceOption,
//                                            String recurrenceRule) {
//            if (mIDateTimePickerCallback != null) {
////                mIDateTimePickerCallback.onDateTimeChangedListener(selectedDate, hourOfDay, minute);
//                mIDateTimePickerCallback.onDateTimeChangedListener(formatDate(selectedDate) + " " + hourOfDay + ":" + minute + ":00");
//            }
//
//            dismiss();
//        }
//
//        @Override
//        public CharSequence formatDate(SelectedDate selectedDate) {
//            return selectedDate.getFirstDate().get(Calendar.YEAR)
//                    + "-" + (1 + selectedDate.getFirstDate().get(Calendar.MONTH))
//                    + "-" + selectedDate.getFirstDate().get(Calendar.DAY_OF_MONTH);
//        }
//    };
//
//
//    public DateTimePickerDialog() {
//        // Initialize formatters
//        mDateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
//        mTimeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
//        mTimeFormatter.setTimeZone(TimeZone.getTimeZone("GMT+0"));
//    }
//
//    // Set activity IDateTimePickerCallback
//    public void setCallback(IDateTimePickerCallback IDateTimePickerCallback) {
//        mIDateTimePickerCallback = IDateTimePickerCallback;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        mSublimePicker = (SublimePicker) getActivity()
//                .getLayoutInflater().inflate(R.layout.sublime_picker, container);
//
//        // Retrieve SublimeOptions
//        Bundle arguments = getArguments();
//        SublimeOptions options = null;
//
//        // Options can be null, in which case, default
//        // options are used.
//        if (arguments != null) {
//            options = arguments.getParcelable("SUBLIME_OPTIONS");
//        }
//
//        mSublimePicker.initializePicker(options, mListener);
//        return mSublimePicker;
//    }
//
//    public interface IDateTimePickerCallback {
//
////        void onCancelled();
//
////        void onDateTimeChangedListener(SelectedDate selectedDate, int hourOfDay, int minute);
//
//        void onDateTimeChangedListener(CharSequence dateTime);
//    }
//
//}