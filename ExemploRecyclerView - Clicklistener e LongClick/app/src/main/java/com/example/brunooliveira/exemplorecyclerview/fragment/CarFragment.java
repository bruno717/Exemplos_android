package com.example.brunooliveira.exemplorecyclerview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brunooliveira.exemplorecyclerview.MainActivity;
import com.example.brunooliveira.exemplorecyclerview.R;
import com.example.brunooliveira.exemplorecyclerview.adapter.CarAdapter;
import com.example.brunooliveira.exemplorecyclerview.domain.Car;
import com.example.brunooliveira.exemplorecyclerview.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;

/**
 * Created by bruno.oliveira on 28/08/2015.
 */
public class CarFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecyclerView;
    private List<Car> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_car, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                //GridLayoutManager gridLayoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
                /*StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) mRecyclerView.getLayoutManager();
                int[] aux = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
                int max = -1;
                for (int i = 0; i < aux.length; i++) {
                    max = aux[i] > max ? aux[i] : max;
                }*/

                CarAdapter adapter = (CarAdapter) mRecyclerView.getAdapter();

                /*if (mList.size() == layoutManager.findLastCompletelyVisibleItemPosition() + 1) {
                    // if (mList.size() == max + 1) {
                    List<Car> listAux = ((MainActivity) getActivity()).getSetCarList(10);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }
                }*/

            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity(), mRecyclerView, this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(layoutManager);

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);*/

       /* StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);*/

        mList = ((MainActivity) getActivity()).getSetCarList(20);
        CarAdapter adapter = new CarAdapter(getActivity(), mList);
        //adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "onClickListener: " + position, Toast.LENGTH_SHORT).show();

       /* CarAdapter adapter = (CarAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);*/
    }

    @Override
    public void onLongPressClickListener(View view, int position) {
        Toast.makeText(getActivity(), "onLongPressClickListener: " + position, Toast.LENGTH_SHORT).show();

        /*CarAdapter adapter = (CarAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);*/
    }

    private static class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        public RecyclerViewTouchListener(Context context, final RecyclerView recyclerView, RecyclerViewOnClickListenerHack hack) {
            mContext = context;
            mRecyclerViewOnClickListenerHack = hack;
            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                    View cv = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (cv != null && mRecyclerViewOnClickListenerHack != null) {
                        mRecyclerViewOnClickListenerHack.onLongPressClickListener(cv,
                                recyclerView.getChildPosition(cv));
                    }
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    View cv = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (cv != null && mRecyclerViewOnClickListenerHack != null) {
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                recyclerView.getChildPosition(cv));
                    }
                    return (true);
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
