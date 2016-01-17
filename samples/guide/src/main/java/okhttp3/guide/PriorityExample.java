package okhttp3.guide;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by lizhangqu on 16/1/17.
 */
public class PriorityExample {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            System.out.println(response.request().priority() + "===" + response);
        }
    };

    public static void main(String[] args) {
        Request.Builder builder1 = new Request.Builder();
        Request request0 = builder1.url("https://www.baidu.com").build();

        Request request1 = request0.newBuilder().priority(14).build();
        Request request2 = request1.newBuilder().priority(2).build();
        Request request3 = request1.newBuilder().priority(40).build();
        Request request4 = request1.newBuilder().priority(20).build();
        Request request5 = request1.newBuilder().priority(30).build();


        Request request6 = request1.newBuilder().priority(10).build();
        Request request7 = request1.newBuilder().priority(5).build();
        Request request8 = request1.newBuilder().priority(34).build();
        Request request9 = request1.newBuilder().priority(100).build();
        Request request10 = request1.newBuilder().priority(500).build();
        okHttpClient.newCall(request1).enqueue(callback);
        okHttpClient.newCall(request2).enqueue(callback);
        okHttpClient.newCall(request3).enqueue(callback);
        okHttpClient.newCall(request4).enqueue(callback);
        okHttpClient.newCall(request5).enqueue(callback);
//        okHttpClient.newCall(request6).enqueue(callback);
//        okHttpClient.newCall(request7).enqueue(callback);
//        okHttpClient.newCall(request8).enqueue(callback);
//        okHttpClient.newCall(request9).enqueue(callback);
//        okHttpClient.newCall(request10).enqueue(callback);
    }
}
