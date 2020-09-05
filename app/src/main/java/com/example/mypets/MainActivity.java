package com.example.mypets;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Pets pets;
    private PetsTable petsTable;
    private TextView display;
    private List<Pets> listOfPets;
    private PetAdapter petAdapter;
    private PetProvider petProvider;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorActivity();
            }
        });


        displayInformation();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void editorActivity() {
        Intent intent = new Intent(MainActivity.this, EditorActivity.class);
        startActivity(intent);

    }

    public void displayInformation() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShow);

        petsTable = new PetsTable(this);

        petProvider = new PetProvider();

        pets = new Pets();

        listOfPets = new ArrayList<>();

        petAdapter = new PetAdapter(this, listOfPets);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layout);

        recyclerView.setAdapter(petAdapter);


        /*petsTable = new PetsTable(this);
        pets = new Pets();
        // list = new ArrayList<>();
        //list = petsTable.getAllData();
        Cursor cursor = null;
        ListView listView = (ListView) findViewById(R.id.listView);

        petAdapter = new PetAdapter(this, null);

        listView.setAdapter(petAdapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                editorActivity();
                return true;

            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}