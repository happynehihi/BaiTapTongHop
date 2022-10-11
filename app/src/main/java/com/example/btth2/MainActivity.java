package com.example.btth2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvPhone;
    ArrayList<Phone> arrayPhone;
    PhoneAdapter adapter;
    EditText edtadd;
    Button btnadd;
    int vitri=0;
    boolean a=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnadd = (Button) findViewById(R.id.button);
        edtadd = (EditText) findViewById(R.id.editTextTextPersonName);

        adapter = new PhoneAdapter(this, R.layout.phone, arrayPhone);
        lvPhone.setAdapter(adapter);

        lvPhone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                if(a)
                startActivity(intent);
                else a=true;


            }
        });

        lvPhone.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = edtadd.getText().toString();
                arrayPhone.add(new Phone(monhoc, R.drawable.smartphone));
                adapter.notifyDataSetChanged();
            }
        });

        lvPhone.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Lê Phan Hoàng Phúc");
                b.setMessage("Bạn có đồng ý xóa không ?");
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayPhone.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = b.create();
                al.show();
                return false;
            }
        });
    }

    private void Anhxa() {
        lvPhone = (ListView) findViewById(R.id.listview);
        arrayPhone = new ArrayList<>();

        arrayPhone.add(new Phone("Iphone", R.drawable.smartphone));
        arrayPhone.add(new Phone("SamSung", R.drawable.smartphone));
        arrayPhone.add(new Phone("Oppo", R.drawable.smartphone));
        arrayPhone.add(new Phone("Xiaomi", R.drawable.smartphone));
        arrayPhone.add(new Phone("Realme ", R.drawable.smartphone));
        arrayPhone.add(new Phone("Huawei ", R.drawable.smartphone));
    }
}