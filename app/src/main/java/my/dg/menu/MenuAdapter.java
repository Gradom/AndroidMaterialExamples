package my.dg.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import my.dg.R;

/**
 * Created by Domenico Grasso on 01/08/2017
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuHolder> {

    private List<MenuItem> listaVociMenu;
    private static RecyclerViewListener listener;

    public MenuAdapter(List<MenuItem> listaVociMenu, RecyclerViewListener listener) {
        this.listaVociMenu = listaVociMenu;
        MenuAdapter.listener = listener;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_row, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, final int position) {
        final MenuItem item = listaVociMenu.get(position);
        holder.setMenuLabel(item.getLabel());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemSelected(v, item, position);
            }
        });
    }

    public void updateList(List<MenuItem> listaVociMenu) {
        this.listaVociMenu = listaVociMenu;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaVociMenu.size();
    }
}
