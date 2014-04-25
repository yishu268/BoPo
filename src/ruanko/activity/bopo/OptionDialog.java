package ruanko.activity.bopo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class OptionDialog extends Dialog{

    Context context;
    public OptionDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }
    public OptionDialog(Context context, int theme){
        super(context, theme);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.option_dialog);
    }

}
