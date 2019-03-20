package com.example.gapp.controler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gapp.R;
import com.example.gapp.view.CarItem;

import java.util.List;


public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.ViewHolder> {

    //fields
    public Context context;
    public List<CarItem> carItemList;
    public LayoutInflater inflater; //injecter chaque elt de la liste
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CarItem item);
    }



   public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView itemNameView;
    public TextView itemPriceView;
    public ImageView  itemIconView;
    RelativeLayout layout;

       public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.shop_list);
            itemNameView = v.findViewById(R.id.item_name);
            itemPriceView = v.findViewById(R.id.item_price);
            itemIconView = v.findViewById(R.id.item_icon);


        }

       public void bind(final CarItem item, final OnItemClickListener listener) {
           itemNameView.setText(item.getName());
           itemNameView.setOnClickListener(new View.OnClickListener() {
               @Override public void onClick(View v) {
                   listener.onItemClick(item);
               }
           });
       }
    }

    public CarItem getItem(int position) {
        return carItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        return carItemList.size();
    }


    public CarItemAdapter(Context context, List<CarItem> carItemList, OnItemClickListener listener){
        this.carItemList = carItemList;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public CarItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.adapter_item, null);
        return new ViewHolder(view);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //get item informations
        CarItem currentItem = getItem(position);
        String tag =currentItem.getTag();
        final String itemName = currentItem.getName();
        final double itemPrice;
        itemPrice = currentItem.getPrice();

        holder.bind(carItemList.get(position), listener);

        //get icon view
        String ressourceName = "item_" + tag + "_icon";
        int resId=context.getResources().getIdentifier(ressourceName,"drawable",context.getPackageName());
        holder.itemIconView.setImageResource(resId);

        //get item name view
        holder.itemNameView.setText(itemName);

        //get item price view
        holder.itemPriceView.setText(itemPrice+"$");

      /*  holder.itemNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast =  Toast.makeText(context,"Vous voulez un "+itemName+",pour le prix de "+itemPrice+"$",Toast.LENGTH_SHORT);
                myToast.show();
            }
        });*/
    }


}
