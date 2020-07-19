package com.example.calculatorwithkotlin_vbtinternship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var operator = "*"
    var oldCount=""
    var newOperator=true

    fun btn_Click(view: View) {

        if (newOperator){
            output.setText("")
        }
        newOperator=false

        var btnSelect = view as Button
        var btnClickValue:String = output.text.toString()
        when(btnSelect.id){
            btn_zero.id->{
                btnClickValue+="0"
            }
            btn_one.id->{
                btnClickValue+="1"
            }
            btn_two.id->{
                btnClickValue+="2"
            }
            btn_three.id->{
                btnClickValue+="3"
            }
            btn_four.id->{
                btnClickValue+="4"
            }
            btn_five.id->{
                btnClickValue+="5"
            }
            btn_six.id->{
                btnClickValue+="6"
            }
            btn_seven.id->{
                btnClickValue+="7"
            }
            btn_eight.id->{
                btnClickValue+="8"
            }
            btn_nine.id->{
                btnClickValue+="9"
            }
            btn_minus.id->{
                btnClickValue="-"+btnClickValue
            }
        }


        output.setText(btnClickValue)
    }


    fun btn_Operator(view: View) {
        var btn_Select= view as Button
        when(btn_Select.id){
            btn_division.id->{
                operator="/"
            }
            btn_cross.id->{
                operator="*"
            }
            btn_minus.id->{
                operator="-"
            }
            btn_plus.id->{
                operator="+"
            }
        }
        oldCount=output.text.toString()
        newOperator=true
    }

    fun Equals(view: View) {
        var newCount=output.text.toString()
        var result:Double?=null

        when(operator){
            "/"->{
                result=oldCount.toDouble()/newCount.toDouble()
            }
            "*"->{
                result=oldCount.toDouble()*newCount.toDouble()
            }
            "-"->{
                result=oldCount.toDouble()-newCount.toDouble()
            }
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        output.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        output.setText("0")
        newOperator=true
    }
    fun Percent(view: View) {

        var count:Double=output.text.toString().toDouble()/100
        output.setText(count.toString())
        newOperator=true
    }
}