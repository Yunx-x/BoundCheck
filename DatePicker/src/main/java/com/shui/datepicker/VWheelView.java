package com.shui.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shui.datepicker.utils.DatePickerUtils;

import java.util.ArrayList;
import java.util.List;

public class VWheelView extends ScrollView {
    public static final String TAG = VWheelView.class.getSimpleName();

    public interface OnWheelViewListener {
        void onSelected(int selectedIndex, String item);
    }


    private Context context;
//    private ScrollView scrollView;

    private LinearLayout views;

    public VWheelView(Context context) {
        super(context);
        init(context);
    }

    public VWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VWheelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    //    String[] items;
    List<String> items;

    private List<String> getItems() {
        return items;
    }

    public void setItems(List<String> list) {
        if (null == items) {
            items = new ArrayList<String>();
        }
        items.clear();
        items.addAll(list);

        // 前面和后面补全
        for (int i = 0; i < offset; i++) {
            items.add(0, "");
            items.add("");
        }

        initData();
    }

    public static final int OFF_SET_DEFAULT = 4;
    int offset = OFF_SET_DEFAULT; // 偏移量（需要在最前面和最后面补全）

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    int displayItemCount; // 每页显示的数量

    int selectedIndex = 1;

    private int measuredWidth;

    private void init(Context context) {
        this.context = context;
        this.setVerticalScrollBarEnabled(false);
        setOverScrollMode(OVER_SCROLL_NEVER);
        views = new LinearLayout(context);
        views.setOrientation(LinearLayout.VERTICAL);
        this.addView(views);

        scrollerTask = new Runnable() {
            public void run() {
                int newY = getScrollY();
                if (initialY - newY == 0) { // stopped
                    final int remainder = initialY % itemHeight;
                    final int divided = initialY / itemHeight;
                    if (remainder == 0) {
                        selectedIndex = divided + offset;
                        onSeletedCallBack();
                    } else {
                        if (remainder > itemHeight / 2) {
                            VWheelView.this.post(new Runnable() {
                                @Override
                                public void run() {
                                    VWheelView.this.smoothScrollTo(0, initialY - remainder + itemHeight);
                                    selectedIndex = divided + offset + 1;
                                    onSeletedCallBack();
                                }
                            });
                        } else {
                            VWheelView.this.post(new Runnable() {
                                @Override
                                public void run() {
                                    VWheelView.this.smoothScrollTo(0, initialY - remainder);
                                    selectedIndex = divided + offset;
                                    onSeletedCallBack();
                                }
                            });
                        }
                    }
                } else {
                    initialY = getScrollY();
                    VWheelView.this.postDelayed(scrollerTask, newCheck);
                }
            }
        };
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(measuredWidth, getMeasuredHeight());
    }

    int initialY;

    Runnable scrollerTask;
    int newCheck = 50;

    public void startScrollerTask() {
        initialY = getScrollY();
        this.postDelayed(scrollerTask, newCheck);
    }

    private void initData() {
        displayItemCount = offset * 2 + 1;
        views.removeAllViews();
        for (String item : items) {
            views.addView(createView(item));
        }

        refreshItemView(0);
    }

    int itemHeight = 0;

    private TextView createView(String item) {
        TextView tv = new TextView(context);
        tv.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setSingleLine(true);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        tv.setText(item);
        tv.setGravity(Gravity.CENTER);
        int padding = dip2px(8);
        tv.setPadding(padding, padding, padding, padding);
        if (0 == itemHeight) {
            itemHeight = getViewMeasuredHeight(tv);
            Log.d(TAG, "itemHeight: " + itemHeight);
            FrameLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, itemHeight * displayItemCount);
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            views.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DatePickerUtils.getScreenWidth(context) / 3, itemHeight * displayItemCount);
            llp.gravity = Gravity.CENTER_HORIZONTAL;
            this.setLayoutParams(llp);
        }
        return tv;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        refreshItemView(t);
        if (t > oldt) {
            scrollDirection = SCROLL_DIRECTION_DOWN;
        } else {
            scrollDirection = SCROLL_DIRECTION_UP;
        }
    }

    private void refreshItemView(int y) {
        int position = y / itemHeight + offset;
        int remainder = y % itemHeight;
        int divided = y / itemHeight;

        if (remainder == 0) {
            position = divided + offset;
        } else {
            if (remainder > itemHeight / 2) {
                position = divided + offset + 1;
            }
        }

        int childSize = views.getChildCount();
        for (int i = 0; i < childSize; i++) {
            TextView itemView = (TextView) views.getChildAt(i);
            if (null == itemView) {
                return;
            }
            if (position == i) {
                itemView.setTextColor(Color.BLACK);
            } else {
                itemView.setTextColor(Color.BLACK);
            }
        }
    }

    /**
     * 获取选中区域的边界
     */
    int[] selectedAreaBorder;

    private int[] obtainSelectedAreaBorder() {
        if (null == selectedAreaBorder) {
            selectedAreaBorder = new int[2];
            selectedAreaBorder[0] = itemHeight * offset;
            selectedAreaBorder[1] = itemHeight * (offset + 1);
        }
        return selectedAreaBorder;
    }

    private int scrollDirection = -1;
    private static final int SCROLL_DIRECTION_UP = 0;
    private static final int SCROLL_DIRECTION_DOWN = 1;

    Paint paint;
    int viewWidth;

    @Override
    public void setBackgroundDrawable(Drawable background) {
        if (viewWidth == 0) {
            viewWidth = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
            Log.d(TAG, "viewWidth: " + viewWidth);
        }

        if (null == paint) {
            paint = new Paint();
            paint.setColor(Color.parseColor("#D5D5D5"));
            paint.setStyle(Paint.Style.FILL);
        }

        background = new Drawable() {
            @Override
            public void draw(Canvas canvas) {
                canvas.drawRect(0f, obtainSelectedAreaBorder()[0] + 4, viewWidth, obtainSelectedAreaBorder()[1] - 4, paint);
            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter cf) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.UNKNOWN;
            }
        };
        super.setBackgroundDrawable(background);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "w: " + w + ", h: " + h + ", oldw: " + oldw + ", oldh: " + oldh + ",MW：" + measuredWidth);
        viewWidth = w;
        setBackgroundDrawable(null);
    }

    /**
     * 选中回调
     */
    private void onSeletedCallBack() {
        if (null != onWheelViewListener) {
            onWheelViewListener.onSelected(selectedIndex, items.get(selectedIndex));
        }
    }

    public void setSeletion(int position) {
        final int p = position;
        selectedIndex = p + offset;
        this.post(new Runnable() {
            @Override
            public void run() {
                VWheelView.this.smoothScrollTo(0, p * itemHeight);
            }
        });

    }

    public String getSeletedItem() {
        return items.get(selectedIndex);
    }

    public int getSeletedIndex() {
        return selectedIndex - offset;
    }


    @Override
    public void fling(int velocityY) {
        super.fling(velocityY / 3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            startScrollerTask();
        }
        return super.onTouchEvent(ev);
    }

    private OnWheelViewListener onWheelViewListener;

    public OnWheelViewListener getOnWheelViewListener() {
        return onWheelViewListener;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }

    private int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private int getViewMeasuredHeight(View view) {
        int width = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        view.measure(width, expandSpec);
        return view.getMeasuredHeight();
    }

}
