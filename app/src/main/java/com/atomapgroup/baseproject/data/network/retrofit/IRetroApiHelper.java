package com.atomapgroup.halalfood.data.network.retrofit;

import com.atomapgroup.halalfood.data.model.BaseRecipe;
import com.atomapgroup.halalfood.data.network.ApiUrls;
import com.atomapgroup.halalfood.data.network.Endpoints;
import com.atomapgroup.halalfood.data.network.retrofit.model.BaseRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.BaseResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.ChangePasswordRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.ChangePasswordResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.ForgetPasswordRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.ForgetPasswordResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.LoadCreateRecipeInfoRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.LoadCreateRecipeInfoResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.LoginRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.LoginResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.LogoutRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.ProfileUpdateRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.ProfileUpdateResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.ProfileViewRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.ProfileViewResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.RecipeDetailsRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.RecipeDetailsResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.RecipeListRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.RecipeListResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.RegistrationRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.SearchRecipeRequest;
import com.atomapgroup.halalfood.data.network.retrofit.model.SearchRecipeResponse;
import com.atomapgroup.halalfood.data.network.retrofit.model.SuggessionRecipeResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by AtomAP Ltd. on 2/23/2018.
 */

public interface IRetroApiHelper {

    @POST(ApiUrls.LOGIN_API_URL)
    Call<LoginResponse> invokeLoginApi(@Body LoginRequest body);

    @POST(ApiUrls.LOGOUT_API_URL)
    Call<BaseResponse> invokeLogoutApi(@Body LogoutRequest body);

    @POST(ApiUrls.REGISTRATION_API_URL)
    Call<LoginResponse> invokeRegistrationApi(@Body RegistrationRequest body);

    @POST(ApiUrls.FORGET_PASSWORD_API_URL)
    Call<ForgetPasswordResponse> invokeForgePasswordApi(@Body ForgetPasswordRequest body);

    @POST(ApiUrls.CHANGE_PASSWORD_API_URL)
    Call<ChangePasswordResponse> invokeChangePasswordApi(@Body ChangePasswordRequest body);

    @POST(ApiUrls.RECIPE_LIST_API_URL)
    Call<RecipeListResponse> invokeRecipeListApi(@Body RecipeListRequest body);

    @POST(ApiUrls.RECIPE_DETAILS_API_URL)
    Call<RecipeDetailsResponse> invokeRecipeDetailsApi(@Body RecipeDetailsRequest body);

    @POST(ApiUrls.MY_PROFILE_API_URL)
    Call<ProfileViewResponse> invokeProfileViewApi(@Body ProfileViewRequest body);

    @POST(ApiUrls.UPDATE_PROFILE_API_URL)
    Call<ProfileUpdateResponse> invokeProfileUpdateApi(@Body ProfileUpdateRequest body);

    @POST(ApiUrls.LOAD_CREATE_RECIPE_INFO_API_URL)
    Call<LoadCreateRecipeInfoResponse> invokeLoadCreateRecipeInfoApi(@Body LoadCreateRecipeInfoRequest body);

    @Multipart
    @POST(ApiUrls.CREATE_RECIPE_API_URL)
    Call<BaseResponse> invokeCreateRecipeApi(
            @Part(Endpoints.REQUEST_BODY) RequestBody body,
            @Part List<MultipartBody.Part> files
    );

    @POST(ApiUrls.SEARCH_SUGGESSION_API_URL)
    Call<SuggessionRecipeResponse> invokeSearchSuggessionApi(@Body BaseRequest body);

    @POST(ApiUrls.SEARCH_API_URL)
    Call<SearchRecipeResponse> invokeSearchApi(@Body SearchRecipeRequest body);

}
