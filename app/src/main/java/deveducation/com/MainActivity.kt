package deveducation.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var click : String = ""
    private var number1Input : String = ""
    private var number2Input : String = ""
    var operatorInput : String = ""
    var firstOp : Boolean = true
    var isDot: Boolean = true
    var isOp : Boolean = false
    private var resultMain : Double = 0.0
    var isEqual : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun equal(view: View) {
        var display = operations.text.toString()

        if(display == "" ) {
            operations.text = ""
        } else if(display.endsWith(".") || display.endsWith("+") || display.endsWith("-") || display.endsWith("*") || display.endsWith("/")) {
            operations.text = display
            isOp = false
        } else if (display.contains("/0")){
            operations.text = "!Cannot divided by ZERO"
        } else {
            val ex = ExpressionBuilder(operations.text.toString()).build()
            resultMain = ex.evaluate()

            var checkType = resultMain.toInt()
            if (resultMain == checkType.toDouble()) {
                result.text = checkType.toString()
                operations.text = number1Input
            } else {
                result.text = resultMain.toString()
                operations.text = number1Input
            }
            isOp = true
        }
        isDot = true
    }

    fun operationNumbers(view: View) {
        if (firstOp)
            operations.text = ""
        firstOp = false
        click = operations.text.toString()
        val numResult : Button = view as Button

        when (numResult.id) {
            button_0.id -> {
                if(isEqual){
                    click += 0
                    isEqual =false
                }
                if(!isDot){
                    click += 0
                } else {
                    operations.text = click
                }
            }
            button_1.id -> {
                click += "1"
                isOp = true
            }
            button_2.id -> {
                click += "2"
                isOp = true
            }
            button_3.id -> {
                click += "3"
                isOp = true
            }
            button_4.id -> {
                click += "4"
                isOp = true
            }
            button_5.id -> {
                click += "5"
                isOp = true
            }
            button_6.id -> {
                click += "6"
                isOp = true
            }
            button_7.id -> {
                click += "7"
                isOp = true
            }
            button_8.id -> {
                click += "8"
                isOp = true
            }
            button_9.id -> {
                click += "9"
                isOp = true
            }
            button_dot.id -> {
                if (click.isNotEmpty() && isDot) {
                    repeat(1) {
                        click += "."
                        isOp = false
                        isDot = false
                    }
                }
            }
        }

        operations.text = click

        if(number1Input == "") {
            number1Input += click
            click = ""
        } else {
            number2Input = number1Input + click
            number1Input = ""
            click = ""
        }
    }

    fun mathOperations(view : View) {
        if(result.text != "") {
            operations.text = result.text
            result.text = ""
        }

        operatorInput = operations.text.toString()
        val opResult = view as Button
        if (isOp) {
            when(opResult.id){
                button_plus.id -> {
                    repeat(1) {
                        operatorInput += "+"
                        isOp = false
                        isDot = true
                    }
                }
                button_minus.id -> {
                    repeat(1) {
                        operatorInput += "-"
                        isOp = false
                        isDot = true
                    }
                }
                button_multiply.id -> {
                    repeat(1) {
                        operatorInput += "*"
                        isOp = false
                        isDot = true
                    }
                }
                button_divide.id -> {
                    repeat(1) {
                        operatorInput += "/"
                        isOp = false
                        isDot = true
                    }
                }
            }
        }

        operations.text = operatorInput
        number1Input += operatorInput
        operatorInput = ""
    }

    fun clear(view: View) {
        operations.text = ""
        result.text = ""
        isOp = false
        isDot = true
        isEqual = true
    }

    fun delete(view: View) {
        var display = operations.text.toString()

        if (display.isNotEmpty()) {
            operations.text = display.substring(0, display.length-1)
        } else {
            operations.text = ""
        }
        isOp = true
        isDot = true
        isEqual = true
    }
}

