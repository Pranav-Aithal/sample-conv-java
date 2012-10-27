package com.eagle.ui;

import com.eagle.util.DistanceConverter;
import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 27/10/12
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class DistanceConverterController {


    private DistanceConverterPanel mPanel;
    private int state = 0; //0=km to miles, 1=miles to km
    public static final int KMTOMILES = 0;
    public static final int MILESTOKM = 1;
    public DistanceConverterController() {
        mPanel = new DistanceConverterPanel();
        initListeners();

    }

    private void initListeners() {

        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                String s = mPanel.getTextField().getText();

                updateResult(s);
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                String s = mPanel.getTextField().getText();
                updateResult(s);
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                String s = mPanel.getTextField().getText();
                updateResult(s);
            }
            public void updateResult(String s){
                float inputNum = 0;
                try{
                    inputNum  = Float.parseFloat(s);
                }
                catch(NumberFormatException nex)
                {
                    System.out.println("Invalid string or null");
                }
                float outputNum;
                if(state == KMTOMILES ){
                    outputNum = DistanceConverter.convertKmToMile(inputNum);
                }else{
                    outputNum = DistanceConverter.convertKmToMile(inputNum);
                }
                mPanel.setResult(outputNum,state);
            }


            //To change body of created methods use File | Settings | File Templates.
        };
        mPanel.getTextField().getDocument().addDocumentListener(documentListener);
    }

    public DistanceConverterPanel getPanel() {
        return mPanel;
    }
}
