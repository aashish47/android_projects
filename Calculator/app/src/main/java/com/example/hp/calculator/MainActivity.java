package com.example.hp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonEquals,buttonDecimal,buttonDel,buttonDivide,buttonAdd,buttonSubtract,buttonMultiply,buttonClear;
    TextView tvCalculation;
    static char operator = ' ' ;
    static Queue<String> queue = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static  String current_number = "";
    static boolean isLastInputOperator = false;
    static  boolean hasDecimal = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 =(Button) findViewById(R.id.button0);
        button1 =(Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button) findViewById(R.id.button3);
        button4 =(Button) findViewById(R.id.button4);
        button5 =(Button) findViewById(R.id.button5);
        button6 =(Button) findViewById(R.id.button6);
        button7 =(Button) findViewById(R.id.button7);
        button8 =(Button) findViewById(R.id.button8);
        button9 =(Button) findViewById(R.id.button9);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEquals =(Button) findViewById(R.id.buttonEquals);
        buttonDecimal =(Button) findViewById(R.id.buttonDecimal);
        buttonAdd =(Button) findViewById(R.id.buttonAdd);
        buttonSubtract =(Button) findViewById(R.id.buttonSubtract);
        buttonMultiply =(Button) findViewById(R.id.buttonMultiply);
        buttonDivide =(Button) findViewById(R.id.buttonDivide);
        tvCalculation = (TextView) findViewById(R.id.tvCalculation);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add("0");
                current_number = currentNumber(operator,"0");
                tvCalculation.setText(current_number);
                isLastInputOperator = false;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add("1");
                current_number = currentNumber(operator,"1");
                tvCalculation.setText(current_number);
                isLastInputOperator = false;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add("2");
                current_number = currentNumber(operator,"2");
                tvCalculation.setText(current_number);
                isLastInputOperator = false;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add("3");
                current_number = currentNumber(operator,"3");
                tvCalculation.setText(current_number);
                isLastInputOperator = false;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add("4");
                current_number = currentNumber(operator,"4");
                tvCalculation.setText(current_number);
                isLastInputOperator = false;
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_number = currentNumber(operator,"5");
                tvCalculation.setText(current_number);
                queue.add("5");
                isLastInputOperator = false;
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_number = currentNumber(operator,"6");
                tvCalculation.setText(current_number);
                queue.add("6");
                isLastInputOperator = false;
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_number = currentNumber(operator,"7");
                tvCalculation.setText(current_number);
                queue.add("7");
                isLastInputOperator = false;
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_number = currentNumber(operator,"8");
                tvCalculation.setText(current_number);
                queue.add("8");
                isLastInputOperator = false;
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_number = currentNumber(operator,"9");
                tvCalculation.setText(current_number);
                queue.add("9");
                isLastInputOperator = false;
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                if(!isLastInputOperator) {
                    if(operator == ' '){
                        operator = '+';
                    }
                    calculate('+', operator);
                }
                else {
                    current_number = ""+stack.peek() + "+";
                    tvCalculation.setText(current_number);
                    operator = '+';
                    isLastInputOperator = true;
                }
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                if(!isLastInputOperator){
                    if(operator == ' '){
                        operator = '-';
                    }
                calculate('-',operator);
                }
                else {
                    current_number = ""+stack.peek() + "-";
                    tvCalculation.setText(current_number);
                    operator = '-';
                    isLastInputOperator = true;
                }
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                if(!isLastInputOperator) {
                    if(operator == ' '){
                        operator = 'x';
                    }
                    calculate('x', operator);
                }
                else {
                    current_number = ""+stack.peek() + "x";
                    tvCalculation.setText(current_number);
                    operator = 'x';
                    isLastInputOperator = true;
                }
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                if(!isLastInputOperator) {
                    if(operator == ' '){
                        operator = '/';
                    }
                    calculate('/', operator);
                }
                else {
                    current_number = ""+stack.peek() + "/";
                    tvCalculation.setText(current_number);
                    operator = '/';
                    isLastInputOperator = true;
                }
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                if(!isLastInputOperator) {
                    if((!stack.isEmpty()&&!queue.isEmpty())||(stack.isEmpty()&&!queue.isEmpty())) {
                        if(operator == ' '){
                            operator = '=';
                        }
                        calculate('=', operator);
                    }
                    else if(!stack.isEmpty()&&queue.isEmpty()){
                        current_number = ""+stack.peek();
                        tvCalculation.setText(current_number);
                        isLastInputOperator = false;
                    }
                }
                else {
                    current_number = ""+stack.peek();
                    tvCalculation.setText(current_number);
                    operator = ' ';
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = ' ';
                current_number = "";
                tvCalculation.setText("0");
                while (!stack.isEmpty()){
                    stack.pop();
                }
                while (!queue.isEmpty()){
                    queue.remove();
                }
                isLastInputOperator = false;
                hasDecimal = false;
            }
        });
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_number.length()==0){
                    return;
                }
                char lastChar = current_number.charAt(current_number.length()-1);
                current_number = current_number.substring(0,current_number.length()-1);
                tvCalculation.setText(current_number);
                if(lastChar=='+'||lastChar=='-'||lastChar=='x'||lastChar=='/'){
                    operator = ' ';
                }
                else if(!queue.isEmpty()){
                    removeLast();
                }
                else if(!stack.isEmpty()){
                    String temp = ""+stack.pop();
                    temp = temp.substring(0,temp.length()-1);

                    stack.push(temp);
                }
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasDecimal == false){
                    if(operator == ' ' && queue.isEmpty()){
                        current_number ="0.";
                        while (!stack.isEmpty()){
                            stack.pop();
                        }
                    }
                    else {
                        current_number += ".";
                    }
                    queue.add(".");
                    hasDecimal = true;
                    tvCalculation.setText(current_number);
                    isLastInputOperator = false;
                }
            }
        });
    }

    public void calculate(char operatorClickedNow,char previousOperator){
        if(queue.isEmpty()){
            current_number +=operatorClickedNow;
            tvCalculation.setText(current_number);
            operator=operatorClickedNow;
            isLastInputOperator = true;
            return;
        }

        double a = 0;
        double base = 1;
        while (!queue.isEmpty()){
            if(queue.peek()=="."){
                queue.remove();
                hasDecimal = false;
                base = 10;
                while (!queue.isEmpty()){
                    a +=Double.valueOf(queue.remove())/base;
                    base *=10;
                }
                break;
            }
            a = a * base;
            a += Double.valueOf(queue.remove()) ;
            base =  10;
        }
        String s = ""+a;
        s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
        if(stack.isEmpty()){
            if(operatorClickedNow!='='){
                current_number +=operatorClickedNow;
            }
            tvCalculation.setText(current_number);
            stack.push(s);
            operator = operatorClickedNow;
            isLastInputOperator = true;
        }
        else{
            if(previousOperator == '+'){
                a = a + Double.valueOf(stack.pop());
            }
            if(previousOperator == '-'){
                a = Double.valueOf(stack.pop()) - a;
            }
            if(previousOperator == 'x'){
                a = a * Double.valueOf(stack.pop());
            }
            if(previousOperator == '/'){
                if(a==0){
                    Toast.makeText(this,"Not Defined",Toast.LENGTH_LONG).show();
                    operator = ' ';
                    current_number = "";
                    tvCalculation.setText("0");
                    while (!stack.isEmpty()){
                        stack.pop();
                    }
                    while (!queue.isEmpty()){
                        queue.remove();
                    }
                    isLastInputOperator = false;
                    hasDecimal = false;
                    return;
                }
                a = Double.valueOf(stack.pop())/a;
            }
            s = ""+a;
            s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");

            if(operatorClickedNow=='='){
                operator = ' ';
                current_number = "" + s;
                isLastInputOperator = false;
            }
            else {
                operator = operatorClickedNow;
                current_number = "" + s + operator;
                isLastInputOperator = true;
            }
                stack.push(s);
                tvCalculation.setText(current_number);
        }
    }
    public static String currentNumber(char operator,String number){
        if(operator ==' '&&queue.isEmpty()){
            while (!stack.isEmpty()){
                stack.pop();
            }
            current_number = number;
        }
        else {
            current_number +=number;
        }
        return current_number;
    }
    void removeLast() {
        int count =0;
        while (count!=queue.size()-1){
            queue.add(queue.remove());
            count++;
        }
        queue.remove();
    }
}