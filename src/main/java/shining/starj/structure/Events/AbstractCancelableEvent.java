package shining.starj.structure.Events;

import org.bukkit.event.Cancellable;

public abstract class AbstractCancelableEvent extends AbstractEvent implements Cancellable {
    private boolean canceled = false;
    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.canceled = cancelled;
    }
}
