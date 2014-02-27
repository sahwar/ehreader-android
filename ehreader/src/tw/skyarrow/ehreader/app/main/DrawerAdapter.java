package tw.skyarrow.ehreader.app.main;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tw.skyarrow.ehreader.R;
import tw.skyarrow.ehreader.app.BaseListAdapter;

/**
 * Created by SkyArrow on 2014/2/27.
 */
public class DrawerAdapter extends BaseListAdapter<DrawerItem> {
    public DrawerAdapter(Context context, List<DrawerItem> list) {
        super(context, list);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        DrawerItem drawerItem = getItem(i);

        if (view == null) {
            view = getInflater().inflate(R.layout.navigation_drawer_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
            view.setClickable(true);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(drawerItem.getName());
        holder.icon.setImageDrawable(getIcon(drawerItem.getIcon()));

        if (drawerItem.isSelected()) {
            holder.name.setTypeface(null, Typeface.BOLD);
        } else {
            holder.name.setTypeface(null, Typeface.NORMAL);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(i);
            }
        });

        return view;
    }

    private Drawable getIcon(int res) {
        return getContext().getResources().getDrawable(res);
    }

    static final class ViewHolder {
        @InjectView(R.id.name)
        TextView name;

        @InjectView(R.id.icon)
        ImageView icon;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    public void onItemClick(int i) {
        //
    }
}