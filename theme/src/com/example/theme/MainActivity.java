package com.example.theme;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener {
	Animation myAnimation;
	ImageView imageView1;
	private ViewFlipper viewFlipper;

    private float startX;

    private Animation enter_lefttoright;

   
	private Animation exit_lefttoright;

    private Animation enter_righttoleft;
    private Animation exit_righttoleft;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.action_1);
        enter_lefttoright = AnimationUtils.loadAnimation(this, R.anim.enter_lefttoright);
        exit_lefttoright = AnimationUtils.loadAnimation(this, R.anim.exit_lefttoright);
        enter_righttoleft = AnimationUtils.loadAnimation(this, R.anim.enter_righttoleft);
        exit_righttoleft = AnimationUtils.loadAnimation(this, R.anim.exit_righttoleft);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.Button01).setOnClickListener(this);
        
      }
 public boolean onTouchEvent(MotionEvent event) {
        
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
        
            startX = event.getX();
         
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
           
            float endX = event.getX();
         
            if(endX > startX) {
               
                viewFlipper.setInAnimation(enter_lefttoright);
              
                viewFlipper.setOutAnimation(exit_lefttoright);
                
                viewFlipper.showNext();
           
            } else if (endX < startX) {
                viewFlipper.setInAnimation(enter_righttoleft);
                viewFlipper.setOutAnimation(exit_righttoleft);
              
                viewFlipper.showPrevious();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

      public void onClick(View v)
      {
        switch (v.getId())
        {
        case R.id.button1:
          Themes.changeToTheme(this, 1);
          break;
        case R.id.button2:
          Themes.changeToTheme(this, 2);
          break;
        case R.id.Button01:
          Themes.changeToTheme(this, 3);
          break;
        }
        
      }
    
}
