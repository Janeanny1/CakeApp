package com.example.notekeepererrors

import DataManager
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.notekeepererrors.databinding.ActivityNoteListBinding


class NoteListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteListBinding

    val listNote by lazy {
        binding.contentNoteList.listNotes
    }

    val notesAdapter by lazy {
        ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes,
        )


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            val activityIntent = intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        listNote.adapter = notesAdapter

        listNote.setOnItemClickListener{parent, view, position, id ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION, position)
            startActivity(activityIntent)
        }
    }

    private fun startActivity(activityIntent: Unit) = Unit

    protected fun intent(packageContext: NoteListActivity, java: Class<MainActivity>) {

    }

    override fun onResume() {
        super.onResume()
        notesAdapter.notifyDataSetChanged()
    }


}

