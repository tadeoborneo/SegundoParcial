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

    public AislarException(UUID kitId, String neighborhood) {
        this.kitId = kitId;
        this.neighborhood = neighborhood;
    }

    @Override
    public String getMessage() {
        return "Risk person";
    }
}
