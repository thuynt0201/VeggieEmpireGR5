package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.BaseActivity;
import com.project.RoomMessActivity;
import com.project.adapters.AllUserAdapter;
import com.project.adapters.MessengerAdapter;
import com.project.models.Conversation;
import com.project.models.User;
import com.project.viewmodel.HomeMessViewModel;

import java.util.ArrayList;

public class HomeChatActivity2 extends BaseActivity<HomeMessViewModel> implements AllUserAdapter.OnItemClick, MessengerAdapter.OnMessClick {

    private AllUserAdapter allUsersAdapter;
    private MessengerAdapter messageAdapter;
    private EditText edtSearchUser;
    private RecyclerView rvAllUser,rvListMess;
    private Button btnchat;





    @Override
    protected void initViews() {

        //======THANH HEADER======
        getSupportActionBar().setTitle("Chat");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        mModel.loadUser();
        rvAllUser = findViewById(R.id.rcv_all_user);
        rvListMess = findViewById(R.id.rcv_mess_list);
        edtSearchUser = findViewById(R.id.edt_search_user);
        //all users recycle view
        rvAllUser.setHasFixedSize(true);
        rvAllUser.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        allUsersAdapter = new AllUserAdapter(mModel.getUserArrayList());
        rvAllUser.setAdapter(allUsersAdapter);
        allUsersAdapter.setOnItemClick(this);


        //recent user recycle view
        rvListMess.setHasFixedSize(true);
        rvListMess.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessengerAdapter(mModel.getConversationArrayList());
        rvListMess.setAdapter(messageAdapter);
        messageAdapter.setOnItemClick(this);

        edtSearchUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mModel.searchUser(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });

        mModel.getUsers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                allUsersAdapter.notifyDataSetChanged();
                mModel.loadRecentConversation();
            }
        });

        mModel.getConversations().observe(this, new Observer<ArrayList<Conversation>>() {
            @Override
            public void onChanged(ArrayList<Conversation> conversations) {
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    private void gotoChatFragment(User user) {
        Intent i = new Intent(this, RoomMessActivity.class);
        i.putExtra("user",user);
        startActivity(i);
    }
    @Override
    public void onResume() {
        super.onResume();
        //  mModel.setStatus(Constants.ONLINE);
    }
    @Override
    public void onPause() {
        super.onPause();
        // mModel.setStatus(Constants.OFFLINE);
    }
    @Override
    protected Class<HomeMessViewModel> getClassViewModel() {
        return HomeMessViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home_chat2;
    }

    @Override
    public void onItemClick(User data) {
        gotoChatFragment(data);
    }

    @Override
    public void onMessClick(User data) {
        gotoChatFragment(data);
    }

    public void push_click(View view) {
        Intent intent2 = new Intent(HomeChatActivity2.this,ChatActivity.class);
        startActivity(intent2);
    }
}