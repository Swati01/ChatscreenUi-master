package com.example.advantal.chatscreenui;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by advantal on 2/16/2016.
 */
public class ContactUi extends Activity {
    private static final String TAG="CHAT ACTIVITY";

            private chatarrayadapter chatAdapter;


  private  Button send;
    private EditText chatxt;
    private ListView list;
    private boolean side=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactui);
        send=(Button)findViewById(R.id.sendButton);
        chatxt=(EditText)findViewById(R.id.message);
        list=(ListView)findViewById(R.id.list);
        chatAdapter=new chatarrayadapter(getApplicationContext(),R.layout.right);
        list.setAdapter(chatAdapter);
       /* chatxt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)) {
                    {
                        String s;
                        s = chatxt.getText().toString();
                        chatxt.setText(s + System.getProperty("line.separator"));
                    }
                }return false;
            }
        });*/
        //tv=(TextView)findViewById(R.id.messageSet);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendchatmessage();
            }
                /*String str=chatxt.getText().toString();
                if(str!=null)
                {
                    //tv.setText(str);
                    chatxt.setText("");
                }
                else
                {
                    Context context=getApplicationContext();
                    Toast.makeText(context,"Enter Some Text",Toast.LENGTH_SHORT).show();
                }
            }*/
        });
        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(chatAdapter);

        chatAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                list.setSelection(chatAdapter.getCount()-1);
            }
        });
    }
    private boolean sendchatmessage() {
String text;
        text=chatxt.getText().toString();
        text=text.trim();

        if (TextUtils.isEmpty(text)){//text.contains("\n")) {
        }else{

            Log.d("check",text);
                chatAdapter.add(new chatmsg(side, chatxt.getText().toString()));
                chatxt.setText(" ");
                side = !side;
                return true;
            }
        return true;
        }
       /* if (chatxt.getText().toString().equalsIgnoreCase(" ") || chatxt.getText().toString().isEmpty() ||chatxt.getText().toString().equals("\n")) {
        }
        else {
            chatAdapter.add(new chatmsg(side, chatxt.getText().toString()));

            chatxt.setText(" ");
            side = !side;



    }*/}
