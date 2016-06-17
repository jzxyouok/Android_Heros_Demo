package chapter_four;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eaglei.android_heros_demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eagle on 2016/6/17.
 */
public class ChatItemAdapter extends BaseAdapter{
    private List<ChatItemListViewBean> mData = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public ChatItemAdapter(List<ChatItemListViewBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null){
            if (getItemViewType(position) == 0){
                mHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_chat_in , parent , false);
                mHolder.textView = (TextView) convertView.findViewById(R.id.tv_in);
                mHolder.imageView = (ImageView) convertView.findViewById(R.id.icon_in);
            }else{
                mHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_chat_out , parent , false);
                mHolder.textView = (TextView) convertView.findViewById(R.id.tv_out);
                mHolder.imageView = (ImageView) convertView.findViewById(R.id.icon_out);
            }
            convertView.setTag(mHolder);
        }else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.imageView.setImageBitmap(mData.get(position).getIcon());
        mHolder.textView.setText(mData.get(position).getText());
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemListViewBean mBean = mData.get(position);
        return mBean.getType();
    }

    class ViewHolder {
        private TextView textView;
        private ImageView imageView;
    }
}
