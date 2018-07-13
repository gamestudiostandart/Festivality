package test.mb.mobiledevtestmb.aplication.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import test.mb.mobiledevtestmb.R;

public class FragmentPermission extends Fragment implements View.OnClickListener {

    private static final String IMAGE_ID = "imageId";
    private static final String HEAD = "head";
    private static final String BODY = "body";
    private static final String BUTTON_ENABLE = "buttonEnabled";

    private int imageId;
    private int head;
    private int body;
    private String buttonEnabled;

    private OnFragmentInteractionListener mListener;

    public FragmentPermission() {
        // Required empty public constructor
    }

    public static FragmentPermission newInstance(int imageId, int head, int body, int buttonEnabled) {
        FragmentPermission fragment = new FragmentPermission();
        Bundle args = new Bundle();
        args.putInt(IMAGE_ID, imageId);
        args.putInt(HEAD, head);
        args.putInt(BODY, body);
        args.putInt(BUTTON_ENABLE, buttonEnabled);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageId = getArguments().getInt(IMAGE_ID);
            head = getArguments().getInt(HEAD);
            body = getArguments().getInt(BODY);
            buttonEnabled = getResources().getString(R.string.enable) +  " " + getResources().getString(getArguments().getInt(BUTTON_ENABLE));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_permission, container, false);
        ImageView iv_icon = v.findViewById(R.id.iv_icon);
        iv_icon.setImageResource(imageId);
        TextView tv_title = v.findViewById(R.id.tv_title);
        tv_title.setText(head);
        TextView tv_message = v.findViewById(R.id.tv_message);
        tv_message.setText(body);
        TextView tv_skip = v.findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(this);
        TextView tv_enable_permission = v.findViewById(R.id.tv_enable_permission);
        tv_enable_permission.setOnClickListener(this);
        tv_enable_permission.setText(buttonEnabled);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            switch (v.getId()){
                case R.id.tv_enable_permission:
                    mListener.permissionEnable();
                    break;
                case R.id.tv_skip:
                    mListener.skip();
                    break;
            }
        }
    }

    public interface OnFragmentInteractionListener {
        void permissionEnable();
        void skip();
    }
}
