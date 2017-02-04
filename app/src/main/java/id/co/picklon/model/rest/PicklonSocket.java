package id.co.picklon.model.rest;

import com.google.gson.Gson;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import id.co.picklon.utils.L;
import id.co.picklon.utils.Picklon;

public class PicklonSocket {
    private static final String ADDR = "ws://ateam.ticp.io:55151/";

    private WebSocket webSocket = null;
    private OnStringCallback callBack;

    public WebSocket getDefault() {
        if (webSocket == null) {
            try {
                webSocket = AsyncHttpClient.getDefaultInstance().websocket(ADDR, null, this::handleCompleted).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }
        return webSocket;
    }

    private void handleCompleted(Exception ex, WebSocket socket) {
        if (ex != null) return;

        L.e("connected");
        login();

        socket.setStringCallback(s -> {
            //  heart beating
            if (s.contains("ping")) {
                return;
            }

            if (callBack != null) {
                callBack.onString(s);
            }
        });

        socket.setDataCallback((emitter, bb) -> {
            L.e("i got some bytes!");
            bb.recycle();
        });

        socket.setClosedCallback(ex1 -> {
            if (ex1 != null && !(ex1 instanceof IOException)) throw new RuntimeException(ex1);
            webSocket = null;
            L.e("[Client] Successfully closed connection");
        });

        socket.setEndCallback(ex1 -> {
            if (ex1 != null) throw new RuntimeException(ex1);
            L.e("[Client] Successfully end connection");
        });
    }

    private void login() {
        Map<String, String> map = new HashMap<>();
        map.put("tk", Picklon.TOKEN);
        Map<String, String> ss = new HashMap<>();
        ss.put("d", new Gson().toJson(map));
        ss.put("path", "10001");
        send(new Gson().toJson(ss));
    }

    public void send(Object object) {
        if (webSocket == null) {
            return;
        }
        webSocket.send(object.toString());
    }

    public void close() {
        if (webSocket != null && webSocket.isOpen()) {
            webSocket.close();
            webSocket = null;
        }
    }

    public void setOnStringCallback(OnStringCallback callBack) {
        this.callBack = callBack;
    }

    public interface OnStringCallback {
        void onString(String msg);
    }
}
