package in.uncod.android.bypass.style;

import android.graphics.drawable.Drawable;

import in.uncod.android.bypass.Bypass;

/**
 * Created by raymond on 29/12/2017.
 */

public interface StyleAdapter {
    Object[] createHeaderSpans(float[] headerSizes, int headerLevel);

    Object[] createListSpans(int listIndent);

    Object[] createEmphasisSpans();

    Object[] createDoubleEmphasisSpans();

    Object[] createTripleEmphasisSpans();

    Object[] createBlockCodeSpans(int codeBlockIndent, String typefaceName);

    Object[] createCodeSpans(String typefaceName);

    Object[] createLinkSpans(String url);

    Object[] createAutoLinkSpans(String url);

    Object[] createBlockQuoteSpans(int blockQuoteIndent, int quoteColor);

    Object[] createBlockQuoteTextStyleSpans();

    Object[] createStrikethroguhSpans();

    Object[] createHruleSpans(int hruleColor, int hruleSize, int hruleBottomPadding);

    Object[] createImageSpans(Bypass.Options options, Drawable drawable);
}
