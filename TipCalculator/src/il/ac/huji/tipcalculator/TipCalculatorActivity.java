package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	private static final double TIP_FACTOR = 0.12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        Button calc = (Button)findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText billEdt = (EditText)findViewById(R.id.edtBillAmount);
				CheckBox rndChk = (CheckBox)findViewById(R.id.chkRound);
				TextView resTxt = (TextView)findViewById(R.id.txtTipResult);
				
				double bill, result;
				String billStr = billEdt.getText().toString();
				if (billStr.isEmpty()) { // no input
					return;
				}
				bill = Double.parseDouble(billStr);
				result = bill * TIP_FACTOR;
				String resStr = rndChk.isChecked() ? String.format("%d", Math.round(result)) : String.format("%.2f", result);
				resTxt.setText("Tip: $"+resStr);			
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
