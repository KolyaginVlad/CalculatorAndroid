package com.example.calculator;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        text = new TextView(this);
        text.setWidth((int) (size.x * 0.94));
        text.setHeight((int) (size.y * 0.6));
        text.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        text.setTextSize(34);
        text.setShadowLayer(5, 2, 2, Color.GRAY);
        //
        Button button1 = new Button(this);
        Button button2 = new Button(this);
        Button button3 = new Button(this);
        Button button4 = new Button(this);
        Button button5 = new Button(this);
        Button button6 = new Button(this);
        Button button7 = new Button(this);
        Button button8 = new Button(this);
        Button button9 = new Button(this);
        Button button0 = new Button(this);
        Button button00 = new Button(this);
        Button buttonPlus = new Button(this);
        Button buttonMinus = new Button(this);
        Button buttonMul = new Button(this);
        Button buttonDiv = new Button(this);
        Button buttonDot = new Button(this);
        Button buttonOpen = new Button(this);
        Button buttonClose = new Button(this);
        Button buttonEq = new Button(this);
        Button buttonDel = new Button(this);
        //
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        button0.setText("0");
        button00.setText("00");
        buttonPlus.setText("+");
        buttonMinus.setText("-");
        buttonMul.setText("*");
        buttonDiv.setText("/");
        buttonDot.setText(".");
        buttonOpen.setText("(");
        buttonClose.setText(")");
        buttonEq.setText("=");
        buttonDel.setText("←");
        //
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch3();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch4();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch5();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch6();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch7();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch8();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch9();
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch0();
            }
        });
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Touch00();
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchPlus();
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchMinus();
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchMultiply();
            }
        });
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchDel();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchDivide();
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchDot();
            }
        });
        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchOpen();
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchClose();
            }
        });
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchEqual();
            }
        });
        //
        ConstraintLayout layout = findViewById(R.id.lay);
        layout.addView(text);
        text.setX(size.x * 0.03f);
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(4);
        layout.addView(gridLayout, size.x, (int) (size.y * 0.4));
        final float XK = 0.25f;
        final float YK = 0.07f;
        gridLayout.addView(buttonOpen, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonClose, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonDel, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonDiv, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button7, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button8, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button9, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonMul, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button4, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button5, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button6, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonPlus, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button1, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button2, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button3, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonMinus, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button0, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonDot, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(button00, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.addView(buttonEq, (int) (size.x * XK), (int) (size.y * YK));
        gridLayout.setY(size.y * 0.6f);
        //
        ex = "";
        opened = 0;
        closed = 0;
        dotAdd = false;
    }

    public void Touch1() {
        text.append("1");
        ex += "1";
    }

    public void Touch2() {
        text.append("2");
        ex += "2";
    }

    public void Touch3() {
        text.append("3");
        ex += "3";
    }

    public void Touch4() {
        text.append("4");
        ex += "4";
    }

    public void Touch5() {
        text.append("5");
        ex += "5";
    }

    public void Touch6() {
        text.append("6");
        ex += "6";
    }

    public void Touch7() {
        text.append("7");
        ex += "7";
    }

    public void Touch8() {
        text.append("8");
        ex += "8";
    }

    public void Touch9() {
        text.append("9");
        ex += "9";
    }

    public void Touch0() {
        text.append("0");
        ex += "0";
    }

    public void TouchOpen() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a == '+' || a == '-' || a == '*' || a == '/' || a == '(') {
                text.append("(");
                ex += "(";
                opened++;
            }
        } else {
            text.append("(");
            ex += "(";
            opened++;
        }
    }

    public void TouchClose() {
        if (ex.length() != 0) {
            if (opened > closed) {
                char a = ex.charAt(ex.length() - 1);//Последний символ
                if (a != '+' && a != '-' && a != '*' && a != '/' && a != '(') {
                    text.append(")");
                    ex += ")";
                    closed++;
                }
            }
        }
    }

    public void Touch00() {
        text.append("00");
        ex += "00";
    }

    public void TouchPlus() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '(' && a != '.') {
                text.append("+");
                ex += "+";
                dotAdd = false;
                //добавляем сложение и даём возможность вновь ставить точку
            }
        }
    }

    public void TouchMinus() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '.') {
                text.append("-");
                ex += "-";
                dotAdd = false;
                //добавляем вычитание и даём возможность вновь ставить точку
            }
        } else {
            //минус может стоять в самом начале перед числом
            text.append("-");
            ex += "-";
            dotAdd = false;
            //аналогично
        }
    }

    public void TouchMultiply() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '(' && a != '.') {
                text.append("*");
                ex += "*";
                dotAdd = false;
                //добавляем умножение и даём возможность вновь ставить точку
            }
        }
    }

    public void TouchDivide() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '(' && a != '.') {
                text.append("/");
                ex += "/";
                dotAdd = false;
                //добавляем деление и даём возможность вновь ставить точку
            }
        }
    }

    public void TouchEqual() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '.') {
                for (int i = 0; i < opened - closed; i++) {
                    text.append(")");
                    ex += ")";
                    //закрываем все открытые скобки
                }

                text.append("=" + result(ex) + "\n\n");
                ex = "";
                opened = 0;
                closed = 0;
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
                    if (k >= 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a != '+' && a != '-' && a != '*' && a != '/') {
                            buffer.replace(start, end, "+" + k + "");

                        } else buffer.replace(start, end, k + "");
                    } else if (k < 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a == '+')
                            buffer.replace(start - 1, end, k + "");
                        else buffer.replace(start, end, k + "");
                    } else
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
                    if (k >= 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a != '+' && a != '-' && a != '*' && a != '/') {
                            buffer.replace(start, end, "+" + k + "");

                        } else buffer.replace(start, end, k + "");
                    } else if (k < 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a == '+')
                            buffer.replace(start - 1, end, k + "");
                        else buffer.replace(start, end, k + "");
                    } else
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
                    if (k >= 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a != '+' && a != '-' && a != '*' && a != '/') {
                            buffer.replace(start, end, "+" + k + "");

                        } else buffer.replace(start, end, k + "");
                    } else if (k < 0 && start != 0) {
                        char a = buffer.charAt(start - 1);
                        if (a == '+')
                            buffer.replace(start - 1, end, k + "");
                        else buffer.replace(start, end, k + "");
                    } else
                        buffer.replace(start, end, k + "");
                    matcher = pattern.matcher(buffer);//обновляем
                }

                return buffer;
            }else {
                //Если скобки есть...
                Pattern pattern = Pattern.compile("\\([^(]*\\)");//Регулярка для нахождения ближайшей открывшейся и закрывшейся скобок
                Matcher matcher = pattern.matcher(buffer);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    String s1 = buffer.substring(start + 1, end - 1);
                    String s2 = result(s1).toString();
                    if (s2.charAt(0) != '-' && buffer.charAt(start - 1) != '+' && buffer.charAt(start - 1) != '-')
                        buffer.replace(start, end, s2);
                    else if (s2.charAt(0) != '-' && buffer.charAt(start - 1) != '-')
                        buffer.replace(start - 1, end, "+" + s2.substring(1));
                    else if (s2.charAt(0) != '-' && buffer.charAt(start - 1) != '+')
                        buffer.replace(start - 1, end, s2);
                    else buffer.replace(start, end, s2);
                    matcher = pattern.matcher(buffer);//обновляем
                }
                return result(buffer.toString());
            }
        } catch (Exception e) {
            StringBuffer buffer = new StringBuffer("Ошибка");
            e.printStackTrace();
            //Что-то случилось...
            return buffer;
        }
    }

    public void TouchDel() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);
            if (a == '(') opened--;
            else if (a == ')') closed--;
            text.setText(text.getText().toString().substring(0, text.getText().length() - 1));
            ex = ex.substring(0, ex.length() - 1);

            //удаляем последний символ
        }
    }

    public void TouchDot() {
        if (ex.length() != 0) {
            char a = ex.charAt(ex.length() - 1);//Последний символ
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '(' && a != ')' && a != '.' && !dotAdd) {
                text.append(".");
                ex += ".";
                dotAdd = true;
                //ставим точку
            }
        }
    }

}