package com.example.android.habittracker;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {
    String strValue;

    private RecycleFragmentViewModel mRecycleFragmentViewModel;

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecycleFragmentViewModel = new ViewModelProvider(requireActivity()).get(RecycleFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        final EditText editText = view.findViewById(R.id.description);
        editText.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
//                    strValue = editText.getText().toString();
//                if(editText.getText().length() == 3) {
//                    editText.setText(editText.getText().subSequence(0, editText.getText().length() - 1));
//                }
                strValue = editText.getText().toString();
                mRecycleFragmentViewModel.setName(strValue);
        }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//Прописываем то, что надо выполнить до изменений
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//только что заменены
 //               strValue = editText.getText().toString();
 //               mRecycleFragmentViewModel.setName(strValue);
            }
        });
//        mRecycleFragmentViewModel.setName(strValue);
        return view;
    }
//    public String getStrValue(){
//        return strValue;
//    }
}
