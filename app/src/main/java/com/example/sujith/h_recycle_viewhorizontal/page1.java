package com.example.sujith.h_recycle_viewhorizontal;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class page1 extends AppCompatActivity {

    RecyclerView recviewp;
    int[] photo={R.drawable.browser4,R.drawable.elephant,R.drawable.phone,R.drawable.sms1,
            R.drawable.blu,R.drawable.in,R.drawable.twt};
    ArrayList<String> name;
    RecyclerAdapter adapt;

    RecyclerView reviewVp;
    ArrayList<String> arrV;
    Verticadapt vadapt;
    int[] photoV={R.drawable.icon1,R.drawable.icon2,R.drawable.icon4,R.drawable.facebook,
            R.drawable.dot,R.drawable.phone};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        recviewp=findViewById(R.id.recview);

        name=new ArrayList<>();
        name.add("Browser");
        name.add("Elephant");
        name.add("Phone");
        name.add("SMS");
        name.add("WiFi");
        name.add("IN");
        name.add("Twitter");

        adapt=new RecyclerAdapter(photo);


        LinearLayoutManager lm=new LinearLayoutManager
                (page1.this,LinearLayoutManager.HORIZONTAL,false);

        recviewp.setLayoutManager(lm);
        recviewp.setAdapter(adapt);


        reviewVp=findViewById(R.id.reviewV);
        arrV=new ArrayList<>();
        arrV.add("Blue");
        arrV.add("Circle");
        arrV.add("People");
        arrV.add("Facebook");
        arrV.add("Dot");
        arrV.add("Phone");

        vadapt=new Verticadapt(photoV);

        LinearLayoutManager Vlm=new LinearLayoutManager(page1.this,
                LinearLayoutManager.VERTICAL,false);

        reviewVp.setLayoutManager(Vlm);
        reviewVp.setAdapter(vadapt);



    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageVH>
    {
        int[] pic;

        RecyclerAdapter(int[] pic)
        {
            this.pic=photo;
        }
        class ImageVH extends RecyclerView.ViewHolder
        {
            ImageView IV;
            TextView TV;

            public ImageVH(@NonNull View itemView)
            {
                super(itemView);
                IV=itemView.findViewById(R.id.imgH);
                TV=itemView.findViewById(R.id.tvview);

            }
        }


        @NonNull
        @Override
        public ImageVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View v=LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.horiz,viewGroup,false);
            return new ImageVH(v);
        }

        @Override
        public void onBindViewHolder(final ImageVH viewHolder, final int i)
        {
            //int id=pic[i];
            viewHolder.IV.setImageResource(photo[i]);
            viewHolder.TV.setText(name.get(i));

            viewHolder.IV.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
//                    if (i==0)
//                    {
//                        Intent bro=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
//                        startActivity(bro);
//                    }
//                    else if (i==1)
//                    {
//                        Toast.makeText(page1.this, "Elephant", Toast.LENGTH_SHORT).show();
//                    }
//                    else if (i==2)
//                    {
//                        Intent cal=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"));
//                        startActivity(cal);
//                    }
                    Toast.makeText(page1.this, ""+viewHolder.TV.getText().toString(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        @Override
        public int getItemCount()
        {
            return photo.length;
        }
    }

    class Verticadapt extends RecyclerView.Adapter<Verticadapt.ViewHV>
    {
        int[] imaV;
        Verticadapt(int[] imaV)
        {
            this.imaV=photoV;
        }



        class ViewHV extends RecyclerView.ViewHolder
        {
            ImageView imgVp;
            TextView TvVp;


            public ViewHV(@NonNull View itemView)
            {
                super(itemView);
                imgVp=itemView.findViewById(R.id.imgV);
                TvVp=itemView.findViewById(R.id.tvV);

            }
        }

        @NonNull
        @Override
        public ViewHV onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View VV=LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.vertic,viewGroup,false);
            return new ViewHV(VV);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHV HV, int i)
        {
            //int p=imaV[i];
            HV.imgVp.setImageResource(photoV[i]);
            HV.TvVp.setText(arrV.get(i));

        }



        @Override
        public int getItemCount() {
            return arrV.size();
        }

    }





}
