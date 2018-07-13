package test.mb.festivality.aplication.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import test.mb.festivality.R;


public class FragmentConfirm extends Fragment {

    public FragmentConfirm() {}

    public static FragmentConfirm newInstance() {
        return new FragmentConfirm();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_permission_confirm, container, false);
        TextView tv_start = v.findViewById(R.id.tv_start);
        tv_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityLogin)Objects.requireNonNull(getContext())).permissionDone();
            }
        });
        return v;
    }
}
