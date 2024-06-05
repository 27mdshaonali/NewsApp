package com.example.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    HashMap <String, String> hashMap = new HashMap<>();
    ArrayList <  HashMap <String, String> > arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        hMap();
        MyAdapter myAdapter = new MyAdapter();

        listView.setAdapter(myAdapter);



    }

    private class MyAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.item, parent, false);

            ImageView imageView = view.findViewById(R.id.image);
            TextView category = view.findViewById(R.id.category);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView title = view.findViewById(R.id.title);
            TextView description = view.findViewById(R.id.description);
            LinearLayout layout = view.findViewById(R.id.itemLayout);


            HashMap<String, String> hashMap = arrayList.get(position);

            String cat = hashMap.get("cat");
            String title2 = hashMap.get("title");
            String des = hashMap.get("des");
            String image_url = hashMap.get("image_url");



            Picasso.get().load(image_url)
                    .placeholder(R.drawable.tech)
                    .into(imageView);


            category.setText(cat);
            title.setText(title2);
            description.setText(des);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NewsDetails.TITLE = title2;
                    NewsDetails.NEWS_CONTENT = des;

                    Bitmap bitmap = ( (BitmapDrawable) imageView.getDrawable()).getBitmap();
                    NewsDetails.COVER_IMAGE = bitmap;


                    startActivity(new Intent(MainActivity.this, NewsDetails.class));

                }
            });





            return view;
        }
    }

    public void hMap (){

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("title", "কর সুবিধায় যুক্ত হচ্ছে এআই, ব্লকচেইন, রোবটিক্স ও স্যাস");
        hashMap.put("des", "আগামী ৬ জুন জাতীয় সংসদের মাধ্যমে জাতির সামনে ২০২৪-২৫ অর্থবছরের বাজেট প্রস্তাব উপস্থান করবেন অর্থমন্ত্রী আবুল হাসান মাহমুদ আলী। এ বাজেটের আকার হবে ৭ লাখ ৯৭ হাজার কোটি টাকা। আর বাজেট ঘাটতি ধরা হবে ২ লাখ ৫৬ হাজার কোটি টাকা।\n\n" +
                "জনস্বার্থ ও স্মার্ট বাংলাদেশ রূপকল্প বাস্তবায়নের অংশ হিসেবে এবারের বাজেটে সম্পূর্ণ ক্যাশলেস লেনদেনের শর্তসাপেক্ষে আরও তিন বছর কর অব্যাহতি সুবিধা বাড়লেও এবার ২৭টি উপখাত কমে দাঁড়াচ্ছে ১৯টিতে। এবারের তালিকায় নতুন করে যুক্ত হচ্ছে কৃত্রিম বুদ্ধিমত্তা (এআই), ব্লকচেইন, রোবটিক্স, সফটওয়্যার-অ্যাজ-এ-সার্ভিস (স্যাস) ও ডেটা সায়েন্স। তবে কর অব্যাহতির সুবিধা থেকে বাদ পড়ছে ন্যাশনওয়াইড টেলিকমিউনিকেশন ট্রান্সমিশন নেটওয়ার্ক (এনটিটিএন), সিস্টেম ইন্ট্রিগ্রেশন ও ক্লাউড সার্ভিস। একইসঙ্গে গত কয়েক বছর ধরে আলোচনায় থেকেও এই তালিকায় যুক্ত হয়নি ইন্টারনেট সেবা বা আইএসপি।\n\n");
        hashMap.put("image_url", "https://digibanglatech.news/wp-content/uploads/2024/06/Budget-1.jpg");
        arrayList.add(hashMap);

    }

}