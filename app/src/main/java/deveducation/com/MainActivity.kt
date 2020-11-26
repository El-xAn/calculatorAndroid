package deveducation.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var operations:TextView
    private var num: String = ""
    private var op: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operations = findViewById(R.id.operations)
    }


    fun operationNumbers(view: View) {
        num += view.tag.toString()
        operations.text = num

    }

    fun operationOperators(view: View) {
        op += view.tag.toString()

        if (op == "10") { operations.text = "+" }
        if (op == "11") { operations.text = "-" }
        if (op == "12") { operations.text = "*" }
        if (op == "13") { operations.text = "/" }
        if (op == "15") { operations.text = "." }

    }


    fun clear(view: View) {
        operations.text = ""
        op = ""
    }

    fun delete(view: View) {
        if (num.isNotEmpty()) {
            operations.text = num.substring(0, num.length-1)
            num = operations.text.toString()
        } else {
            operations.text = ""
        }
    }
}




//    val res = result.text.toString()
//    val op = operations.text.toString()
//    val op1 = operations.text.toString()
//    val op2 = operations.text.toString()
//    val op3 = operations.text.toString()

//    fun math_numbers(num: Int) {
//
//    }
//
////    fun equal() {
////        res
////    }
//    fun math_operations(str: String) {
//        operations.text.toString()
////        if(op.isNotEmpty()) {
////            if(str == "+") {
////                repeat(1) {
////                    operations.append(str)
////                }
////            }
////            if(str == "-") {
////                repeat(1) {
////                    operations.append(str)
////                }
////            }
////            if(str == "*") {
////                repeat(1) {
////                    operations.append(str)
////                }
////            }
////            if(str == "/") {
////                repeat(1) {
////                    operations.append(str)
////                }
////            }
////        }
////
//    }

