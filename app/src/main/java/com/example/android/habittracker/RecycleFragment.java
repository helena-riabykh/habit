package com.example.android.habittracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleFragment extends Fragment {
    private List<Habit> myHabitArrayList = new ArrayList<>();
    private HabitAdapter adapter;
    private int posit = -1;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private static final int TARGET_FRAGMENT_REQUEST_CODE = 1;
    private static final int TARGET_FRAGMENT_REQUEST_CODE_TWO = 2;
    private static final String TAG = "myLog";
    private static final String TYPE_EXTRA = "Type";
    public RecycleFragmentViewModel mRecycleFragmentViewModel;

    static RecycleFragment newInstance(ArrayList<Habit> myHabitArrayList) {
        RecycleFragment recycleFragment = new RecycleFragment();
        Bundle args = new Bundle();
        args.putSerializable("ArrayList", myHabitArrayList);
        recycleFragment.setArguments(args);
        return recycleFragment;
    }

    static RecycleFragment newInstance(boolean isUseful) {
        RecycleFragment recycleFragment = new RecycleFragment();
        Bundle args = new Bundle();
        args.putBoolean(TYPE_EXTRA, isUseful);
        recycleFragment.setArguments(args);
        return recycleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            posit = savedInstanceState.getInt("posit");
            myHabitArrayList = (List<Habit>) savedInstanceState.getSerializable("ArrayList");
        }
        mRecycleFragmentViewModel = new ViewModelProvider(requireActivity()).get(RecycleFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        assert getArguments() != null;
        RecyclerView habitRecycler = view.findViewById(R.id.recycle);
        adapter = new HabitAdapter(myHabitArrayList);
        Log.d(TAG, "myHabitArrayList передано HabitAdapter, стр. 79 RecycleFragment" + myHabitArrayList);
        habitRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        habitRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new HabitAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Habit habit = myHabitArrayList.get(position);
                HabitFragment habitFragment = HabitFragment.newInstance(habit, position);
                habitFragment.setTargetFragment(RecycleFragment.this, TARGET_FRAGMENT_REQUEST_CODE_TWO);
                fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager
                        .beginTransaction();
                fragmentTransaction.add(R.id.container, habitFragment);
                Log.d(TAG, "в контейнер добавлен habitFragment, стр. 85 RecycleFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                posit = position;

            }
        });
        ImageButton button = view.findViewById(R.id.float_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HabitFragment habitFragment = new HabitFragment();
                habitFragment.setTargetFragment(RecycleFragment.this, TARGET_FRAGMENT_REQUEST_CODE);
                fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager
                        .beginTransaction();
                fragmentTransaction.replace(R.id.container, habitFragment);
                Log.d(TAG, "в контейнер добавлен habitFragment, стр. 103 RecycleFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        if (getArguments() != null) {
            boolean isUseful = (Boolean) getArguments().getBoolean(TYPE_EXTRA);
            if (!isUseful) {
                LiveData<List<Habit>> data = mRecycleFragmentViewModel.getHarmful();
                data.observe(getViewLifecycleOwner(), new Observer<List<Habit>>() {
                    @Override
                    public void onChanged(@Nullable List<Habit> list) {
                        myHabitArrayList = list;
                        adapter.setMyHabitArrayList(myHabitArrayList);
                        Log.d(TAG, "стр. 121 RecycleFragment");
                        adapter.notifyDataSetChanged();
                    }
                });
            } else {
                LiveData<List<Habit>> data = mRecycleFragmentViewModel.getUseful();
                data.observe(getViewLifecycleOwner(), new Observer<List<Habit>>() {
                    @Override
                    public void onChanged(@Nullable List<Habit> list) {
                        myHabitArrayList = list;
                        adapter.setMyHabitArrayList(myHabitArrayList);
                        Log.d(TAG, "стр. 131 RecycleFragment");
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("posit", posit);
        savedInstanceState.putSerializable("ArrayList", (Serializable) myHabitArrayList);
    }
}

