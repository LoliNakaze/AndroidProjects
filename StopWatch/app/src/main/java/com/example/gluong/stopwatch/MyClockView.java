package com.example.gluong.stopwatch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gluong on 19/10/17.
 */

public class MyClockView extends View {
    private long elapsedTime;
    private static float _SHORT;
    private static float _LONG;
    private Point center;

    public MyClockView(Context context) {
        super(context);
    }

    public void setElapsedTime(long time) {
        elapsedTime = time;
        invalidate();
    }

    public MyClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyClockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    /* Value, in degrees : 0 to 360 */
    private void drawTick(Canvas c, float length, long value, Paint paint) {
        float angle = (float) (Math.PI / 2.0 - Math.toRadians(value));
        float x = (float) (((float) center.x) + length * Math.cos(angle));
        float y = (float) (((float) center.y) - length * Math.sin(angle));
        c.drawLine(center.x, center.y, x, y, paint);
    }

    @Override
    public void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        center = new Point(c.getWidth() / 2, c.getHeight() / 2);

        _LONG = c.getHeight() / 3;
        _SHORT = _LONG / 2;
        c.drawCircle(center.x, center.y, _LONG + 10, p);

        drawTick(c, _LONG, (elapsedTime % 60) * 6, p);
        drawTick(c, _SHORT, elapsedTime / 10, p);

        super.onDraw(c);
    }
}
