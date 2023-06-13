package com.example.myapplication.circle;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleProgressView extends View {
    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private String TAG = "CircleView";
    private Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint progressBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int progress = 0;
    private String color = "FFFFFF";

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //最外层白边
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(2f);
        borderPaint.setColor(Color.WHITE);
        //进度条背景
        progressBgPaint.setStyle(Paint.Style.STROKE);
        progressBgPaint.setStrokeWidth(60f);
        progressBgPaint.setColor(Color.parseColor("#D1D8F1"));
        //进度条
        progressPaint.setStrokeWidth(60f);
        progressPaint.setStyle(Paint.Style.STROKE);
        //中间白色圆
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.WHITE);
        //中间模糊弧形
        arcPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //取宽高最小的那个作为长度，因为要画圆，要求宽高相等
        int minLength = Math.min(getWidth(), getHeight());
        // 绘制最外层白边。半径为直径/2
        int borderRadius = minLength / 2;
        canvas.drawCircle(minLength / 2f, minLength / 2f, borderRadius, borderPaint);

        //绘制进度条背景。为了不遮挡白边
        //外层白边画笔的宽度 + 进度条背景画笔宽度的一半。最外边多余的部分
        //因为在绘制的时候，是以画笔宽度的中间为准，所以这里除以2
        float progressCenter = borderPaint.getStrokeWidth() + progressBgPaint.getStrokeWidth() / 2;
        //直径/2 减去 最外边多余的部分
        int progressRadius = (int) (minLength / 2 - progressCenter);
        canvas.drawCircle(minLength / 2f, minLength / 2f, progressRadius, progressBgPaint);

        //画进度条弧形。要求在一个矩形内画
        canvas.drawArc(
                progressCenter,
                progressCenter,
                minLength - progressCenter,
                minLength - progressCenter,
                -90f, -progress, false, progressPaint);

        //同上，是为了不让白色圆遮挡前面绘制的部分
        float diff = borderPaint.getStrokeWidth() + progressBgPaint.getStrokeWidth();
        //画白色圆
        int circleRadius = (int) (minLength / 2 - diff);
        canvas.drawCircle(minLength / 2f, minLength / 2f, circleRadius, circlePaint);

        //模糊处理
        arcPaint.setMaskFilter(new BlurMaskFilter(circleRadius / 3, BlurMaskFilter.Blur.NORMAL));
        canvas.drawArc(
                diff,
                diff,
                minLength - diff,
                minLength - diff,
                -90f, -progress, true, arcPaint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        if (progress > 90) {
            this.color = "38B866";
        } else {
            this.color = "FF643B";
        }

        progressPaint.setColor(Color.parseColor("#" + color));
        arcPaint.setColor(Color.parseColor("#30" + color));

        invalidate();
    }
}