package com.project;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.project.adapters.ChatAdapter;
import com.project.models.Message;
import com.project.models.User;
import com.project.veggieempiregr5.R;
import com.project.viewmodel.RoomMessViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RoomMessActivity extends BaseActivity<RoomMessViewModel> {
   // private Toolbar tb;
    private User receiverUser;
    private ImageView ivBack;
    private Button btSend;
    private TextView tvName;
    private EditText edtMessSend;
    private String senderUserUid;
    private ChatAdapter chatAdapter;
    private RecyclerView rcvMessRoom;

    @Override
    protected Class<RoomMessViewModel> getClassViewModel() {
        return RoomMessViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_mess_room;
    }

    @Override
    protected void initViews() {
        tvName=findViewById(R.id.receive_user_name);
        getUser((User) getIntent().getExtras().get("user"));
        rcvMessRoom = findViewById(R.id.message_recycle_view);
        edtMessSend = findViewById(R.id.sending_mess);
        btSend = findViewById(R.id.sending_button);
        tvName.setText(receiverUser.getUserName());
        ivBack = findViewById(R.id.arrow_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        senderUserUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mModel.setChatRoom(senderUserUid, receiverUser.getUid());
        mModel.loadMessage();
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messText = edtMessSend.getText().toString();
                if(!messText.equals("")){
                    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                    String date = df.format(Calendar.getInstance().getTime());
                    mModel.sendMessage(senderUserUid, receiverUser.getUid(), messText, date);
                    edtMessSend.setText("");
                }
            }
        });
        rcvMessRoom.setHasFixedSize(true);
        rcvMessRoom.setLayoutManager(new LinearLayoutManager(this));
        rcvMessRoom.setNestedScrollingEnabled(false);
        chatAdapter = new ChatAdapter(mModel.getMessages());
        rcvMessRoom.setAdapter(chatAdapter);

        mModel.getMessageLiveData().observe(this, new Observer<ArrayList<Message>>() {
            @Override
            public void onChanged(ArrayList<Message> messages) {
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        mModel.seenMess();
      //  mModel.setStatus(Constants.ONLINE);
    }

    @Override
    public void onPause() {
        super.onPause();
       // mModel.setStatus(Constants.OFFLINE);
        mModel.removeSeenListener();
    }
    public void getUser(User user){
        this.receiverUser = user;
    }
}
