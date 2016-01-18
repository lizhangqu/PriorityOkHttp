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
        Request request2 = request0.newBuilder().priority(2).build();
        Request request3 = request0.newBuilder().priority(40).build();
        Request request4 = request0.newBuilder().priority(20).build();
        Request request5 = request0.newBuilder().priority(30).build();
        Request request6 = request0.newBuilder().priority(10).build();
        Request request7 = request0.newBuilder().priority(5).build();
        Request request8 = request0.newBuilder().priority(34).build();
        Request request9 = request0.newBuilder().priority(100).build();
        Request request10 = request0.newBuilder().priority(500).build();


        Call call1= okHttpClient.newCall(request1);
        Call call2= okHttpClient.newCall(request2);
        Call call3= okHttpClient.newCall(request3);
        Call call4= okHttpClient.newCall(request4);
        Call call5= okHttpClient.newCall(request5);
        Call call6= okHttpClient.newCall(request6);
        Call call7= okHttpClient.newCall(request7);
        Call call8= okHttpClient.newCall(request8);
        Call call9= okHttpClient.newCall(request9);
        Call call10= okHttpClient.newCall(request10);


        call1.enqueue(callback);
        call2.enqueue(callback);
        call3.enqueue(callback);
        call4.enqueue(callback);
        call5.enqueue(callback);
        call6.enqueue(callback);
        call7.enqueue(callback);
        call8.enqueue(callback);
        call9.enqueue(callback);
        call10.enqueue(callback);

    }
}
