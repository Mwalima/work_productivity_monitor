//package org.monitor.model;
//
//import javax.swing.text.Document;
//import java.awt.*;
//
//import static javax.swing.UIManager.getInsets;
//
//public class Placeholder{
//
//    private String placeholder;
//
//    public Placeholder() {
//    }
//
//    public Placeholder(
//            final Document pDoc,
//            final String pText,
//            final int pColumns)
//    {
//        super(pDoc, pText, pColumns);
//    }
//
//    public Placeholder(final int pColumns) {
//        super(pColumns);
//    }
//
//    public Placeholder(final String pText) {
//        super(pText);
//    }
//
//    public Placeholder(final String pText, final int pColumns) {
//        super(pText, pColumns);
//    }
//
//    public String getPlaceholder() {
//        return placeholder;
//    }
//
////    @Override
////    protected void paintComponent(final Graphics pG) {
////        super.clone(pG);
////
////        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
////            return;
////        }
////
////        final Graphics2D g = (Graphics2D) pG;
////        g.setRenderingHint(
////                RenderingHints.KEY_ANTIALIASING,
////                RenderingHints.VALUE_ANTIALIAS_ON);
////        g.setColor(getDisabledTextColor());
////        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
////                .getMaxAscent() + getInsets().top);
////    }
//
//    public void setPlaceholder(final String s) {
//        placeholder = s;
//    }
//}
