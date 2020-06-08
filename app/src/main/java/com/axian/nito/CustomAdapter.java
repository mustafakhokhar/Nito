package com.axian.nito;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder>
    {

        Context context;
        String []title;
        String [] urlLink;

        public CustomAdapter(Context context, String[] title, String[] urlLink) {
            this.context = context;
            this.title = title;
            this.urlLink = urlLink;
        }

        @NonNull
        @Override
        public CustomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view= LayoutInflater.from ( context ).inflate ( R.layout.list_item,viewGroup,false );

            return new CustomHolder ( view );
        }

        @Override
        public void onBindViewHolder(@NonNull CustomHolder customHolder, int i)
        {

            String title1= title[i];
            final String urls=urlLink[i];

            customHolder.textView.setText ( title1 );
            customHolder.linearLayout.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    Intent intent =new Intent ( context,FullView.class );

                    intent.putExtra ( "url",urls );

                    context.startActivity ( intent );
                }
            } );




        }

        @Override
        public int getItemCount() {
            return title.length;
        }

        class CustomHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;
            LinearLayout linearLayout;
            public CustomHolder(@NonNull View itemView) {
                super ( itemView );

                linearLayout=(LinearLayout ) itemView.findViewById ( R.id.linear );

                imageView=(ImageView) itemView.findViewById ( R.id.image );
                textView=(TextView) itemView.findViewById ( R.id.titles );
            }
        }

    }

