package shining.starj.structure.Items.Prework.Bags;

public enum InventorySize {
    One, Two, Three, Four, Five, Six
    //
    ;

    public int getSize() {
        return (this.ordinal() + 1) * 9;
    }
}
