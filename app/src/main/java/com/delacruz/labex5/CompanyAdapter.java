package com.delacruz.labex5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {

    private Context context;
    private int resource;

    public CompanyAdapter(Context context, int resource, List<Company> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        int logo = getItem(i).getcLogo();
        String name = getItem(i).getcName();
        String country = getItem(i).getcCountry();
        String industry = getItem(i).getcIndustry();
        String ceo = getItem(i).getcCeo();

        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(resource, parent, false);

        ImageView cLogo = convertView.findViewById(R.id.ivLogo);
        TextView cName = convertView.findViewById(R.id.tvName);
        TextView cCountry= convertView.findViewById(R.id.tvCountry);
        TextView cIndustry= convertView.findViewById(R.id.tvIndustry);
        TextView cCeo = convertView.findViewById(R.id.tvCeo);

        cLogo.setImageResource(logo);
        cName.setText(name);
        cCountry.setText(country);
        cIndustry.setText(industry);
        cCeo.setText(ceo);

        return convertView;
    }
}
