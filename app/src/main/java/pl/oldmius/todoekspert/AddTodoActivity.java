package pl.oldmius.todoekspert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {

    public static final String CONTENT = "content";
    public static final String DONE = "done";
    public static final String TODO = "todo";
    private EditText contentEditText;
    private CheckBox doneCheckBox;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//metoda odpowiedzialna za przycisk powrotu w toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contentEditText = (EditText) findViewById(R.id.content_et);
        doneCheckBox = (CheckBox) findViewById(R.id.done_cb);
        saveButton = (Button) findViewById(R.id.save_btn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = contentEditText.getText().toString();
                boolean isDone = doneCheckBox.isChecked();

                Todo todo = new Todo();
                todo.content = content;
                todo.done = isDone;

                Intent intent = new Intent();
                intent.putExtra(TODO, todo);

                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

}
