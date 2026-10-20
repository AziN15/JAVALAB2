package com.smartlogistics;

public class FragileItem extends BaseCargo {
    private final boolean requiresSpecialHandling;

    public FragileItem(String id, String name, double weight, boolean requiresSpecialHandling) {
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }

    @Override
    public String getType() {
        return "FragileItem (special handling: " + requiresSpecialHandling + ")";
    }

    public boolean isRequiresSpecialHandling() {
        return requiresSpecialHandling;
    }
}
