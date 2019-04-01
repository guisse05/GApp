package com.example.gapp.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.gapp.view.ItemDetailsActivity;
import com.example.gapp.R;

import java.util.List;


public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.ViewHolder>  {

    //fields
    public Context context;
    public List<CarItem> carItemList;
    public LayoutInflater inflater; //injecter chaque elt de la liste


    public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView itemNameView;
    public TextView itemPriceView;
    public ImageView  itemIconView;
    public TextView itemDescriptionView;
    RelativeLayout layout;

       public ViewHolder(View v) {
           super(v);
           layout = v.findViewById(R.id.shop_list);
           itemNameView = v.findViewById(R.id.item_name);
           itemPriceView = v.findViewById(R.id.item_price);
           itemIconView = v.findViewById(R.id.item_icon);
           itemDescriptionView = v.findViewById(R.id.car_description);

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

    public CarItemAdapter(Context context, List<CarItem> carItemList){
        this.carItemList = carItemList;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public CarItemAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.adapter_item,parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //get item informations
        CarItem currentItem = getItem(position);
        String tag =currentItem.getTag();
        final String itemDescription = currentItem.getDescription();
        final String itemName = currentItem.getName();
        final double itemPrice;
        itemPrice = currentItem.getPrice();

        //get icon view
        final String ressourceName = "item_" + tag + "_icon";
        final int resId=context.getResources().getIdentifier(ressourceName,"drawable",context.getPackageName());
        holder.itemIconView.setImageResource(resId);

        //get item name view
        holder.itemNameView.setText(itemName);

        //get item description

        //holder.itemDescriptionView.setText(description);

        //get item price view
        holder.itemPriceView.setText(itemPrice+"$");

        holder.itemNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("itemName",itemName);
              //  intent.putExtra("itemDescription",description);
                context.startActivity(intent);
            }
        });

    }
}