import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleCalculatorActivity extends Activity {
	EditText disp;
	Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bminus,binto,bby,bdot,bclear,bequals;
	float op1,op2;
	char op='\0';
	int state=1,decimalPoint=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        b0=(Button) findViewById(R.id.button0);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);
        b9=(Button) findViewById(R.id.button9);
        bplus=(Button) findViewById(R.id.buttonplus);
        bminus=(Button) findViewById(R.id.buttonminus);
        binto=(Button) findViewById(R.id.buttoninto);
        bby=(Button) findViewById(R.id.buttonby);
        bdot=(Button) findViewById(R.id.buttondot);
        bclear=(Button) findViewById(R.id.buttonclear);
        bequals=(Button) findViewById(R.id.buttonequals);
        disp=(EditText) findViewById(R.id.disp_result);
        
        b0.setOnClickListener(b0Listener);
        b1.setOnClickListener(b1Listener);
        b2.setOnClickListener(b2Listener);
        b3.setOnClickListener(b3Listener);
        b4.setOnClickListener(b4Listener);
        b5.setOnClickListener(b5Listener);
        b6.setOnClickListener(b6Listener);
        b7.setOnClickListener(b7Listener);
        b8.setOnClickListener(b8Listener);
        b9.setOnClickListener(b9Listener);
        bplus.setOnClickListener(bplusListener);
        bminus.setOnClickListener(bminusListener);
        binto.setOnClickListener(bintoListener);
        bby.setOnClickListener(bbyListener);
        bdot.setOnClickListener(bdotListener);
        bclear.setOnClickListener(bclearListener);
        bequals.setOnClickListener(bequalsListener);
    }
    private View.OnClickListener b0Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("0");
    	}
    };
    private View.OnClickListener b1Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("1");
    	}
    };
    private View.OnClickListener b2Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("2");
    	}
    };
    private View.OnClickListener b3Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("3");
    	}
    };
    private View.OnClickListener b4Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("4");
    	}
    };
    private View.OnClickListener b5Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("5");
    	}
    };
    private View.OnClickListener b6Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("6");
    	}
    };
    private View.OnClickListener b7Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("7");
    	}
    };
    private View.OnClickListener b8Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("8");
    	}
    };
    private View.OnClickListener b9Listener = new View.OnClickListener() {
    	public void onClick(View v) {
    		disp.append("9");
    	}
    };
    private View.OnClickListener bplusListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(disp.getText().toString().equals(""));
    		else if(state==1) {
    			op1=Float.parseFloat(disp.getText().toString());
    			op='+';
    			state++;
    			disp.setText("");
    		}
    		else {
    			op2=Float.parseFloat(disp.getText().toString());
    			try {
					op1=Float.parseFloat(perform(op,op1,op2));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (DivException e) {
					disp.setText(e.toString());
				}
    			disp.setText("");
    			op='+';
    			state++;
    			decimalPoint=0;
    		}
    	}
    };
    private View.OnClickListener bminusListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(disp.getText().toString().equals(""));
    		else if(state==1) {
    			op1=Float.parseFloat(disp.getText().toString());
    			op='-';
    			state++;
    			disp.setText("");
    		}
    		else {
    			op2=Float.parseFloat(disp.getText().toString());
    			try {
					op1=Float.parseFloat(perform(op,op1,op2));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (DivException e) {
					disp.setText(e.toString());
				}
    			disp.setText("");
    			op='-';
    			state++;
    			decimalPoint=0;
    		}
    	}
    };
    private View.OnClickListener bintoListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(disp.getText().toString().equals(""));
    		else if(state==1) {
    			op1=Float.parseFloat(disp.getText().toString());
    			op='*';
    			state++;
    			disp.setText("");
    		}
    		else {
    			op2=Float.parseFloat(disp.getText().toString());
    			try {
					op1=Float.parseFloat(perform(op,op1,op2));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (DivException e) {
					disp.setText(e.toString());
				}
    			disp.setText("");
    			op='*';
    			state++;
    			decimalPoint=0;
    		}
    	}
    };
    private View.OnClickListener bbyListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(disp.getText().toString().equals(""));
    		else if(state==1) {
    			op1=Float.parseFloat(disp.getText().toString());
    			op='/';
    			state++;
    			disp.setText("");
    		}
    		else {
    			op2=Float.parseFloat(disp.getText().toString());
    			try {
					op1=Float.parseFloat(perform(op,op1,op2));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (DivException e) {
					disp.setText(e.toString());
				}
    			disp.setText("");
    			op='/';
    			state++;
    			decimalPoint=0;
    		}
    	}
    };
    private View.OnClickListener bdotListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(!disp.getText().toString().equals("")) {
	    		disp.append(".");
	    		decimalPoint=1;
    		}
    	}
    };
    private View.OnClickListener bclearListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		op='\0';
    		state=1;
    		disp.setText("");
    		decimalPoint=0;
    	}
    };
    private View.OnClickListener bequalsListener = new View.OnClickListener() {
    	public void onClick(View v) {
    		if(state!=1) {
    			op2=Float.parseFloat(disp.getText().toString());
    			try {
					disp.setText(perform(op,op1,op2));
				} catch (DivException e) {
					disp.setText(e.toString());
				}
    			op='\0';
    			state=1;
    			decimalPoint=0;
    		}
    	}
    };
    String perform(char op,float op1,float op2) throws DivException {
    	switch(op) {
    		case '+' : return Float.toString(op1+op2);
    		case '-' : return Float.toString(op1-op2);
    		case '*' : return Float.toString(op1*op2);
    		case '/' : 		if(op2==0 && op1<0)
    							throw new DivException("-Infinity");
    						if(op2==0 && op1>0)
    							throw new DivException("+Infinity");
    						if(op2==0 && op1==0)
    							throw new DivException("Not defined");
    						return Float.toString(op1/op2);
    	}
		return null;
    }
}