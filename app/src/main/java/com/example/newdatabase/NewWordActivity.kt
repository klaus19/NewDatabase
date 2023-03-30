package com.example.newdatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.newdatabase.db.Word

class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var editDef:EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_word)
        editWordView = findViewById(R.id.edit_word)
        editDef = findViewById(R.id.edit_def)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text) ||TextUtils.isEmpty(editDef.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val def = editDef.text.toString()
                replyIntent.putExtra(EXTRA_REPLY1, word)
                replyIntent.putExtra(EXTRA_REPLY2,def)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY1 = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY2 = "com.example.android.word"
    }
}