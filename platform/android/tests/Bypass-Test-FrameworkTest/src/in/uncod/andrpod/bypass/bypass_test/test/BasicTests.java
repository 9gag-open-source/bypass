package in.uncod.andrpod.bypass.bypass_test.test;

import in.uncod.android.bypass.Bypass;
import android.graphics.Typeface;
import android.test.InstrumentationTestCase;
import android.text.Spannable;
import android.text.style.BulletSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;

public class BasicTests extends InstrumentationTestCase {

	Bypass bypass;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		bypass = new Bypass();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEmptyString() {
		bypass.markdownToSpannable("");
	}

	public void testHeaderString() {
		Spannable spannable = (Spannable) bypass.markdownToSpannable("Header!!\n--------");
		StyleSpan[] spans = spannable.getSpans(0, spannable.length(), StyleSpan.class);
		assertEquals(1, spans.length);
		RelativeSizeSpan[] sizeSpan = spannable.getSpans(0, spannable.length(), RelativeSizeSpan.class);
		assertEquals(1, sizeSpan.length);
		assertEquals('\n', spannable.charAt(spannable.length() - 1));
	}
	
	public void testBoldString() {
		Spannable spannable = (Spannable) bypass.markdownToSpannable("One **Two** Three");
		StyleSpan[] spans = spannable.getSpans(0, spannable.length(), StyleSpan.class);
		assertEquals(1, spans.length);
		assertEquals(Typeface.BOLD, spans[0].getStyle());
		assertEquals(4, spannable.getSpanStart(spans[0]));
		assertEquals(7, spannable.getSpanEnd(spans[0]));
	}
	
	public void testLinkString() {
		Spannable spannable = (Spannable) bypass.markdownToSpannable("[Link](https://github.com/Uncodin/bypass)");
		URLSpan[] spans = spannable.getSpans(0, spannable.length(), URLSpan.class);
		assertEquals(1, spans.length);
		assertTrue(spannable.toString().contains("Link"));
		assertEquals("https://github.com/Uncodin/bypass", spans[0].getURL());
	}
	
	public void testBullets() {
		Spannable spannable = (Spannable) bypass.markdownToSpannable("-\tOne\n-\tTwo\n");
		BulletSpan[] spans = spannable.getSpans(0, spannable.length(), BulletSpan.class);
		assertEquals(2, spans.length);
	}
}
