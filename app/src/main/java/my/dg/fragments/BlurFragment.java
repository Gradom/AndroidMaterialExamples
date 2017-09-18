package my.dg.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import my.dg.R;

/**
 * Created by Domenico Grasso on 10/08/2017
 */

public class BlurFragment extends Fragment {

    private View view;
    private View blurView;
    private ImageView ironMan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_list_fragment, container, false);
        xmlReferences();
        return view;
    }

    private void xmlReferences() {
        ironMan = (ImageView) view.findViewById(R.id.blur_iron);
        blurView = (View) view.findViewById(R.id.blur_view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ironMan.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                ironMan.getViewTreeObserver().removeOnPreDrawListener(this);
                ironMan.buildDrawingCache();

                Bitmap bitmap = ironMan.getDrawingCache();
                blur(bitmap, blurView);
                return true;
            }
        });
    }

    private void blur(Bitmap bkg, View view) {
        float radius = 20;
        Bitmap overlay = Bitmap.createBitmap((view.getMeasuredWidth()), (view.getMeasuredHeight()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);

        canvas.translate(-view.getLeft(), -view.getTop());
        canvas.drawBitmap(bkg, 0, 0, null);
        RenderScript rs = RenderScript.create(getActivity());
        Allocation overlayAlloc = Allocation.createFromBitmap(
                rs, overlay);
        ScriptIntrinsicBlur blur = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            blur = ScriptIntrinsicBlur.create(rs, overlayAlloc.getElement());

            blur.setInput(overlayAlloc);

            blur.setRadius(radius);

            blur.forEach(overlayAlloc);

            overlayAlloc.copyTo(overlay);
            view.setBackground(new BitmapDrawable(getResources(), overlay));
            rs.destroy();
        }
    }
}
