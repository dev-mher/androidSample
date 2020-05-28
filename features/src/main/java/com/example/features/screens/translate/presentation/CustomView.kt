package com.example.features.screens.translate.presentation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.example.features.R

class CustomView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        resolveAttrs(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        resolveAttrs(context, attrs)
    }

    @ColorInt
    private var _backgroundColor: Int = defaultBackgroundColor
    private val backgroundRectF = RectF()
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private fun resolveAttrs(context: Context, attrs: AttributeSet) {
        val typedArray = context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        try {
            _backgroundColor = typedArray.getColor(
                R.styleable.CustomView_cv_backgroundColor,
                _backgroundColor
            )
        } finally {
            typedArray.recycle()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (isViewVisible(w, h)) {
            calculateBackground()
        }
    }

    private fun isViewVisible(w: Int, h: Int) = w > 0 && h > 0

    private fun calculateBackground() {
        backgroundRectF.left = 0f
        backgroundRectF.top = 0f
        backgroundRectF.right = width.toFloat()
        backgroundRectF.bottom = height.toFloat()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom
        val measuredWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val measuredHeight = resolveSize(desiredHeight, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rectPaint.color = _backgroundColor
        canvas?.drawRoundRect(backgroundRectF, 40f, 40f, rectPaint)
    }

    companion object {
        const val defaultBackgroundColor = Color.GRAY
    }
}