package Models;

import java.util.UUID;

public class Kit {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Kit() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Kit{" +
                "id=" + id +
                '}';
    }
}
