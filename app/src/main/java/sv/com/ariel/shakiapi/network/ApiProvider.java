package sv.com.ariel.shakiapi.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public class ApiProvider {
    public ApiClient registerWorkshopClientWithAuthToken(String token) {


        //Create a new Interceptor.
        Interceptor headerAuthorizationInterceptor = chain -> {
            Request request = chain.request();
            Headers headers = request.headers().newBuilder().add("Authorization", "Bearer "+token).build();
            request = request.newBuilder().headers(headers).build();
            return chain.proceed(request);
        };

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(headerAuthorizationInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS).build();


        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.BASE_FINAL_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiClient.class);
    }


    public ApiClient registerDasClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()

                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS).build();

        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.BASE_FINAL_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiClient.class);
    }
}
