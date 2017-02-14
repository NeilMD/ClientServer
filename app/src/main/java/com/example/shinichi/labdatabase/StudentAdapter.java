package com.example.shinichi.labdatabase;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shinichi on 2/14/17.
 */

public class StudentAdapter extends CursorRecyclerViewAdapter<StudentAdapter.StudentViewHolder> {

    public StudentAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder viewHolder, Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(Student.colID));
        viewHolder.id.setText(id +"");
        viewHolder.name.setText(cursor.getInt(cursor.getColumnIndex(Student.colName))+"");

    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent,false);

        return new StudentViewHolder(v);
    }


    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView id,name;


        public StudentViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
