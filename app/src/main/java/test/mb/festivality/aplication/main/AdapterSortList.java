package test.mb.festivality.aplication.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import test.mb.festivality.R;
import test.mb.festivality.utils.models.Fields;
import test.mb.festivality.utils.models.seach.FilterModel;
import test.mb.festivality.utils.models.seach.SearchFilter;

public class AdapterSortList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private SearchFilter SearchFilter;

    AdapterSortList(Context context, SearchFilter SearchFilter) {
        this.context = context;
        this.SearchFilter = SearchFilter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.i_sort_header, parent, false);
            return new ViewHolderHeader(v);
        }
        if (viewType == VIEW_TYPE_SETTINGS) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.i_sort, parent, false);
            return new ViewHolderSettings(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof ViewHolderSettings) {
            final FilterModel model = SearchFilter.getList().get(viewHolder.getAdapterPosition() - 1);
            ((ViewHolderSettings) viewHolder).tv_name.setText(model.getName());
            ((ViewHolderSettings) viewHolder).ch_value.setChecked(model.isCheck());
            ((ViewHolderSettings) viewHolder).ch_value.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    model.setCheck(isChecked);
                    clickCallback.click();
                }
            });

            if (model.getValue().equals(Fields.AGE)) {
                ((ViewHolderSettings) viewHolder).ll_seek_bar.setVisibility(View.VISIBLE);
                ((ViewHolderSettings) viewHolder).rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue, Number maxValue) {
                        ((ViewHolderSettings) viewHolder).tv_from.setText(String.valueOf(minValue));
                        ((ViewHolderSettings) viewHolder).tv_to.setText(String.valueOf(maxValue));
                        SearchFilter.setAgeFrom(Integer.parseInt(String.valueOf(minValue)));
                        SearchFilter.setAgeTo(Integer.parseInt(String.valueOf(maxValue)));

                    }
                });
                ((ViewHolderSettings) viewHolder).rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
                    @Override
                    public void finalValue(Number minValue, Number maxValue) {
                        clickCallback.click();
                    }
                });
            }

        }
    }

    private final int VIEW_TYPE_HEADER = 0;
    private final int VIEW_TYPE_SETTINGS = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_SETTINGS;
        }
    }

    @Override
    public int getItemCount() {
        return SearchFilter.getList().size() + 1;
    }


    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        public ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderSettings extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_from, tv_to;
        private CheckBox ch_value;
        private CrystalRangeSeekbar rangeSeekbar;
        private LinearLayout ll_seek_bar;

        public ViewHolderSettings(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_from = itemView.findViewById(R.id.tv_from);
            tv_to = itemView.findViewById(R.id.tv_to);
            ch_value = itemView.findViewById(R.id.ch_value);
            rangeSeekbar = itemView.findViewById(R.id.rangeSeekbar);
            ll_seek_bar = itemView.findViewById(R.id.ll_seek_bar);
        }
    }

    public interface ClickCallback {
        void click();
    }

    private ClickCallback clickCallback;

    public void registerClickCallbackk(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }
}
