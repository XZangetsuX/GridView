package com.example.ls12docente.ejm008eneabr2018gridview;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class App extends AppCompatActivity{
    private GridView       gridView=null;
    private itemAdapter     adapter=null;

    private ImageView image=null;
    private TextView title=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView)findViewById(R.id.gridView);

        adapter = new itemAdapter(this,R.layout.row_grid,fillImages());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item fhater =(item)parent.getItemAtPosition(position);
                displayDialog(fhater.getImage(),fhater.getName());
            }
        });

    }
    private ArrayList<item> fillImages(){
        int  values =  Integer.parseInt(getResources().getString(R.string.howmanyImages));
        ArrayList<item> lista = new ArrayList<>();
        for (int i =0;i<=values;i++) {

            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    getResources().getIdentifier("sample_"+i,
                            "drawable",
                            "com.example.ls12docente.ejm008eneabr2018gridview"));
            lista.add(new item(bitmap,"sample_"+i));
        }
        return lista;
    }

    private void displayDialog (Bitmap ima, String txt){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.fullscreen);

        image = (ImageView) dialog.findViewById(R.id.ImageViewZoom);
        title = (TextView) dialog.findViewById(R.id.Title);

        image.setImageBitmap(ima);
        dialog.setTitle(txt);

        dialog.show();

    }
}









