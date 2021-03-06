package com.example.chris.strokere;

/**
 * Tip
 *
 * <P>Stores the information associated with each tip
 *
 * @author Sam Ward
 */

public class Tip {

    private String text;
    private String icon;
    private String intent;

        public Tip(String text, String icon, String intent){

            this.text = text;
            this.icon = icon;
            this.intent = intent;

        }

    /**
     * Gets the text associated with each tip
     * @return
     */
    public String getTipText(){

            return this.text;

        }

    /**
     * Gets the activity the tip is meant to direct to
     * @return
     */
    public String getTipIntent(){

            return this.intent;

        }

    /**
     * Currently unused method that can get a unique icon associated with each tip
     * @return
     */
    public String getTipIcon(){

        return this.icon;

    }

}
