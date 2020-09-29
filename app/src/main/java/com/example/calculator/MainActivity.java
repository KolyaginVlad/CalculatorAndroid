package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView text;
    String ex;
    int opened;
    int closed;
    boolean dotAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        ex = "";
        opened = 0;
        closed = 0;
        dotAdd = false;
    }

    public void Touch1(View w){
        text.append("1");
        ex+="1";
    }
    public void Touch2(View w){
        text.append("2");
        ex+="2";
    }
    public void Touch3(View w){
        text.append("3");
        ex+="3";
    }
    public void Touch4(View w){
        text.append("4");
        ex+="4";
    }
    public void Touch5(View w){
        text.append("5");
        ex+="5";
    }
    public void Touch6(View w){
        text.append("6");
        ex+="6";
    }
    public void Touch7(View w){
        text.append("7");
        ex+="7";
    }
    public void Touch8(View w){
        text.append("8");
        ex+="8";
    }
    public void Touch9(View w){
        text.append("9");
        ex+="9";
    }
    public void Touch0(View w){
        text.append("0");
        ex+="0";
    }
    public void TouchOpen(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a == '+' || a == '-' || a == '*' || a == '/'|| a == '(') {
                text.append("(");
                ex+="(";
                opened++;
            }
        }else {
            text.append("(");
            ex+="(";
            opened++;
        }
    }
    public void TouchClose(View w){
        if (ex.length()!=0) {
            if (opened>closed) {
                char a = ex.charAt(ex.length() - 1);//Последний символ
                if (a != '+' && a != '-' && a != '*' && a != '/'&& a != '(') {
                    text.append(")");
                    ex += ")";
                    closed++;
                }
            }
        }
    }
    public void Touch00(View w){
        text.append("00");
        ex+="00";
    }
    public void TouchPlus(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/'&& a != '('&&a != '.') {
                text.append("+");
                ex+="+";
                dotAdd = false;
                //добавляем сложение и даём возможность вновь ставить точку
            }
        }
    }
    public void TouchMinus(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' &&a != '.') {
                text.append("-");
                ex+="-";
                dotAdd = false;
                //добавляем вычитание и даём возможность вновь ставить точку
            }
        } else {
            //минус может стоять в самом начале перед числом
            text.append("-");
            ex+="-";
            dotAdd = false;
            //аналогично
        }
    }
    public void TouchMultiply(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/'&& a != '('&&a != '.') {
                text.append("*");
                ex+="*";
                dotAdd = false;
                //добавляем умножение и даём возможность вновь ставить точку
            }
        }
    }
    public void TouchDivide(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/'&& a != '('&&a != '.') {
                text.append("/");
                ex+="/";
                dotAdd = false;
                //добавляем деление и даём возможность вновь ставить точку
            }
        }
    }
    public void TouchEqual(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/'&&a != '.') {
                for (int i = 0; i <opened-closed ; i++) {
                    text.append(")");
                    ex += ")";
                    //закрываем все открытые скобки
                }

                text.append("="+result(ex)+"\n\n");
                ex = "";
                opened =0;
                closed =0;
                dotAdd = false;
                //приводим всё в изначальный вид
            }
        }
    }

    private StringBuffer result(String s) {
        try {
            StringBuffer buffer = new StringBuffer(s);
            if (buffer.indexOf("(")==-1) {
                //Если нет скобок...
                Pattern pattern1 = Pattern.compile("-?[0-9]+?\\.?[0-9]*[*/]-?[0-9]+\\.?[0-9]*");//Проверяем наличие умножения или деления(раздельно нельзя)
                Matcher matcher1 = pattern1.matcher(buffer);
                while (matcher1.find()) {
                    int start = matcher1.start();
                    int end = matcher1.end();
                    String s1 = buffer.substring(start, end);
                    double k;
                    if (s1.indexOf("/") == -1) {//если нет деления, то это умножение
                        String[] split = s1.split("\\*");
                        k = Double.parseDouble(split[0]) * Double.parseDouble(split[1]);
                    } else {
                        String[] split = s1.split("/");
                        k = Double.parseDouble(split[0]) / Double.parseDouble(split[1]);
                    }
                    buffer.replace(start, end, k + "");
                    matcher1 = pattern1.matcher(buffer);//обновляем
                }
                Pattern pattern3 = Pattern.compile("-?[0-9]+?\\.?[0-9]*[+][0-9]+\\.?[0-9]*");//проверяем есть ли действие сложения
                Matcher matcher3 = pattern3.matcher(buffer);
                while (matcher3.find()) {
                    int start = matcher3.start();
                    int end = matcher3.end();
                    String s1 = buffer.substring(start, end);
                    String[] split = s1.split("\\+");
                    double k = Double.parseDouble(split[0]) + Double.parseDouble(split[1]);
                    buffer.replace(start, end, k + "");
                    matcher3 = pattern3.matcher(buffer);//обновляем
                }
                Pattern pattern = Pattern.compile("-?[0-9]+?\\.?[0-9]*[-][0-9]+\\.?[0-9]*");//проверяем есть ли действие вычитания
                Matcher matcher = pattern.matcher(buffer);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    String s1 = buffer.substring(start, end);
                    String[] split = new String[2];
                    split[0] = s1.substring(0, s1.lastIndexOf("-"));
                    split[1] = s1.substring(s1.lastIndexOf("-") + 1);
                    double k = Double.parseDouble(split[0]) - Double.parseDouble(split[1]);
                    buffer.replace(start, end, k + "");
                    matcher3 = pattern3.matcher(buffer);//обновляем
                }
                return buffer;
            }else {
                //Если скобки есть...
                Pattern pattern = Pattern.compile("\\([^(]*\\)");//Регулярка для нахождения ближайшей открывшейся и закрывшейся скобок
                Matcher matcher = pattern.matcher(buffer);
                while (matcher.find()){
                    int start = matcher.start();
                    int end = matcher.end();
                    String s1 = buffer.substring(start+1, end-1);
                    buffer.replace(start, end, result(s1).toString());
                    matcher = pattern.matcher(buffer);//обновляем
                }
                return result(buffer.toString());
            }
        }catch (Exception e){
            StringBuffer buffer = new StringBuffer("Ошибка");
            e.printStackTrace();
            //Что-то случилось...
            return buffer;
        }
    }

    public void TouchDel(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);
            if (a=='(') opened--;
            else if (a==')') closed--;
            text.setText(text.getText().toString().substring(0, text.getText().length() - 1));
            ex = ex.substring(0, ex.length() - 1);

            //удаляем последний символ
        }
    }
    public void TouchDot(View w){
        if (ex.length()!=0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/'&&a != '('&&a != ')'&&a != '.'&&!dotAdd) {
                text.append(".");
                ex += ".";
                dotAdd = true;
                //ставим точку
            }
        }
    }

}