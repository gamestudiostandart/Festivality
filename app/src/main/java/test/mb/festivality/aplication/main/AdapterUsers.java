package test.mb.festivality.aplication.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import test.mb.festivality.R;
import test.mb.festivality.aplication.details.ActivityUserPage;
import test.mb.festivality.utils.models.User;
import test.mb.festivality.utils.views.CircleTransform;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.ViewHolder> {

    private Context context;
    private List<User> list;

    AdapterUsers(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterUsers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.i_user_list, parent, false);
        return new AdapterUsers.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterUsers.ViewHolder holder, final int position) {

        final User user = list.get(position);

        if(user.getCustomFields() != null){
            holder.tv_name.setText(!TextUtils.isEmpty(user.getCustomFields().getFullName())?user.getCustomFields().getFullName():String.valueOf(user.getId()));
            if (!TextUtils.isEmpty(user.getCustomFields().getPosition())) {
                holder.tv_description.setText(user.getCustomFields().getPosition());
                if(!TextUtils.isEmpty(user.getCustomFields().getCompany())){
                    String description = user.getCustomFields().getPosition() + " at " + TextUtils.isEmpty(user.getCustomFields().getCompany());
                    holder.tv_description.setText(description);
                }
            }
        } else {
            holder.tv_name.setText(String.valueOf(user.getId()));
            holder.tv_description.setText(String.valueOf(user.getId()));
        }

        if(user.getMedia() != null && user.getMedia().size() > 0){
            Glide.with(context)
                    .load(user.getMedia().get(0).getFiles().getDefault())
                    .fitCenter()
                    .placeholder(R.drawable.ic_account_circle)
                    .transform(new CircleTransform(context))
                    .into(holder.iv_photo);
        }

        holder.rl_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(context, ActivityUserPage.class);
                activity.putExtra(ActivityUserPage.USER_OBJEKT, new Gson().toJson(user));
                context.startActivity(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_photo;
        private TextView tv_name, tv_description;
        private FrameLayout rl_click;

        ViewHolder(View itemView) {
            super(itemView);
            rl_click = itemView.findViewById(R.id.rl_click);
            iv_photo = itemView.findViewById(R.id.iv_photo);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }

    public void animateTo(List<User> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<User> newModels) {
        for (int i = list.size() - 1; i >= 0; i--) {
            final User model = list.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<User> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final User model = newModels.get(i);
            if (!list.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<User> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final User model = newModels.get(toPosition);
            final int fromPosition = list.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public User removeItem(int position) {
        final User model = list.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, User model) {
        list.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final User model = list.remove(fromPosition);
        list.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void paging(List<User> newModels){
        int positionStart = getItemCount();
        list.addAll(newModels);
        notifyItemRangeInserted(positionStart, list.size() - 1);
    }
}
