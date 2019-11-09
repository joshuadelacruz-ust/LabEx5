package com.delacruz.labex5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] cName, cCountry, cIndustry, cCeo, cInfo;
    int[] cLogo = {R.drawable.icbc
            ,R.drawable.jpmorganchase,R.drawable.chinaconstructionbank,
            R.drawable.agriculturalbankofchina,R.drawable.bankofamerica,R.drawable.apple,R.drawable.pingan,R.drawable.chinaconstructionbank,
            R.drawable.royaldutchshell,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsungelectronics,R.drawable.citigroup};
    ArrayList<Company> companies= new ArrayList<>();
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cName = getResources().getStringArray(R.array.cName);
        cCountry = getResources().getStringArray(R.array.cCountry);
        cIndustry = getResources().getStringArray(R.array.cIndustry);
        cCeo = getResources().getStringArray(R.array.cCeo);
        cInfo = getResources().getStringArray(R.array.cInfo);

        for(int i = 0; i < cName.length; i++){
            companies.add(new Company(cLogo[i], cName[i], cCountry[i], cIndustry[i], cCeo[i], cInfo[i]));

        }

        CompanyAdapter adapter = new CompanyAdapter(this, R.layout.item, companies);

        listCompanies = findViewById(R.id.lvCompany);

        listCompanies.setAdapter(adapter);

        listCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "companies.txt");
        try{
            final FileOutputStream fos = new FileOutputStream(file);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            String choice = companies.get(i).getcName() + "\n"
                    + companies.get(i).getcCountry() + "\n"
                    + companies.get(i).getcIndustry() + "\n"
                    + companies.get(i).getcCeo() + "\n";
            fos.write(choice.getBytes());
            dialog.setIcon(cLogo[i]);
            dialog.setTitle(cName[i]);
            dialog.setMessage(cInfo[i]);

            dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try{
                        FileInputStream fis = new FileInputStream(new  File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
                                + "/companies.txt"));
                        int counter;
                        String str = "";
                        while ((counter = fis.read()) != -1){
                            str += Character.toString((char) counter);
                        }
                        fis.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
//                    Toast.makeText(MainActivity.this, cName[i], Toast.LENGTH_LONG).show();
                }
            });

            dialog.create().show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
