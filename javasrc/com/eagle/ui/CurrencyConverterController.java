package com.eagle.ui;

import com.eagle.util.DistanceConverter;
import com.eagle.util.CurrencyConverter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 27/10/12
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurrencyConverterController {
    private CurrencyConverterPanel mPanel;
    private int state = 0;
    public static final int RSTOUSD = 0;
    public static final int USDTORS = 1;
    public CurrencyConverterController(){
        mPanel = new CurrencyConverterPanel();
        initListeners();
    }
    private void initListeners() {

        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                String amount = mPanel.getAmountTextField().getText();
                String rate = mPanel.getRateTextField().getText();
                updateResult(amount, rate);
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                String amount = mPanel.getAmountTextField().getText();
                String rate = mPanel.getRateTextField().getText();
                updateResult(amount, rate);
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                String amount = mPanel.getAmountTextField().getText();
                String rate = mPanel.getRateTextField().getText();
                updateResult(amount, rate);
            }
            public void updateResult(String amtStr, String rateStr){
                float amount = 0, rate = 0;
                try{
                    amount = Float.parseFloat(amtStr);
                    rate = Float.parseFloat(rateStr);
                }catch (NumberFormatException nfe)
                {
                    System.out.println("Invalid String / Null string");
                }
                float outputnum;
                if(state == RSTOUSD ){
                    outputnum = CurrencyConverter.convertRsToUsd(amount,rate);
                }else{
                    outputnum = CurrencyConverter.convertUsdToRs(amount, rate);
                }
                mPanel.setResult(outputnum,state);
            }
        };
        mPanel.getAmountTextField().getDocument().addDocumentListener(documentListener);
        mPanel.getRateTextField().getDocument().addDocumentListener(documentListener);
    }

    public CurrencyConverterPanel getPanel() {
        return mPanel;
    }
}