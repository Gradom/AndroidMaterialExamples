package it.dg.parallaxfragmentcomponents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.dg.R;
import it.dg.parallax.ParallaxHolder;

/**
 * Created by Domenico Grasso on 10/08/2017
 */

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private Drawable image1;

    public ImageViewAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        image1 = ContextCompat.getDrawable(context, R.drawable.test_image_1);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(inflater.inflate(R.layout.image_view_holder, parent, false));
    }


    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int position) {
        viewHolder.getBackgroundImage().setImageDrawable(image1);
        viewHolder.getTextView().setText("Row " + position);
        viewHolder.getBackgroundImage().reuse();
    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public class ImageViewHolder extends ParallaxHolder {
        private final TextView textView;

        public ImageViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.label);
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public int getParallaxImageId() {
            return R.id.backgroundImage;
        }
    }
}
