package com.matez.wildnature.gui.screen;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;

public class WNTextFieldWidget extends TextFieldWidget {
    private boolean acceptDouble = false, acceptFloat = false, acceptInt = false;
    public WNTextFieldWidget(FontRenderer fontIn, int p_i51137_2_, int p_i51137_3_, int p_i51137_4_, int p_i51137_5_, String msg) {
        super(fontIn, p_i51137_2_, p_i51137_3_, p_i51137_4_, p_i51137_5_, msg);
    }

    public void acceptDouble(boolean accept){
        this.acceptDouble=accept;
    }
    public void acceptFloat(boolean accept){
        this.acceptFloat=accept;
    }
    public void acceptInt(boolean accept){
        this.acceptInt=accept;
    }

    @Override
    public boolean charTyped(char p_charTyped_1_, int p_charTyped_2_) {
        if(acceptDouble || acceptFloat){
            if(!Character.isDigit(p_charTyped_1_) && p_charTyped_1_ != '.'  && p_charTyped_1_ != '~'){
                return false;
            }
        }
        if(acceptInt){
            if(!Character.isDigit(p_charTyped_1_) && p_charTyped_1_ != '~'){
                return false;
            }
        }

        setSuggestion("");

        return super.charTyped(p_charTyped_1_, p_charTyped_2_);
    }

    @Override
    public void setText(String textIn) {
        if(!textIn.isEmpty()){
            setSuggestion("");
        }
        super.setText(textIn);
    }
}
