package entities.DTO;

public class ComboItem {
    private Long id;
    private String description;

    public ComboItem(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description; // Esto se mostrará en el JComboBox
    }
}