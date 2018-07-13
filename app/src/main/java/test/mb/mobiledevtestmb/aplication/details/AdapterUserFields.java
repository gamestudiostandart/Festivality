package test.mb.mobiledevtestmb.aplication.details;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.mb.mobiledevtestmb.R;
import test.mb.mobiledevtestmb.utils.models.seach.UserField;

public class AdapterUserFields extends RecyclerView.Adapter<AdapterUserFields.ViewHolder> {

    private List<UserField> list;

    public AdapterUserFields() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterUserFields.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.i_user_field, parent, false);
        return new AdapterUserFields.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterUserFields.ViewHolder holder, final int position) {
        UserField model = list.get(position);
        holder.tv_head.setText(model.getName());
        holder.tv_body.setText(model.getValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_head, tv_body;
        ViewHolder(View itemView) {
            super(itemView);
            tv_head = itemView.findViewById(R.id.tv_head);
            tv_body = itemView.findViewById(R.id.tv_body);
        }
    }

    public void setList(List<UserField> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
