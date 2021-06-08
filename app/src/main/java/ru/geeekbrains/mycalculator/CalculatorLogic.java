package ru.geeekbrains.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorLogic implements Parcelable {

    Long numberOne = null;
    String operator = null;
    Long numberTwo = null;

    public Long getNumberOne() {
        return numberOne;
    }

    public String getOperator() {
        return operator;
    }

    public Long getNumberTwo() {
        return numberTwo;
    }

    public CalculatorLogic() {

    }

    protected CalculatorLogic(Parcel in) {
        if (in.readByte() == 0) {
            numberOne = null;
        } else {
            numberOne = in.readLong();
        }
        operator = in.readString();
        if (in.readByte() == 0) {
            numberTwo = null;
        } else {
            numberTwo = in.readLong();
        }
    }

    public static final Creator<CalculatorLogic> CREATOR = new Creator<CalculatorLogic>() {
        @Override
        public CalculatorLogic createFromParcel(Parcel in) {
            return new CalculatorLogic(in);
        }

        @Override
        public CalculatorLogic[] newArray(int size) {
            return new CalculatorLogic[size];
        }
    };

    void numberButton (Button b, TextView t){
        String temp = t.getText() + (String) b.getText();
        numberTwo = Long.parseLong(temp);
        t.setText(temp);
    }

    void operatorButton (Button b, TextView t1, TextView t2, TextView to){
        String temp = (String) t1.getText();
        operator = (String) b.getText();
        t1.setText(null);
        t2.setText(temp);
        to.setText(operator);
        numberOne = Long.parseLong(temp);
    }

    void clearButton(TextView t1, TextView t2, TextView to){
        t1.setText(null);
        t2.setText(null);
        to.setText(null);
        numberOne = null;
        operator = null;
    }

    void answerButton (TextView t1, TextView t2, TextView to){
        long answer;
        numberTwo = Long.parseLong((String) t1.getText());
        switch (operator){
            case "+":
                answer = numberOne + numberTwo;
                break;
            case "-":
                answer = numberOne - numberTwo;
                break;
            case "*":
                answer = numberOne * numberTwo;
                break;
            default:
                answer = numberOne / numberTwo;
                break;
        }

        String value = numberOne + operator + numberTwo + "="+ answer;

        t2.setText(value);
        to.setText(null);
        t1.setText(null);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (numberOne == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numberOne);
        }
        dest.writeString(operator);
        if (numberTwo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numberTwo);
        }
    }
}
