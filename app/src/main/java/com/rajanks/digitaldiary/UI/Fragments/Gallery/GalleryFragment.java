package com.rajanks.digitaldiary.UI.Fragments.Gallery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rajanks.digitaldiary.R;
import com.rajanks.digitaldiary.UI.CustomViews.AmazeTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final ListView listView = (ListView) root.findViewById(R.id.gallery_list);
        final AmazeTextView eventBtn = (AmazeTextView) root.findViewById(R.id.eventBtn);
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventBtn.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });
        String[] images = new String[]{ "http://www.kcinternationalschool.org/event-gallery/images/150814-2.jpg",
                                        "http://www.thehindu.com/multimedia/dynamic/01553/15bgHBDNNHI-W04_16_1553017g.jpg",
                                        "http://newznew.com/wp-content/uploads/2015/08/G.jpg",
                                        "http://www.oxfordgrammarschool.com/images/27th_SportsDay/3.JPG",
                                        "http://www.thehindu.com/multimedia/dynamic/01552/DE16_PG2_SCHOOL_DE_1552601f.jpg"};
        listView.setAdapter(new GalleryAdapter(getContext(),images));
        return root;
    }
}
