package test.mb.mobiledevtestmb.aplication.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import test.mb.mobiledevtestmb.R;
import test.mb.mobiledevtestmb.utils.models.seach.FilterModel;

public class AdapterSortList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FilterModel> list;


    AdapterSortList(Context context, List<FilterModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(viewType == VIEW_TYPE_HEADER){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.i_sort_header, parent, false);
            return new ViewHolderHeader(v);
        }
        if(viewType == VIEW_TYPE_SETTINGS){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.i_sort, parent, false);
            return new ViewHolderSettings(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position){
        if(viewHolder instanceof ViewHolderSettings){
            final FilterModel model = list.get(viewHolder.getAdapterPosition() - 1);
            ((ViewHolderSettings) viewHolder).tv_name.setText(model.getValue());
            ((ViewHolderSettings) viewHolder).ch_value.setChecked(model.isCheck());
            ((ViewHolderSettings) viewHolder).ch_value.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    model.setCheck(isChecked);
                }
            });

        }

//        if(viewHolder instanceof ViewHolderArticles){
////            final ArticleModel articleModel = listArticles.get(viewHolder.getAdapterPosition() - listFolders.size());
////            ((ViewHolderArticles) viewHolder).textHeader.setVisibility(View.GONE);
//        }
    }

    private final int VIEW_TYPE_HEADER = 0;
    private final int VIEW_TYPE_SETTINGS = 1;

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_SETTINGS;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }


    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        public ViewHolderHeader(View itemView){
            super(itemView);
        }
    }

    public class ViewHolderSettings extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private CheckBox ch_value;
        public ViewHolderSettings(View itemView){
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            ch_value = itemView.findViewById(R.id.ch_value);
        }
    }
}
