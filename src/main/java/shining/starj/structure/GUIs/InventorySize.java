package shining.starj.structure.GUIs;

public enum InventorySize {
    One, Two, Three
    //
    ;

    public int getSize() {
        return (this.ordinal() + 1) * 9;
    }
}