package com.company;

import java.util.ArrayList;

/**
 * Created by Casey on 8/12/16.
 */
public class Board {
    int[] b;
    int size;

//    /* Reference:
//    UP_LT | UP_CT | UP_RT
//    CT_LT |       | CT_RT
//    DN_LT | DN_CT | DN_RT*/
//    protected static final int UP_LT = 0;
//    protected static final int UP_CT = 1;
//    protected static final int UP_RT = 2;
//    protected static final int CT_LT = 3;
//    protected static final int CT_RT = 4;
//    protected static final int DN_LT = 5;
//    protected static final int DN_CT = 6;
//    protected static final int DN_RT = 7;
//    protected static final int numDirections = 8;

    protected static final int LT = 0;
    protected static final int RT = 1;
    protected static final int numDirections = 2;

    public Board(int size){
        this.size = size;
        b = new int[size];
        //all position equal Othello.empty since default value of int is 0
        b[size/2-1] = Othello.BLACK;
        b[size/2] = Othello.WHITE;
    }

    public int[] getBoard(){
        return b;
    }

    public int getSize(){
        return size;
    }

    /**
     * for testing purposes only
     */
    public void setPosition(int player, int position){
        b[position] = player;
    }

    /**
     *  needs testing
     * @return
     *
     *
     */
    public Boolean isFull(){
        for(int i = 0; i < b.length; i++){
            if(b[i] == Othello.EMPTY){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getEmpties(){
        ArrayList<Integer> empties = new ArrayList<>();
        for (int j = 0; j < b.length ; j++) {
            if(b[j] == Othello.EMPTY){
                empties.add(j);
            }
        }
        return empties;
    }

    //check if it's valid move
    public boolean addPiece(int player, int position){
        //return false if position is already taken
        if(b[position] != 0){
            return false;
        }
        //check if pieces will be flipped, if yes, flip them
        boolean flipped = false;     //flag to see if any pieces heed to be flipped. If never true,-> invalid move
        //loop through directions looking for the one that the player wanted to flip
        for(int i = 0; i < numDirections; i++){
            ArrayList<Integer> dirArr = getDirectionArray(position, i);
            flipDirection(player, dirArr);
        }
        //return true if "any pieces r flipped"
        return flipped;
    }

    private boolean flipDirection(int player, ArrayList<Integer> directionArray){
        int otherPlayer = ( player == 1 ) ? 2 : 1;
        //check if the adjacent position is of opposite color
        if(directionArray.get(0) == player) return false;

        //find next of same color to flip toward
        for(int i = 1; i < directionArray.size(); i++){
            if(directionArray.get(i) == player){
                //flip(directionArray, i)
                return true;
            }
        }
        return false;
    }

    //flip pieces in directionArray from 0 to index
    private void flip(ArrayList directionArray, int index){

    }

    private ArrayList getDirectionArray(int pos, int dir){

        return null;
    }
}
