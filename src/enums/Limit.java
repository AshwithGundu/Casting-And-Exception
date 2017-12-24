/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 * This Enum contains number of items student or faculty can check out
 *
 * @author Ashwith Gundu
 */
public enum Limit {

    /**
     * Item limit with value 4
     */
    Faculty(4),
    /**
     * Item limit with value 3
     */
    Student(3);
    /**
     * specifies the item limit
     */
    private final int itemLimit;

    /**
     * This getter method is used to access the item limit
     *
     * @return - int This returns item limit
     */
    private Limit(int itemLimit) {
        this.itemLimit = itemLimit;
    }

    /**
     *
     * @return itemLimit
     */
    public int getItemLimit() {
        return itemLimit;
    }

}
