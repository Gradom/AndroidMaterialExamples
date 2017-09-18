package my.dg.parallax;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Domenico Grasso on 10/08/2017
 */

public class ParallaxRecycleView extends RecyclerView {

    private OnScrollListener scrollListener;

    private OnScrollListener defaultListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (scrollListener != null) {
                scrollListener.onScrollStateChanged(recyclerView, newState);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                ((ParallaxHolder) recyclerView.getChildViewHolder(recyclerView.getChildAt(i))).animateImage();
            }

            if (scrollListener != null) {
                scrollListener.onScrolled(recyclerView, dx, dy);
            }
        }
    };


    public ParallaxRecycleView(Context context) {
        super(context);
        init();
    }

    public ParallaxRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParallaxRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        addOnScrollListener(defaultListener);
    }


    @Override
    public void addOnScrollListener(OnScrollListener listener) {
        super.addOnScrollListener(listener);
    }
}
