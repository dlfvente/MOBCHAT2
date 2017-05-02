package com.example.deboradlf_guillermopd.mobchat2.adapters;

import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ListActivity;

import com.example.deboradlf_guillermopd.mobchat2.R;



//LISTENERS
public interface OnServiceConnectionListener {
    void onServiceConnection(WebSocket ws);
}
...
public interface OnReceiveListener {
    void onReceive(WebSocket ws, Message message);
}




public class ChatActivity extends ListActivity implements
        TextView.OnEditorActionListener, View.OnClickListener,
        OnServiceConnectionListener, OnReceiveListener {
    String[] args; // { host, port, nick }
    TextView tv;   // nick@host:port
    ArrayAdapter<Message> messages;
    EditText text;
    Button send;

    private WebSocket ws;

    private String[] readArgs() {
        //return arguments array
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        // set args

        // set tv
        // set messages adapter to ListView
        // set text, send
        // set OnEditorActionListener to text
        // set OnClickListener to send

        // create WebSocket, pass Context, WebSocket URI and OnServiceConnectionListener
        WebSocket.create(this, String.format("ws://%s:%s/DMOBServer3/chat",
                args[0], args[1]), this);
    }

    @Override
    public void onServiceConnection(WebSocket ws) {
        // set this.ws
        // set OnReceiveListener to ws
        ws.receive(this);
    }

    @Override
    public void onReceive(WebSocket ws, Message message) {
        // add message to messages
    }

    private void addMessage() {
        // create LocalMessage with text, nick and date
        // add message to messages
        // send message
        ws.send(message);
        ...
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        ...

        addMessage();
        return true;
    }

    @Override
    public void onClick(View view) {
        addMessage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ws.close();
    }

}