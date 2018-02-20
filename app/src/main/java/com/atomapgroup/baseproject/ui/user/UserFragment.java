package com.atomapgroup.baseproject.ui.user;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.atomapgroup.baseproject.R;
import com.atomapgroup.baseproject.data.model.User;
import com.atomapgroup.baseproject.ui.base.BaseFragment;

import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment implements IUserContract.IView {

    private EditText etName, etEmail, etMobile;
    private Button btnSave, btnView, btnUpdate, btnDelete;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private UserListAdapter adapter;
    private IUserContract.IPresenter presenter;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new UserPresenter(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initializedView(view);
        return view;
    }

    private void initializedView(View view) {
        etName = view.findViewById(R.id.et_name);
        etEmail = view.findViewById(R.id.et_email);
        etMobile = view.findViewById(R.id.et_mobile);
        btnSave = view.findViewById(R.id.btn_save);
        btnView = view.findViewById(R.id.btn_view);
        btnUpdate = view.findViewById(R.id.btn_update);
        btnDelete = view.findViewById(R.id.btn_delete);
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adapter = new UserListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        setClickListener();
    }

    private void setClickListener() {

        btnSave.setOnClickListener(view -> attemptToInsert());

        btnView.setOnClickListener(view -> presenter.getAllUser());

        btnUpdate.setOnClickListener(view -> {
        });
        btnDelete.setOnClickListener(view -> {
        });
    }

    @Override
    public void attemptToInsert() {
        presenter.validateInput(
                etName.getText().toString(),
                etEmail.getText().toString(),
                etMobile.getText().toString()
        );
    }

    @Override
    public void load(List<User> users) {
        getActivity().runOnUiThread(() -> {
            adapter.addAll(users);
        });
    }

    @Override
    public void setNameError(String error) {
        etName.setError(error);
        etName.requestFocus();
    }

    @Override
    public void setEmailError(String error) {
        etEmail.setError(error);
        etEmail.requestFocus();
    }

    @Override
    public void setMobileError(String error) {
        etMobile.setError(error);
        etMobile.requestFocus();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
