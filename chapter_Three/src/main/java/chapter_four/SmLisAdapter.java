package chapter_four;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eaglei.android_heros_demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eagle on 2016/6/16.
 */
public class SmLisAdapter extends BaseAdapter{

    private List<String> mLists = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public SmLisAdapter(List<String> mLists, Context context) {
        this.mLists = mLists;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null){
            mHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_smlview,parent,false);
            mHolder.findView(convertView);
            convertView.setTag(mHolder);
        }else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.textView.setText(mLists.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView textView;
        void findView(View view){
            textView = (TextView) view.findViewById(R.id.slv_tv);
        }
    }
}
