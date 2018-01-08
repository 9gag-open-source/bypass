package in.uncod.android.bypass.style;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;

import in.uncod.android.bypass.Bypass;

/**
 * Created by raymond on 29/12/2017.
 */

public class BaseStyleAdapter implements StyleAdapter {
    @Override
    public Object[] createHeaderSpans(float[] headerSizes, int headerLevel) {
        return new Object[] {
                new RelativeSizeSpan(headerSizes[headerLevel]),
                new StyleSpan(Typeface.BOLD)
        };
    }

    @Override
    public Object[] createListSpans(int listIndent) {
        return new Object[] {
                new LeadingMarginSpan.Standard(listIndent)
        };
    }

    @Override
    public Object[] createEmphasisSpans() {
        return new Object[] {
                new StyleSpan(Typeface.ITALIC)
        };
    }

    @Override
    public Object[] createDoubleEmphasisSpans() {
        return new Object[] {
                new StyleSpan(Typeface.BOLD)
        };
    }

    @Override
    public Object[] createTripleEmphasisSpans() {
        return new Object[] {
                new StyleSpan(Typeface.BOLD_ITALIC)
        };
    }

    @Override
    public Object[] createBlockCodeSpans(int codeBlockIndent, String typefaceName) {
        return new Object[] {
                new LeadingMarginSpan.Standard(codeBlockIndent),
                new TypefaceSpan(typefaceName)
        };
    }

    @Override
    public Object[] createCodeSpans(String typefaceName) {
        return new Object[] {
                new TypefaceSpan(typefaceName)
        };
    }

    @Override
    public Object[] createLinkSpans(String url) {
        return new Object[] {
                new URLSpan(url)
        };
    }

    @Override
    public Object[] createAutoLinkSpans(String url) {
        return new Object[] {
                new URLSpan(url)
        };
    }

    @Override
    public Object[] createBlockQuoteSpans(int blockQuoteIndent, int quoteColor) {
        // We add two leading margin spans so that when the order is reversed,
        // the QuoteSpan will always be in the same spot.
        return new Object[] {
                new LeadingMarginSpan.Standard(blockQuoteIndent),
                new QuoteSpan(quoteColor),
                new LeadingMarginSpan.Standard(blockQuoteIndent),
                new StyleSpan(Typeface.ITALIC)
        };
    }

    @Override
    public Object[] createBlockQuoteTextStyleSpans() {
        return new Object[0];
    }

    @Override
    public Object[] createStrikethroguhSpans() {
        return new Object[] {
                new StrikethroughSpan()
        };
    }

    @Override
    public Object[] createHruleSpans(int hruleColor, int hruleSize, int hruleBottomPadding) {
        return new Object[] {
                new HorizontalLineSpan(hruleColor, hruleSize, hruleBottomPadding)
        };
    }

    @Override
    public Object[] createImageSpans(Bypass.Options options, Drawable drawable) {
        return new Object[] {
                new ImageSpan(drawable)
        };
    }
}
