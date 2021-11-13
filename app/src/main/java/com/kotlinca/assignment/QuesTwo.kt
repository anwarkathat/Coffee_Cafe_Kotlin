package com.kotlinca.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class QuesTwo : AppCompatActivity() {
    private var finalItemList : String = ""
    var itemsList: MutableList<String> = mutableListOf()
    var itemsListAddon: MutableList<String> = mutableListOf()
    var optionalItem : String  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ques_two)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val orderBtn : MaterialButton = findViewById(R.id.order_btn)

        //CheckBox Initialization
        val checkbox_latte : CheckBox = findViewById(R.id.checkbox_latte)
        val checkbox_coffee : CheckBox = findViewById(R.id.checkbox_coffee)
        val checkbox_cappuccino : CheckBox = findViewById(R.id.checkbox_cappuccino)
        val checkbox_iced_coffee : CheckBox = findViewById(R.id.checkbox_iced_coffee)

        //RadioButton Initialization
        val radio_group : RadioGroup = findViewById(R.id.radio_group)
        val radio_choco : RadioButton = findViewById(R.id.radio_choco)
        val radio_drink : RadioButton = findViewById(R.id.radio_drink)

        val editText : TextInputEditText = findViewById(R.id.edit_text)

        orderBtn.setOnClickListener {

            if(itemsListAddon.size == 0 && itemsList.size == 0){
                Toast.makeText(this,"Please Add Some Items",Toast.LENGTH_SHORT).show()
            }

            if(checkbox_latte.isChecked){
                itemsList.add("> Blonde Cafe Latte")
                checkbox_latte.toggle()
            }
            if(checkbox_coffee.isChecked){
                itemsList.add("> Hot Coffee")
                checkbox_coffee.toggle()
            }
            if(checkbox_cappuccino.isChecked){
                itemsList.add("> Cappuccino")
                checkbox_cappuccino.toggle()
            }
            if(checkbox_iced_coffee.isChecked){
                itemsList.add("> Iced Coffee")
                checkbox_iced_coffee.toggle()
            }

            radio_group.setOnCheckedChangeListener{
                    _, selected_id ->
                val radioBtn : RadioButton = findViewById(selected_id)
                when(radioBtn){
                    radio_choco->{
                        itemsListAddon.add("> Choco Lava")

                    }
                    radio_drink->{
                        itemsListAddon.add("> Cold Drink")
                    }

                }
            }
            if(editText.text.toString()!=""){
                optionalItem  = editText.text.toString()
            }
            if(itemsListAddon.size != 0 && itemsList.size != 0){
                finalItemList += "Your Order\n\n Selected Menu Items : \n"
                for(items in itemsList){
                    finalItemList += items + "\n"
                }
                finalItemList += "\nAddon Item : \n"
                for(item in itemsListAddon){
                    finalItemList += item + "\n"
                }
                if(optionalItem!=""){
                    finalItemList += "\nOptional Item : " +  optionalItem
                }

                Toast.makeText(this,finalItemList,Toast.LENGTH_LONG).show()

                if(checkbox_latte.isChecked){
                    checkbox_latte.toggle()
                }
                if(checkbox_coffee.isChecked){
                    checkbox_coffee.toggle()
                }
                if(checkbox_cappuccino.isChecked){
                    checkbox_cappuccino.toggle()
                }
                if(checkbox_iced_coffee.isChecked){
                    checkbox_iced_coffee.toggle()
                }
                if(radio_choco.isChecked){
                    radio_choco.isChecked = false
                }
                if(radio_drink.isChecked){
                    radio_drink.isChecked = false
                }
                editText.setText("")
                itemsList.clear()
                itemsListAddon.clear()
                finalItemList = ""
                optionalItem = ""

            }

        }
    }
}