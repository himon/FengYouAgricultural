package com.louis.agricultural.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;

/**
 * Created by lc on 16/3/11.
 */
public class SpanUtil {

    /**
     * 文字设置删除线
     *
     * @param content
     * @param start
     * @param end
     * @return
     */
    public static SpannableStringBuilder strikethroughSpan(String content, int start, int end) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new StrikethroughSpan(), start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return ssb;
    }
}
