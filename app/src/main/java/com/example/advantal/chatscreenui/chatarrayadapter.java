package com.example.advantal.chatscreenui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by advantal on 18-Feb-16.
 */
public class chatarrayadapter extends ArrayAdapter<chatmsg> {

    private TextView chattext;
    private List<chatmsg> chatMessageList=new ArrayList<>();
    private Context context;

    public chatarrayadapter(Context context, int resource) {
        super(context, resource);
        this.context=context;
    }


    @Override
    public void add(chatmsg object)
    {
        chatMessageList.add(object);
        super.add(object);
    }
  public int getCount()
  {
      return  this.chatMessageList.size();

  }
    public  chatmsg getItem(int index)
    {
        return this.chatMessageList.get(index);
    }
    @Override
public View getView(int position,View convertview,ViewGroup parent)
{
    chatmsg object=getItem(position);
    View row=convertview;
    LayoutInflater inflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if(object.left)
    {
        row=inflater.inflate(R.layout.right,parent,false);
            }
else
    {
        row=inflater.inflate(R.layout.left,parent,false);
    }
chattext=(TextView)row.findViewById(R.id.msgr);
    chattext.setText(object.message);
    return row;

}
}
