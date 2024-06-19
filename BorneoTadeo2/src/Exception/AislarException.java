package Exception;

import java.util.UUID;

public class AislarException extends Exception {
    private UUID kitId;
    private String neighborhood;

    public UUID getKitId() {
        return kitId;
    }

    public void setKitId(UUID kitId) {
        this.kitId = kitId;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public AislarException(String message, UUID kitId, String neighborhood) {
        super(message);
        this.kitId = kitId;
        this.neighborhood = neighborhood;
    }
}
