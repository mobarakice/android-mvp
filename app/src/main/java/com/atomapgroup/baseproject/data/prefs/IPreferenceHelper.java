package com.atomapgroup.baseproject.data.prefs;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * This is SharedPreference helper interface
 * Created by Mobarak. on 26-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public interface IPreferenceHelper {

    void setAuthToken(@NonNull String token);

    String getAuthToken();

    void setTerminalId(@NonNull String terminalId);

    String getTerminalId();

    void setFcmToken(@NonNull String token);

    String getFcmToken();

    void setLocaleParsistData(@NonNull Context context, String language);

    String getLocalePersistedData(Context context, String defaultLanguage);
}
