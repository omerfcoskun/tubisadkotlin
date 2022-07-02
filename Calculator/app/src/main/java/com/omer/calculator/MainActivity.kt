package com.omer.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.omer.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim=ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.one.setOnClickListener{appendOnExprestion("1",true)}
        tasarim.two.setOnClickListener{appendOnExprestion("2",true)}
        tasarim.three.setOnClickListener{appendOnExprestion("3",true)}
        tasarim.four.setOnClickListener{appendOnExprestion("4",true)}
        tasarim.five.setOnClickListener{appendOnExprestion("5",true)}
        tasarim.six.setOnClickListener{appendOnExprestion("6",true)}
        tasarim.seven.setOnClickListener{appendOnExprestion("7",true)}
        tasarim.eight.setOnClickListener{appendOnExprestion("8",true)}
        tasarim.nine.setOnClickListener{appendOnExprestion("9",true)}
        tasarim.zero.setOnClickListener{appendOnExprestion("0",true)}
        tasarim.sum1.setOnClickListener{appendOnExprestion("+",false)}

        tasarim.AC.setOnClickListener{
            tasarim.Expression.text=""
            tasarim.Result1.text=""
        }

        tasarim.equal.setOnClickListener{
            try {
                val expression=ExpressionBuilder(tasarim.Expression.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble())
                    tasarim.Result1.text=longResult.toString()
                else
                    tasarim.Result1.text=result.toString()

            }
            catch (e:Exception){
                Log.d("Exception","message : "+ e.message)
            }
        }

    }
    fun appendOnExprestion(string: String,canClear:Boolean )
    {
        if (canClear){
            tasarim.Result1.text=""
            tasarim.Expression.append(string)

        }
        else{
            tasarim.Expression.append(tasarim.Result1.text)
            tasarim.Expression.append(string)
            tasarim.Result1.text=""


        }
    }
}