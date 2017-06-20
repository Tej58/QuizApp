package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when user clicks submit button
     */
    public void submitResults(View view){
        // call the evaluate and grade method get the total result
        String result= evaluateAndGrade();
        //display message
        //send this result to email
        sendResultToemail(result);
    }

    private String evaluateAndGrade(){
        int grade=0;

        //Question1 evaluation
        RadioButton question1Ans = (RadioButton) findViewById(R.id.Question1_choice2);
        if(question1Ans.isChecked()){
            grade+=1;
        }

        //Question2 evaluation
        EditText question2Ans = (EditText) findViewById(R.id.question2_text);
        String text= question2Ans.getText().toString();
        if(text.equalsIgnoreCase("vulcanizing")){
            grade+=1;
        }

        //Question3 evaluation
        CheckBox question3_choiceA =(CheckBox) findViewById(R.id.question3_choiceA);
        CheckBox question3_choiceB =(CheckBox) findViewById(R.id.question3_choiceB);
        CheckBox question3_choiceC =(CheckBox) findViewById(R.id.question3_choiceC);
        CheckBox question3_choiceD =(CheckBox) findViewById(R.id.question3_choiceD);
        if(question3_choiceA.isChecked() && !question3_choiceB.isChecked() && question3_choiceC.isChecked()&& !question3_choiceD.isChecked() ){
            grade+=1;
        }
        //Question4 evaluation
        EditText question4Ans = (EditText) findViewById(R.id.question4_text);
        text= question4Ans.getText().toString();
        if(text.equalsIgnoreCase("gravity")){
            grade+=1;
        }
        //Question5 evaluation
        CheckBox question5_choiceA =(CheckBox) findViewById(R.id.question5_choiceA);
        CheckBox question5_choiceB =(CheckBox) findViewById(R.id.question5_choiceB);
        CheckBox question5_choiceC =(CheckBox) findViewById(R.id.question5_choiceC);
        CheckBox question5_choiceD =(CheckBox) findViewById(R.id.question5_choiceD);
        if(!question5_choiceA.isChecked() && !question5_choiceB.isChecked() && question5_choiceC.isChecked()&& question5_choiceD.isChecked() ){
            grade+=1;
        }
        //Question6 evaluation
        EditText question6Ans = (EditText) findViewById(R.id.question6_text);
        text= question6Ans.getText().toString();
        if(text.equalsIgnoreCase("wrist")){
            grade+=1;
        }
        //Question7 evaluation
        RadioButton question7Ans = (RadioButton) findViewById(R.id.question7_choice2);
        if(question7Ans.isChecked()){
            grade+=1;
        }
        String message;
        if(grade==7){
            message="Congrats!!! you scored 7 out of 7";
        } else {
            message="You have scored only "+grade+"out of 7, Try Again!!";
        }
        return message;
    }


    /**
     * This method is used to send the result to email
     */
    public void sendResultToemail(String finalResult){

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_SUBJECT,"Your final results !!!!");
        email.putExtra(Intent.EXTRA_TEXT,finalResult);
        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(email);
        }
    }

    /**
     * Toast message if user clicks gradle
     */
    public void gradleToastMsg(View view){
        String message= evaluateAndGrade();
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
