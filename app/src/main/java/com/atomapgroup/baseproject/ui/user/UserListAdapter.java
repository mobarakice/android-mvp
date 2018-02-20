package com.atomapgroup.baseproject.ui.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atomapgroup.baseproject.R;
import com.atomapgroup.baseproject.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mobarak Hosen on 2/20/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {

    private Context context;
    private List<User> users;

    public UserListAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }

    public void addAll(List<User> list) {
        if (users == null || list == null || list.isEmpty()) {
            return;
        }

        users.clear();
        users.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public UserListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new UserListHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListHolder holder, int position) {
        holder.tvUser.setText(users.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    protected static class UserListHolder extends RecyclerView.ViewHolder {
        TextView tvUser;

        public UserListHolder(View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tv_user);
        }
    }
}
