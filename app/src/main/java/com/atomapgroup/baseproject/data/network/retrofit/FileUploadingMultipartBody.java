package com.atomapgroup.halalfood.data.network.retrofit;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.atomapgroup.halalfood.data.network.retrofit.model.UploadFiles;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Mobarak on 07-Mar-18.
 */

public class FileUploadingMultipartBody {

    private RequestBody requestBody;
    private List<MultipartBody.Part> partFiles;


    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(@NotNull String body) {
        this.requestBody = createPartFromString(body);
    }

    public List<MultipartBody.Part> getPartFiles() {
        return partFiles;
    }

    public void setPartFiles(@NotNull List<UploadFiles> files) {
        this.partFiles = getMultipartFiles(files);
    }

    private List<MultipartBody.Part> getMultipartFiles(List<UploadFiles> files) {
        List<MultipartBody.Part> parts = new ArrayList<>();
        for (UploadFiles file : files) {
            if (file != null) {
                parts.add(createFilePart(file.getFileName(), file.getFilePath()));
            }
        }
        return parts;
    }


    private RequestBody createPartFromString(@NotNull String body) {
        return RequestBody.create(MultipartBody.FORM, body);
    }

    private MultipartBody.Part createFilePart(String partName, String filePath) {
        File file = getTempFile(filePath);
        MediaType mediaType = MediaType.parse("image/*");
        RequestBody requestBody = RequestBody.create(mediaType, file);
        return MultipartBody.Part.createFormData(partName, file.getName(), requestBody);
    }

    private File getTempFile(String path) {
        File file = null;
        try {
            if (path == null || TextUtils.isEmpty(path)) {
//                file = new File(FoodlleeVendorApp.getAppContext().getExternalFilesDir(Constants.FOODLLEE_DIRECTORY) + File.separator + "temp.jpg");
                file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.jpg");
                Log.i("FileSize", "" + file.length() / 1024);
                if (!file.exists()) {
                    boolean isCreate = file.createNewFile();
                    Log.i("FileCreate", "" + isCreate);
                }
            } else {
                file = new File(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
