package com.example.hetal13.recycler_card_demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hetal13 on 01-11-2016.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactView> {
    ArrayList<Contact> contacts =new ArrayList<Contact>();
    Context context;

    public  ContactAdapter( Context context,ArrayList<Contact> contacts){
        this.contacts=contacts;
        this.context=context;
    }
    @Override
    public ContactView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        ContactView contactView = new ContactView(view,context,contacts);

        return contactView;
    }

    @Override
    public void onBindViewHolder(ContactView holder, int position) {
Contact contact =contacts.get(position);
        holder.img_id.setImageResource(contact.getImg_id());
        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());
        holder.mobile.setText(contact.getMobile());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
public static class ContactView extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{
    ImageView img_id;
    TextView name,email,mobile;
    Button call;

    ArrayList<Contact> contacts = new ArrayList<Contact>();
Context context;
    public ContactView(View view,Context context,ArrayList<Contact> contacts)
    {
        super(view);
        this.context=context;
        this.contacts=contacts;
        view.setOnClickListener(this);
         img_id=(ImageView) view.findViewById(R.id.img_person);
        name=(TextView)view.findViewById(R.id.person_name);
        email=(TextView)view.findViewById(R.id.person_email);
        mobile=(TextView) view.findViewById(R.id.person_contact);

    }

    @Override
    public void onClick(View v)
    {
        int position=getAdapterPosition();

        Log.v("here","ContactAdapter");
        Contact contact = this.contacts.get(position);
        Intent intent = new Intent(this.context,Contact_Details.class);
        intent.putExtra("img_id",contact.getImg_id());
        intent.putExtra("name",contact.getName());
        intent.putExtra("email",contact.getEmail());
        intent.putExtra("mobile",contact.getMobile());
        this.context.startActivity(intent);
    }
}
}
