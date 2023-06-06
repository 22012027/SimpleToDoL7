package sg.edu.rp.c346.id22012027.simpletodol7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextToDo;
    Spinner spinAddRemove;
    Button buttonAdd;
    Button buttonClear;
    Button buttonDelete;
    ListView listViewList;
    ArrayAdapter aaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextToDo=findViewById(R.id.editTextToDo);
        spinAddRemove= findViewById(R.id.spinner);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonClear=findViewById(R.id.buttonClear);
        buttonDelete=findViewById(R.id.buttonDelete);
        listViewList=findViewById(R.id.listViewList);

        ArrayList<String> alList = new ArrayList<String>();
        alList.add("Watch Movie With Jenny");
        alList.add("Attend IG tonite");

        aaList= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alList);
        listViewList.setAdapter(aaList);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list= editTextToDo.getText().toString();
                alList.add(list);
                aaList.notifyDataSetChanged();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list= editTextToDo.getText().toString();
                alList.remove(list);
                aaList.notifyDataSetChanged();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list= editTextToDo.getText().toString();
                aaList.clear();
                aaList.notifyDataSetChanged();
            }
        });

        spinAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        buttonAdd.setEnabled(true);
                        buttonDelete.setEnabled(false);
                        break;
                    case 1:
                        buttonAdd.setEnabled(false);
                        buttonDelete.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        listViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alList.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();    }
        });
    }
}