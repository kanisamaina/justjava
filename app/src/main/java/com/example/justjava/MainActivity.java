package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int NumberOfCoffees=0;

    /**
     * This method calculates the total price of the order
     * @return total price of coffee
     */
    private int calculatePrice(boolean cream,boolean choc)
    {
        int total=NumberOfCoffees*5;
        if(cream==true)
        {
            total+=NumberOfCoffees*1;
        }
        if(choc==true) {
            total += NumberOfCoffees * 2;
        }
        return total;
    }
    /**
     * This method creates the summary of the order to be printed
     * @return The ordersummary message
     */
    public String createOrderSummary(int price,boolean hasWhippedCream,boolean chocolate,String name)
    {
        return "Name:"+name+"\nAdd Whipped Cream?:"+hasWhippedCream+"\nAdd Chocolate?:"+chocolate+"\nNumber Of Coffees:"+NumberOfCoffees+"\nTotal: $"+price+"\nThank You!";
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name=(EditText)findViewById(R.id.name);
        String value=name.getText().toString();

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolate=chocolateCheckBox.isChecked();
        int price=calculatePrice(hasWhippedCream,chocolate);
        displayMessage(createOrderSummary(price,hasWhippedCream,chocolate,value));
    }

    /**
     * This method is called when the increment button is clicked
     */
    public void increment(View view) {

        if(NumberOfCoffees==100){
            Toast.makeText(this,"Not available",Toast.LENGTH_SHORT).show();
            return;
        }
        NumberOfCoffees++;
        display(NumberOfCoffees);

    }
    /**
     * This method is called when the decrement button is clicked
     */
    public void decrement(View view) {
        if(NumberOfCoffees==1){
            Toast.makeText(this,"Not available",Toast.LENGTH_SHORT).show();
            return;
        }
        NumberOfCoffees--;
        display(NumberOfCoffees);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     *This method displays the given text on the screen.
     */

    private void displayMessage(String message) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        priceTextView.setText(message);

    }
}































